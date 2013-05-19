package com.hlb.darkarena.entity.mob;

import java.util.ArrayList;

import com.hlb.darkarena.entity.weapons.EnergyBall;
import com.hlb.darkarena.entity.weapons.Projectile;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;
import com.hlb.darkarena.input.Keyboard;
import com.hlb.darkarena.input.Mouse;
import com.hlb.darkarena.items.Items;

public class Player extends Mob {
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;
	private Sprite sprite;
	private Sprite spriteWeapon;
	private int counter1 = 0, counter2 = 0, counter3 = 0, counterAnim = 0;
	private ArrayList<Mob> mobsHit = new ArrayList<Mob>();
	private Mouse mouse;
	private int mouseX, mouseY;
	public ArrayList<Items> playerInventory = new ArrayList<Items>();
	public Items playerStuff[] = new Items[5];

	public Player(Keyboard input) 
	{
		this.input = input;
	}

	public Player(int x, int y, Keyboard input, Mouse mouse) 
	{
		this.x = x;
		this.y = y;
		this.input = input;
		this.mouse = mouse;
		health = maxHealth = 10;
	}
	
	/**
	 * On set la direction à celle de la souris.
	 */
	public void setDir()
	{
		double angleMouse = Math.atan2(mouseY - this.y, mouseX - this.x) * 180 / Math.PI;
		if (angleMouse >= -120 && angleMouse < -60) 
		{
			this.dir = 0;
		}
		if (angleMouse >= -60 && angleMouse < 60) 
		{
			this.dir = 1;
		}
		if (angleMouse >= 60 && angleMouse < 120) 
		{
			this.dir = 2;
		}
		if (angleMouse >= 120 || angleMouse < -120) 
		{
			this.dir = 3;
		}
		
	}

	/**
	 * Quand le joueur attaque.
	 */
	public void hit()
	{
		double angleMouse = Math.atan2(mouseY - this.y, mouseX - this.x) * 180
				/ Math.PI;
		int attackDir = 0;
		int mobDir = 0;

		if (angleMouse >= -120 && angleMouse < -60) 
		{
			attackDir = 0;
			System.out.println("En haut");
			this.dir = 0;
		}
		if (angleMouse >= -60 && angleMouse < 60) 
		{
			attackDir = 1;
			System.out.println("A droite");
			this.dir = 1;
		}
		if (angleMouse >= 60 && angleMouse < 120) 
		{
			attackDir = 2;
			System.out.println("En bas");
			this.dir = 2;
		}
		if (angleMouse >= 120 || angleMouse < -120) 
		{
			attackDir = 3;
			System.out.println("A gauche");
			this.dir = 3;
		}

		for (int i = 1; i < game.mobs.size(); i++)
		{
			double angleMob = Math.atan2(game.mobs.get(i).y - this.y, game.mobs.get(i).x - this.x) * 180 / Math.PI;
			double distanceMob = Math.sqrt(Math.pow(x - game.mobs.get(i).x, 2) + Math.pow(y - game.mobs.get(i).y, 2));
			System.out.println("Distance avec l'ID" + game.mobs.get(i).ID + " : " + distanceMob);

			if (angleMob >= -120 && angleMob < -60)
			{
				mobDir = 0;
				System.out.println("Mob en haut");
			}
			if (angleMob >= -60 && angleMob < 60) 
			{
				mobDir = 1;
				System.out.println("Mob à droite");
			}
			if (angleMob >= 60 && angleMob < 120)
			{
				mobDir = 2;
				System.out.println("Mob en bas");
			}
			if (angleMob >= 120 || angleMob < -120)
			{
				mobDir = 3;
				System.out.println("Mob à gauche");
			}

			if (distanceMob <= 40) 
			{
				if (attackDir == mobDir)
				{
					mobsHit.add(game.mobs.get(i));
				}
			}
		}

		for (int i = 0; i < mobsHit.size(); i++) 
		{
			mobsHit.get(i).isHit(2);
		}

	}
	
	public void shoot()
	{
		double angleMouse = Math.atan2(mouseY - this.y, mouseX - this.x);
		Projectile arrow = new EnergyBall(x, y, angleMouse, this);
		game.otherEntities.add(arrow);

	}

	/**
	 * Update du joueur.
	 */
	public void update() 
	{

		int xa = 0, ya = 0;
		mouseX = game.xMouse;
		mouseY = game.yMouse;
		counter1++;
		counter2++;
		counter3++;
		
		if (mouse.getMouseButton() == 1)
		{
			if (counter2 > 15)
			{
				hit();
				attacking = true;
				counter2 = 0;
			}
		}
		else if(attacking)
		{
			counterAnim++;
			if(counterAnim > 10) attacking = false;
		}
		
		if(mouse.getMouseButton() == 3)
		{
			if(counter3 > 20)
			{
				shoot();
				counter3 = 0;
			}
		}
		

		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		

		if (xa != 0 || ya != 0) 
		{
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

		if (counter1 > 20)
		{
			counter1 = 0;
			if (collided)
				this.isHit(1);
		}
		
		setDir();



		if (health <= 0) 
		{
			remove(this);
		}

	}
	
	public void addItem(Items item)
	{
		playerInventory.add(item);
	}
	
	public void removeItem(Items item)
	{
		playerInventory.remove(item);
	}

	/**
	 * Sprite du joueur et animation.
	 */
	public void render(Screen screen)
	{
		int xx = 0, yy = 0;
		if (dir == 0) 
		{
			sprite = Sprite.player_up;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_up1;
				} else {
					sprite = Sprite.player_up2;
				}
			}
		}
		if (dir == 1) 
		{
			sprite = Sprite.player_right;
			if (walking) 
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_right1;
				} else {
					sprite = Sprite.player_right2;
				}
			}
		}
		if (dir == 2)
		{
			sprite = Sprite.player_down;
			if (walking) 
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_down1;
				} else {
					sprite = Sprite.player_down2;
				}
			}
		}
		if (dir == 3) 
		{
			sprite = Sprite.player_left;
			if (walking)
{
				if (anim % 20 > 10) 
				{
					sprite = Sprite.player_left1;
				} else {
					sprite = Sprite.player_left2;
				}
			}
		}
		if(attacking)
		{
			if(dir == 0){
				spriteWeapon = Sprite.sword_up;
				xx = x - 16;
				yy = y - 26;
			}
			else if(dir == 1){
				spriteWeapon = Sprite.sword_right;
				yy = y - 8;
				xx = x;
			}
			else if(dir == 2){
				spriteWeapon = Sprite.sword_down;
				xx = x - 12;
				yy = y + 7;
			}
			else if(dir == 3){
				spriteWeapon = Sprite.sword_left;
				xx = x - 30;
				yy = y - 8;
			}
			screen.renderMob(xx, yy, spriteWeapon);
		}
		screen.renderPlayer(x-16, y-16, sprite);

	}

}
