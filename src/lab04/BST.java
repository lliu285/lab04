package lab04;
import java.io.*;

public class BST {

	private BSTNode root;
	//private PrintStream ps;

	public BST() {
		this.root = null;
		
//		try {
//			ps = new PrintStream("output.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(Dollar dollar) {
		root = insert_helper(root, dollar);
	}

	private BSTNode insert_helper(BSTNode node, Dollar dollar) {
		if (node == null) {
			return new BSTNode(dollar);
		}

		if (dollar.getValue() < node.getDollar().getValue()) { // checking the left
			node.setLeft(insert_helper(node.getLeft(), dollar));
		} else if (dollar.getValue() > node.getDollar().getValue()) { // checking the right
			node.setRight(insert_helper(node.getRight(), dollar));
		}

		return node;
	}

	public boolean search(Dollar dollar) {
		return search_helper(root, dollar);
	}

	private boolean search_helper(BSTNode node, Dollar dollar) {

		if (node == null) {
			return false;
		}

		if (node.getDollar().getValue() == dollar.getValue()) {
			return true;
		}

		if (dollar.getValue() < node.getDollar().getValue()) {
			return search_helper(node.getLeft(), dollar);
		} else {
			return search_helper(node.getRight(), dollar);
		}

	}

	public void delete(Dollar dollar) {
		root = delete_helper(root, dollar);
	}

	private BSTNode delete_helper(BSTNode node, Dollar dollar) {
		if (node == null) {
			return node;
		}

		if (dollar.getValue() < node.getDollar().getValue()) {
			node.setLeft(delete_helper(node.getLeft(), dollar));
		} else if (dollar.getValue() > node.getDollar().getValue()) {
			node.setRight(delete_helper(node.getRight(), dollar));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}

			node.setDollar(in_order_successor_min(node.getRight()).getDollar());
			node.setRight(delete_helper(node.getRight(), node.getDollar()));
		}
		return node;
	}

	private BSTNode in_order_successor_min(BSTNode node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public void inOrderTraversal() {
		System.out.println("\nIn-order traversal: ");
		inOrderTraversalHelper(root);
	}

	private void inOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			inOrderTraversalHelper(node.getLeft());
			//ps.print(node.getDollar() + " ");
			System.out.println(node.getDollar() + " ");
			inOrderTraversalHelper(node.getRight());
		}
	}

	public void preOrderTraversal() {
		System.out.println("\nPre-order traversal: ");
		preOrderTraversalHelper(root);
	}

	private void preOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			System.out.println(node.getDollar() + " ");
			preOrderTraversalHelper(node.getLeft());
			preOrderTraversalHelper(node.getRight());
		}
	}

	public void postOrderTraversal() {
		System.out.println("\nPost-order traversal: ");
		postOrderTraversalHelper(root);
	}

	private void postOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			postOrderTraversalHelper(node.getLeft());
			postOrderTraversalHelper(node.getRight());
			System.out.println(node.getDollar() + " ");
		}
	}

	public void breadthFirstTraversal() {
		System.out.println("\nBreadth-first traversal: ");
		int height = getHeight(root);
		
		for (int i = 1; i <= height; i++)
			breadthFirstTraversalHelper(root, i);
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
            System.out.println(node.getDollar());
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
