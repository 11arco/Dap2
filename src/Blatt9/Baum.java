package Blatt9;

public class Baum {
	Baum leftChidl;
	Baum rightChild;
	int content;

	public Baum(int c) {
		this.content = c;
	}

	public Baum() {
		// leer
	}

	public void add(int a) {

		if (a > this.content) {
			if (!this.hasRightChild()) {
				this.rightChild = new Baum(a);
			} else {
				rightChild.add(a);
			}
		} else {
			if (!this.hasLeftChild()) {
				this.leftChidl = new Baum(a);
			} else {
				leftChidl.add(a);
			}
		}
	}

	public boolean isLeaf() {
		if (!hasLeftChild() && !hasRightChild()) {
			return true;
		}
		return false;
	}

	public boolean hasLeftChild() {
		if (this.leftChidl != null) {
			return true;
		}
		return false;
	}

	public boolean hasRightChild() {
		if (this.rightChild != null) {
			return true;
		}
		return false;
	}

	public void preOrder() {
		System.out.print(content+", ");

		if (hasLeftChild()) {
			this.leftChidl.preOrder();
		}
		if (hasRightChild()) {
			this.rightChild.preOrder();
		}
	}

	public void inOrder() {

		if (hasLeftChild()) {
			this.leftChidl.inOrder();
		}

		System.out.print(content+", ");
		if (hasRightChild()) {
			this.rightChild.inOrder();
		}

	}

	public void postOrder() {

		if (hasLeftChild()) {
			this.leftChidl.postOrder();
		}
		if (hasRightChild()) {
			this.rightChild.postOrder();
		}
		System.out.print(content+", ");

	}

}
