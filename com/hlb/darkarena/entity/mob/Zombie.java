package com.hlb.darkarena.entity.mob;

import com.hlb.darkarena.Game;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;

public class Zombie extends Mob
{
	private Sprite sprite;
	private boolean walking = false;
	private int counter = 0;

	
	public Zombie(int x, int y)
	{
		this.x = x;
		this.y = y;
		health = maxHealth = 5;
	}
	
	
	public void update()
	{
		int xa = 0, ya = 0;
		
		counter++;
		if(counter > 2)
		{
			if(game.xPlayer > x) xa++;
			if(game.xPlayer < x) xa--;
			if(game.yPlayer > y) ya++;
			if(game.yPlayer < y) ya--;
			counter = 0;
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
	
	
	public void render(Screen screen)
	{
		int xx = x - 16;
		int yy = y -16;
		
		if(dir == 0)
		{
			sprite = Sprite.zombie_up;
		}
		if(dir == 1)
		{
			sprite = Sprite.zombie_right;
		}
		if(dir == 2)
		{
			sprite = Sprite.zombie_down;
		}
		if(dir == 3)
		{
			sprite = Sprite.zombie_left;
		}
		
		screen.renderMob(xx, yy, sprite);
	}

	
}
