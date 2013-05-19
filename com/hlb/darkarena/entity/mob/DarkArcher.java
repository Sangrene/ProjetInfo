package com.hlb.darkarena.entity.mob;

import com.hlb.darkarena.entity.weapons.EnergyBall;
import com.hlb.darkarena.entity.weapons.Projectile;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;

public class DarkArcher extends Mob
{

	private Sprite sprite;
	private boolean walking = false;
	private int xa, ya;
	private int counter = 0, counter2 = 0;
	
	public DarkArcher(int x, int y)
	{
		this.x = x;
		this.y = y;
		health = maxHealth = 4;
	}
	
	public void update()
	{
		xa = ya = 0;
		
		counter++;
		counter2++;
		if(counter > 60)
		{
			shoot();
			counter = 0;
		}
		if(counter2 > 3)
		{
			positioning();
			counter2 = 0;
		}
		
		if(xa != 0 || ya != 0)  {
			move (xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		if(health <= 0)
		{
			remove(this);
		}
	}
	
	public void shoot()
	{
		double distance = Math.sqrt(Math.pow(x - game.xPlayer, 2) + Math.pow(y - game.yPlayer, 2));
		double angle = (Math.atan2(game.yPlayer - this.y, game.xPlayer - this.x)/** * 180 / Math.PI*/);
		if(distance < 80)
		{
			Projectile arrow = new EnergyBall(x, y, angle, this);
			game.otherEntities.add(arrow);
		}
	}
	
	public void positioning()
	{
		double distance = Math.sqrt(Math.pow(x - game.xPlayer, 2) + Math.pow(y - game.yPlayer, 2));
		if(distance > 70);
		{
			if(game.xPlayer > x) xa++;
			if(game.xPlayer < x) xa--;
			if(game.yPlayer > y) ya++;
			if(game.yPlayer < y) ya--;
		}
	}
	
	public void render(Screen screen)
	{
		int xx = x - 16;
		int yy = y -16;
		
		if(dir == 0)
		{
			sprite = Sprite.dArcher_up;
		}
		if(dir == 1)
		{
			sprite = Sprite.dArcher_right;
		}
		if(dir == 2)
		{
			sprite = Sprite.dArcher_down;
		}
		if(dir == 3)
		{
			sprite = Sprite.dArcher_left;
		}
		
		screen.renderMob(xx, yy, sprite);
	}
}
