package Blatt12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		try {
			Graph.fromFile(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	public void bfs(Graph g, int id) {
		ArrayList<String> color = new ArrayList<String>();
		int[] distanceToStart = new int[g.getNodes().size()];
		LinkedList<Node> que = new LinkedList<Node>();
		que.add(g.getNode(id));
		Node u;
		for (int i : distanceToStart) {
			distanceToStart[i] = -1;
		}
		while (!que.isEmpty()) {
			u = que.getFirst();
			for (Node v : que) {
				if (color.get(v.getId()) == "weiß") {
					color.set(v.getId(), "grau");

				}
			}
		}

	}
}
