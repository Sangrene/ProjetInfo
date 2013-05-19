package com.hlb.darkarena.graphics;

import java.util.Random;

import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.items.gui.GuiItems;
import com.hlb.darkarena.level.tile.Tile;

public class Screen
{
	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	public int xOffset, yOffset;
	
	private Random random = new Random();
	
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		

	}

	public void clear()
	{
		for (int i = 0; i<pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}
	
	
	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++)
		{
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite)
	{
		xp -= xOffset;
		yp -= yOffset;
		
		
		for(int y = 0; y < sprite.SIZE; y++)
		{
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++)
			{
				int xa = x + xp;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if(col != 0xffffff)
				{
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite)
	{
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 32; y++)
		{
			int ya = y + yp;
			for(int x = 0; x < 32; x++)
			{
				int xa = x + xp;
				if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int col = sprite.pixels[x + y * 32];
				if(col != 0xffffff)
				{
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public void renderInventory(GuiItems guiItems)
	{
		for(int y = 0; y < 133; y++)
		{
			for(int x = 0; x < 133; x++)
			{
				if(x < -133 || x >= width || y < 0 || y >= height) break;
				if(x < 0) x = 0;
				pixels[x + (133/2 + 10) + (y + 10)* width] = guiItems.pixels[x + y * 133];
			}
		}
	}
	
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
