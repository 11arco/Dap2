package Blatt12;

import java.util.ArrayList;

public class Node {
	private ArrayList<Edge> nodes = new ArrayList<Edge>();
	private int id;

	public Node(int id) {
		this.id = id;
	}

	public void add(Node dst) {
		nodes.add(new Edge(this, dst));
	}

	public boolean equals(Object other) {
		try {
		} catch (Exception e) {
			System.out.println(e);
		}
		if (other instanceof Node) {
			Node node = (Node) other;
			if (node.getId() == this.getId()) {
				return true;
			}

		} else {
			System.out.println("Vergleiche wird nicht mit einer Node ausgeführt");
		}
		return false;
	}

	public ArrayList<Edge> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Edge> nodes) {
		this.nodes = nodes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
