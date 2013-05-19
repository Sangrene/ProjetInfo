package com.hlb.darkarena.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{

	private static int mouseX = -1, mouseY = -1, mouseButton = -1;
	
	public static int getMouseX()
	{
		return mouseX;
	}
	
	public static int getMouseY()
	{
		return mouseY;
	}
	
	public static int getMouseButton()
	{
		return mouseButton;
	}
	
	
	public void update()
	{

	}
	
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseButton = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseButton = -1;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

}
