package com.hlb.darkarena.entity.IA.pathFinding;

public class Node {
	private int x, y;
	private int g, h, f;
	private Node parent;
	
	public Node()
	{
		g = h = f = 0;
		parent = this;
	}
	
	/**
	 * Getter Nodes.
	 */
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	public void setG(int g)
	{
		this.g = g;
	}
	public void setH(int h)
	{
		this.h = h;
	}
	public void setF(int f)
	{
		this.f = f;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	
	/**
	 * Setters Nodes.
	 */
	public Node getParent(){
		return parent;
	}
	public int getG(){
		return g;
	}
	public int getF(){
		return f;
	}
	public int getH(){
		return h;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	
	

}
