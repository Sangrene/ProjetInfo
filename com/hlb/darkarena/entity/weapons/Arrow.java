package com.hlb.darkarena.entity.weapons;

import com.hlb.darkarena.entity.mob.Mob;

public class Arrow extends Projectile
{

	private boolean asHit;
	
	public Arrow(int x, int y, double dir, Mob shooter) {
		super(x, y, dir, shooter);
		speed = 4;
		sprite = sprite.arrow;
	}
	
	
	
	

}
