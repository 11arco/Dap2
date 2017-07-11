package Blatt12;

import java.util.*;
import java.io.*;

public class Graph {
	private ArrayList<Node> nodes = new ArrayList<Node>(0);

	public Graph() {
		System.out.println("new Graph");
	}

	public boolean contains(int id) {
		if (nodes == null) {
			return false;
		}
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getId() == id) {
				return true;
			}
		}
		return false;

	}

	public void addNode(int id) {
		if (!this.contains(id)) {
			nodes.add(new Node(id));
		}
	}

	public Node getNode(int id) {
		for (int i = 0; i < nodes.size(); i++) {
			if (this.nodes.get(i).getId() == id) {
				return this.nodes.get(i);
			}
		}
		System.out.println("Es exsistiert keine Node mit ID: " + id);
		return null;
	}

	public void addEdge(int src, int dst) {
		if (this.contains(src) && this.contains(dst)) {
			this.getNode(src).add(this.getNode(dst));
			this.getNode(dst).add(this.getNode(src));
		}
	}

	public static Graph fromFile(String filepath) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filepath, "r");
		String zeile = file.readLine();
		StringTokenizer st = new StringTokenizer(zeile, ",");
		int src;
		int dst;
		Graph g = new Graph();
		while (!(zeile == null)) {
			st = new StringTokenizer(zeile, ",");
			src = Integer.parseInt(st.nextToken());
			dst = Integer.parseInt(st.nextToken());
			System.out.println(src + "," + dst);
			if (!g.contains(src)) {
				g.addNode(src);
			}
			if (!g.contains(dst)) {
				g.addNode(dst);
			}
			g.addEdge(src, dst);
			zeile = file.readLine();

		}
		System.out.println("yeay");
		return g;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

}
