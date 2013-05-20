package com.hlb.darkarena.entity.weapons;

import com.hlb.darkarena.entity.mob.Mob;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;

public class EnergyBall extends Projectile
{

	private boolean hasHit = false;
	
	public EnergyBall(int x, int y, double dir, Mob shooter) {
		super(x, y, dir, shooter);
		speed = 4;
		sprite = Sprite.energyBall;
		damage = 1;
		nx = speed * Math.cos(angle);
		ny = speed *Math.sin(angle);
		
	}
	
	public void damage()
	{
		for(int i = 0; i < game.mobs.size(); i++)
		{
			if(shooter != game.mobs.get(i))
			{
				double distance = Math.sqrt(Math.pow(x - game.mobs.get(i).x, 2) + Math.pow(y - game.mobs.get(i).y, 2));
				if(distance < 16)
				{
					game.mobs.get(i).isHit(damage);
					hasHit = true;
				}
			}
		}
	}
	
	public void move()
	{
		x += nx;
		y += ny;
	}
	
	public void update()
	{
		move();

		if (!hasHit)
		{
			damage();
		}
		else
		{
			remove(this);
		}
	}
	
	public void render(Screen screen)
	{
		screen.renderMob(x - 8, y - 8, sprite);
	}

}
