package com.hlb.darkarena.entity.mob;

import com.hlb.darkarena.entity.Entity;
import com.hlb.darkarena.graphics.Sprite;
import com.hlb.darkarena.input.Mouse;

public abstract class Mob extends Entity
{
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean attacking = false;
	protected boolean collided;
	public boolean isHit = false;
	protected int health, maxHealth;
	
	
		
	public void move(int xa, int ya)
	{

		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;


		collided = false;

		mobCollision();

		if(!tileCollision(xa, 0) && !collided)
		{
			x += xa;
		}
		if(!tileCollision(0, ya) && !collided)
		{
			y += ya;
		}
	}
	

	public void update()
	{
		
	}
	
	private boolean tileCollision(int xa, int ya)
	{
		boolean solid = false;

		for(int c = 0; c < 4; c++)
		{
			int xt = ((x + xa) + c % 2 * 12 - 7)/ 16;
			int yt = ((y + ya) + c / 2 * 12 + 2)/ 16;
			
			if(level.getTile(xt, yt).solid()) solid = true;
		}
		
		return solid;
	}
	
	
	public void mobCollision()
	{
		for(int i = 0; i < game.mobs.size(); i++)
		{
			if(game.mobs.get(i).ID != this.ID)
			{
				double distance = Math.sqrt(Math.pow(x-game.mobs.get(i).x, 2) + Math.pow(y - game.mobs.get(i).y, 2));
				if(distance <= 16)
				{

					game.mobs.get(i).collided = true;
					collided = true;

					if((x - game.mobs.get(i).x >= -16) && x - game.mobs.get(i).x < 0)
					{
						x -= 8;
						game.mobs.get(i).x += 8;
					}
					
					if((game.mobs.get(i).x - x >= -16) && game.mobs.get(i).x - x < 0)
					{
						x += 8;
						game.mobs.get(i).x -= 8;
					}
					
					if((y - game.mobs.get(i).y >= -16) && y - game.mobs.get(i).y < 0)
					{
						y -= 8;
						game.mobs.get(i).y += 8;
					}
					
					if((game.mobs.get(i).y - y <= 16) && game.mobs.get(i).y - y < 0)
					{
						y += 8;
						game.mobs.get(i).y -= 8;
					}
					
				}
			}
		}
			
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public void isHit(int damage)
	{
		health -= damage;
	}
	
	
	public void render()
	{
		
	}

}
