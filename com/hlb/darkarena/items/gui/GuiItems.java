package com.hlb.darkarena.items.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.hlb.darkarena.Game;
import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.items.Items;

public class GuiItems extends JPanel
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
		
		Dimension size = new Dimension(w*game.scale, h*game.scale);
		setPreferredSize(size);

	}
	
	public void drawInventory()
	{
		
	}
	
	
	public void loadBackGround()
	{
		
	}
	
	
}
