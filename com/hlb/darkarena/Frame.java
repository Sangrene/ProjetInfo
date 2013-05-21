package com.hlb.darkarena;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	public Frame()
	{		
		Game game = new Game(this);
		setResizable(false);
		setTitle(Game.title);
		add(game);
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
