package com.hlb.darkarena.informationsPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.hlb.darkarena.Game;
import com.hlb.darkarena.items.Items;

public class GuiInfo extends JPanel
{	
	public static int width, height;
	private ArrayList<Items> playerInventory = new ArrayList<Items>();
	private Game game;

	public GuiInfo(Game game)
	{
		this.game = game;
		width = game.width / 6;
		height = game.height;
		
		Dimension size = new Dimension(width*game.scale, height*game.scale);
		setPreferredSize(size);
		
		setBackground(Color.black);
		
	}
}
