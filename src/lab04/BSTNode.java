package lab04;

public class BSTNode {

	private Dollar dollar;
	private BSTNode left;
	private BSTNode right;

	public BSTNode(Dollar dollar) {
		this.dollar = dollar;
		this.left = null;
		this.right = null;
	}

	public Dollar getDollar() {
		return dollar;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setDollar(Dollar dollar) {
		this.dollar = dollar;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	// might need to create more functions here ...

}