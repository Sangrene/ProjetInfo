package com.hlb.darkarena.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	/** Tiles sprites */
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite dirt = new Sprite(16, 0, 0, SpriteSheet.tiles);

	
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	/** Player sprites */
	
	public static Sprite player_up = new Sprite(32, 0, 5, SpriteSheet.mobs);
	public static Sprite player_right = new Sprite(32, 1, 5, SpriteSheet.mobs);
	public static Sprite player_down = new Sprite(32, 2, 5, SpriteSheet.mobs);
	public static Sprite player_left = new Sprite(32, 3, 5, SpriteSheet.mobs);
	
	public static Sprite player_up1 = new Sprite(32, 0, 6, SpriteSheet.mobs);
	public static Sprite player_up2 = new Sprite(32, 0, 7, SpriteSheet.mobs);
	public static Sprite player_right1 = new Sprite(32, 1, 6, SpriteSheet.mobs);
	public static Sprite player_right2 = new Sprite(32, 1, 7, SpriteSheet.mobs);
	public static Sprite player_down1 = new Sprite(32, 2, 6, SpriteSheet.mobs);
	public static Sprite player_down2 = new Sprite(32, 2, 7, SpriteSheet.mobs);
	public static Sprite player_left1 = new Sprite(32, 3, 6, SpriteSheet.mobs);
	public static Sprite player_left2 = new Sprite(32, 3, 7, SpriteSheet.mobs);
	
	public static Sprite sword_up = new Sprite(32, 0, 4, SpriteSheet.mobs);
	public static Sprite sword_right = new Sprite(32, 1, 4, SpriteSheet.mobs);
	public static Sprite sword_down = new Sprite(32, 2, 4, SpriteSheet.mobs);
	public static Sprite sword_left = new Sprite(32, 3, 4, SpriteSheet.mobs);

	
	/** Zombie sprites */
	public static Sprite zombie_up = new Sprite(32, 4, 5, SpriteSheet.mobs);
	public static Sprite zombie_right = new Sprite(32, 5, 5, SpriteSheet.mobs);
	public static Sprite zombie_down = new Sprite(32, 6, 5, SpriteSheet.mobs);
	public static Sprite zombie_left = new Sprite(32, 7, 5, SpriteSheet.mobs);
	
	/** DarkArcher sprites */
	public static Sprite dArcher_up = new Sprite(32, 0, 0, SpriteSheet.mobs);
	public static Sprite dArcher_right = new Sprite(32, 1, 0, SpriteSheet.mobs);
	public static Sprite dArcher_down = new Sprite(32, 2, 0, SpriteSheet.mobs);
	public static Sprite dArcher_left = new Sprite(32, 3, 0, SpriteSheet.mobs);
	
	/** Weapons sprites */
	public static Sprite arrow = new Sprite(16, 0, 0, SpriteSheet.items);
	public static Sprite energyBall = new Sprite(16,0,1,SpriteSheet.items);



	
	/** Constructeurs taille, x, y, le SpriteSheet correspondant */
	
	public Sprite(int size, int x, int y, SpriteSheet sheet)
	{
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color)
	{
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	/** On donne les couleurs de chaque pixels du tableaux */
	
	private void setColor(int color)
	{
		for(int i = 0; i < SIZE*SIZE; i++)
		{
			pixels[i] = color;
		}
	}
	
	private void load()
	{
		for(int y = 0; y < SIZE; y++)
		{
			for(int x= 0; x<SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
				
			}
		}
	}

}
