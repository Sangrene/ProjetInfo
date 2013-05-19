package com.hlb.darkarena.entity;

import java.util.Random;

import com.hlb.darkarena.Game;
import com.hlb.darkarena.entity.mob.Mob;
import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.level.Level;

public abstract class Entity 
{
	public int x, y;
	public int ID;
	private boolean removed = false;
	protected Level level;
	protected Game game;
	protected final Random random = new Random();
	
	public void update()
	{
		
	}
	
	public void render(Screen screen)
	{
		
	}
	
	/** Fonctions pour supprimer les entités */
	
	public void remove(Entity entity)
	{
		if(entity != null)
		{
			if (entity instanceof Player)
				{game.stop();}
			else if (entity instanceof Mob)
				{game.mobs.remove(entity);}
			else{
				game.otherEntities.remove(entity);
			}
		}
	}
	
	public boolean isRemoved()
	{
		return removed;
	}
	
	public void newEntity(Game game, Level level, int ID)
	{
		this.level = level;
		this.game = game;
		this.ID = ID;
	}

}
