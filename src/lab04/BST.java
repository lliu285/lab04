package lab04;
import java.io.*;

public class BST {

	private BSTNode root;
	private PrintStream ps;

	public BST() {
		this.root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(Dollar dollar) {
		root = insertHelper(root, dollar);
	}

	private BSTNode insertHelper(BSTNode node, Dollar dollar) {
		if (node == null) {
			return new BSTNode(dollar);
		}

		if (dollar.getValue() < node.getDollar().getValue()) { // checking the left
			node.setLeft(insertHelper(node.getLeft(), dollar));
		} else if (dollar.getValue() > node.getDollar().getValue()) { // checking the right
			node.setRight(insertHelper(node.getRight(), dollar));
		}

		return node;
	}

	public boolean search(Dollar dollar) {
		return searchHelper(root, dollar);
	}

	private boolean searchHelper(BSTNode node, Dollar dollar) {

		if (node == null) {
			return false;
		}

		if (node.getDollar().getValue() == dollar.getValue()) {
			return true;
		}

		if (dollar.getValue() < node.getDollar().getValue()) {
			return searchHelper(node.getLeft(), dollar);
		} else {
			return searchHelper(node.getRight(), dollar);
		}

	}

	public void delete(Dollar dollar) {
		root = deleteHelper(root, dollar);
	}

	private BSTNode deleteHelper(BSTNode node, Dollar dollar) {
		if (node == null) {
			return node;
		}

		if (dollar.getValue() < node.getDollar().getValue()) {
			node.setLeft(deleteHelper(node.getLeft(), dollar));
		} else if (dollar.getValue() > node.getDollar().getValue()) {
			node.setRight(deleteHelper(node.getRight(), dollar));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}

			node.setDollar(inOrderSuccessorMin(node.getRight()).getDollar());
			node.setRight(deleteHelper(node.getRight(), node.getDollar()));
		}
		return node;
	}

	private BSTNode inOrderSuccessorMin(BSTNode node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
	
	private void printTitle(String title) {
		System.out.println("\n" + title + ": ");
		if (this.ps != null) {
			ps.println("\n" + title + ": ");
		}
	}
	
	private void printNode(BSTNode node) {
		System.out.println(node.getDollar() + " ");
		if (this.ps != null) {
			ps.println(node.getDollar() + " ");
		}
	}

	public void inOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("In-order traversal");
		inOrderTraversalHelper(root);
		this.ps = null;
	}

	private void inOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			inOrderTraversalHelper(node.getLeft());
			printNode(node);
			inOrderTraversalHelper(node.getRight());
		}
	}

	public void preOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Pre-order traversal");
		preOrderTraversalHelper(root);
		this.ps = null;
	}

	private void preOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			printNode(node);
			preOrderTraversalHelper(node.getLeft());
			preOrderTraversalHelper(node.getRight());
		}
	}

	public void postOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Post-order traversal");
		postOrderTraversalHelper(root);
		this.ps = null;
	}

	private void postOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			postOrderTraversalHelper(node.getLeft());
			postOrderTraversalHelper(node.getRight());
			printNode(node);
		}
	}

	public void breadthFirstTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Breadth-first traversal");
		int height = getHeight(root);
		
		for (int i = 1; i <= height; i++)
			breadthFirstTraversalHelper(root, i);
		
		this.ps = null;
	}
	
	private int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else {
			int lheight = getHeight(node.getLeft());
			int rheight = getHeight(node.getRight());

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	private void breadthFirstTraversalHelper(BSTNode node, int level) {
		if (node == null)
			return;
		if (level == 1)
			printNode(node);
		else if (level > 1) {
			breadthFirstTraversalHelper(node.getLeft(), level - 1);
			breadthFirstTraversalHelper(node.getRight(), level - 1);
		}
	}

	public int count() {
		return countHelper(root);
	}

	private int countHelper(BSTNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + countHelper(node.getLeft()) + countHelper(node.getRight());
	}
}
