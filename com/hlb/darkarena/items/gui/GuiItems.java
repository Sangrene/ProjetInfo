package com.hlb.darkarena.items.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.hlb.darkarena.Game;
import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.items.Items;

public class GuiItems
{
	private ArrayList<Items> playerInventory = new ArrayList<Items>();
	private Player player;
	private Game game;
	private Graphics g;
	public int pixels[];
	public int w = 133, h = 133;
	private BufferedImage image;
	private Screen screen;
	
	
	public GuiItems(Game game, Player player, Screen screen)
	{
		this.game = game;
		this.player = player;
		this.screen = screen;
		playerInventory = player.playerInventory;
		pixels = new int[w * h];
		drawInventory();
	}
	
	public void drawInventory()
	{
		loadBackGround();
		
		screen.renderInventory(this);
	}
	
	
	public void loadBackGround()
	{
		try {
			image = ImageIO.read(GuiItems.class.getResource("/textures/items/itemmenu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image.getRGB(0, 0, w, h, pixels, 0, w);
	}
	
	
}
