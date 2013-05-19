package com.hlb.darkarena.items;

import java.awt.Image;

import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.graphics.Sprite;

public abstract class Items
{
	protected String name;
	protected int ID;
	public static Items[] items;
	public Image image;
	
	public Items(String name, int ID, Image image)
	{
		this.image = image;
	}
	
	
	public void addItem(Player player, Items item)
	{
		player.playerInventory.add(item);
	}
	
	public void removeItem(Player player, Items item)
	{
		player.playerInventory.remove(item);
	}
	
	
}
