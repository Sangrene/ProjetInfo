package com.hlb.darkarena.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, escape;
	public int lastKeyPressed;

	
	/** Correspondance des booleans avec les touches */
	public void update()
	{
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
	}
	
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		lastKeyPressed = e.getKeyCode();
		if(e.getKeyCode() == e.VK_ESCAPE && !escape) escape = true;
		else if(e.getKeyCode() == e.VK_ESCAPE && escape) escape = false;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	public void keyTyped(KeyEvent e) {
		
	}

}
