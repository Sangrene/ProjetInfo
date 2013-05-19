package com.hlb.darkarena.entity.IA;

import java.util.ArrayList;

import com.hlb.darkarena.level.Level;
import com.hlb.darkarena.level.tile.Tile;

public class PathFinding
{
	public static ArrayList AStar(int xStart, int yStart, int xEnd, int yEnd, Level level)
	{
		ArrayList openList = new ArrayList();
		ArrayList closedList = new ArrayList();
		
		ArrayList finalPath = new ArrayList();
		
		openList.add(level.getTile(xStart, yStart));
		
		Tile currentNode = null;
		
		while(openList.size() > 0)
		{
			
		}
		
		
		return finalPath;
	}
	
}
