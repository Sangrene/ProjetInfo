package com.hlb.darkarena.level.tile;

import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.graphics.Sprite;

public class Tile 
{
	public int x, y;
	public Sprite sprite;
	public int g; //* Distance parcouru entre le tile de départ et le tile actuel
	public int h; //* Distance à vol d'oiseau entre le tile de départ et le tile d'arrivé
	public int f = g + h; //* Poids
	public Tile parent;
	
	/** On déclare les Tiles comme si dessous*/
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile dirt = new DirtTile(Sprite.dirt);
	
	public static Tile voidTile = new voidTile(Sprite.voidSprite);
	
	/** Constructeur des Tile, leur seul argument est le sprite*/
	
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}
	
	
	
	public void render(int x, int y, Screen screen){}
	
	/** Est-ce que le tile est solide */
	
	public boolean solid(){return false;}
	
	
}
