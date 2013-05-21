package com.hlb.darkarena;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.hlb.darkarena.informationsPanel.GuiInfo;

public class Frame extends JFrame
{
	public static int width = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3 - 2;
	public static int height = width/16*9;
	
	public Frame()
	{		
		setSize(width, height);
		Game game = new Game(this);
		GuiInfo guiInfo = new GuiInfo(game);
		setResizable(false);
		setTitle(Game.title);
		JSplitPane container = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		container.add(game);
		container.add(guiInfo);
		container.setEnabled(false);
		add(container);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		game.start();
	}
	
	public static void main(String[] args)
	{
		Frame frame = new Frame();
	}
}
