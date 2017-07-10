package Blatt12;

public class Edge {
	private Node src;
	private Node dst;

	public Edge(Node src, Node dst) {
		this.setSrc(src);
		this.setDst(dst);
	}

	public Node getDst() {
		return dst;
	}

	public void setDst(Node dst) {
		this.dst = dst;
	}

	public Node getSrc() {
		return src;
	}

	public void setSrc(Node src) {
		this.src = src;
	}

	
}
