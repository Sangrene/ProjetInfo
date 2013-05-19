package com.hlb.darkarena.entity.weapons;

import com.hlb.darkarena.entity.Entity;
import com.hlb.darkarena.entity.mob.Mob;
import com.hlb.darkarena.graphics.Sprite;

public abstract class Projectile extends Entity
{
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed;
	protected int damage;
	protected Mob shooter;
	
	public Projectile(int x, int y, double dir, Mob shooter)
	{
		xOrigin = x;
		yOrigin = y;
		this.x = x;
		this.y = y;
		angle = dir;
		this.shooter = shooter;
	}
}
