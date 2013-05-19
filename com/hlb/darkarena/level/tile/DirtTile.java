package com.hlb.darkarena.level.tile;

import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;

public class DirtTile extends Tile {

	public DirtTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 4, y << 4, this);
	}

}
