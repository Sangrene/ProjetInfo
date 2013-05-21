package com.hlb.darkarena.entity.IA.pathFinding;

import java.util.ArrayList;

public class aStar {
	public static int NODE_DISTANCE_VALUE = 100;

	private static ArrayList openList;
	private static ArrayList closeList;

	public static ArrayList findPath(ArrayList graph, Node start, Node end) {
		openList = new ArrayList();
		closeList = new ArrayList();

		ArrayList finalPath = new ArrayList();

		openList.add(start);
		Node currentNode = null;
		while (openList.size() > 0) {

		}

		return finalPath;
	}

	private static Node getCurrentNode() {
		ArrayList tmpList = new ArrayList();
		int maximum = openList.size();
		int minF = 2000000000;
		Node curNode = null;
		for (int i = 0; i < maximum; i++) {
			Node node = (Node) openList.get(i);
			if (node.getF() < minF) {
				minF = node.getF();
				curNode = node;
			}
		}
		return curNode;
	}
	
	private static ArrayList getNeighbours(Node node, ArrayList graph)
	{
		ArrayList neighbours = new ArrayList();
		//int maxX = graph.;
		
		return neighbours;
	}
}
