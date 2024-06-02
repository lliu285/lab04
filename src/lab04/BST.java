package lab04;
import java.io.*;

/*
 * Lab 4
 * Names: Lucia Liu, Nithya Ramasubramonian
 * Due date: 6/1/24
 * Purpose: The purpose of this lab is to practice implementing Binary Search Trees through a Dollar modeling scenario.
 */
public class BST {

	private BSTNode root;
	private PrintStream ps;

	public BST() {
		this.root = null;
	}

	/*
	 * Post: Returns true if the binary search tree contains no nodes , false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * Pre:
	 * dollar - Dollar object that will be inserted.
	 * 
	 * Post: 
	 * Inserts the given Dollar object into the binary search tree in its appropriate position.
	 */
	public void insert(Dollar dollar) {
		root = insertHelper(root, dollar);
	}

	/*
	 * Pre:
	 * node - BSTNode reference in the BST.
	 * dollar - Dollar object that will be inserted.
	 * 
	 * Post: 
	 * Returns reference to the root node of the modified binary search tree after inserting the given Dollar object.
	 */
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

	/*
	 * Pre: 
	 * dollar - Dollar object that will be searched in the BST.
	 * 
	 * Post: 
	 * Returns true if the given Dollar object is found in the binary search tree, false otherwise.
	 */
	public boolean search(Dollar dollar) {
		return searchHelper(root, dollar);
	}

	/*
	 * Pre:
	 * node - BSTNode reference in the BST.
	 * dollar - Dollar object that will be searched.
	 * 
	 * Post:
	 * Returns true if the given Dollar object is found in the binary search tree rooted 
	 * at the specified node, false otherwise.
	 */
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

	/*
	 * Pre:
	 * dollar - Dollar object that will be searched and deleted.
	 * 
	 * Post: 
	 * Deletes the given Dollar object from the binary search tree if it exists.
	 */
	public void delete(Dollar dollar) {
		root = deleteHelper(root, dollar);
	}

	/*
	 * Pre:
	 * node - BSTNode reference in the BST.
	 * dollar - Dollar object that will be deleted. 
	 * 
	 * Post:
	 * Returns a reference to the root node of the modified binary search tree after 
	 * deleting the node containing the given Dollar object.
	 */
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

	/*
	 * Pre:
	 * node - A reference to a node in the binary search tree that is being compared to.
	 * 
	 * Post:
	 * Returns the node with the minimum value in the binary search tree rooted at the specified node.
	 */
	private BSTNode inOrderSuccessorMin(BSTNode node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
	
	/*
	 * Pre:
	 * title - String of specified traversal type.
	 * 
	 * Post:
	 * Prints a header for the specified traversal type in console and output file.
	 */
	private void printTitle(String title) {
		System.out.println("\n\n" + title + ": ");
		if (this.ps != null) {
			ps.println("\n\n" + title + ": ");
		}
	}
	
	/*
	 * Pre:
	 * node - BSTNode that will be printed.
	 * 
	 * Post:
	 * Prints data of given node in console and output file.
	 */
	private void printNode(BSTNode node) {
		System.out.print(node.getDollar() + " ");
		if (this.ps != null) {
			ps.println(node.getDollar() + " ");
		}
	}

	/*
	 * Pre:
	 * ps - File-based PrintStream object for the output file.
	 * 
	 * Post:
	 * Prints the in-order traversal of the binary search tree.
	 */
	public void inOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("In-order traversal");
		inOrderTraversalHelper(root);
		this.ps = null;
	}

	/*
	 * Pre:
	 * node - A reference to a node in the binary search tree or null.
	 * 
	 * Post:
	 * Prints the in-order traversal of the binary search tree rooted at the specified node.
	 */
	private void inOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			inOrderTraversalHelper(node.getLeft());
			printNode(node);
			inOrderTraversalHelper(node.getRight());
		}
	}

	/*
	 * Pre:
	 * ps - File-based PrintStream object for the output file.
	 * 
	 * Post:
	 * Prints the pre-order traversal of the binary search tree.
	 */
	public void preOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Pre-order traversal");
		preOrderTraversalHelper(root);
		this.ps = null;
	}

	/*
	 * Pre:
	 * node - A reference to a node in the binary search tree or null.
	 * 
	 * Post:
	 * Prints the pre-order traversal of the binary search tree rooted at the specified node.
	 */
	private void preOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			printNode(node);
			preOrderTraversalHelper(node.getLeft());
			preOrderTraversalHelper(node.getRight());
		}
	}

	/*
	 * Pre:
	 * ps - File-based PrintStream object for the output file.
	 * 
	 * Post:
	 * Prints the post-order traversal of the binary search tree.
	 */
	public void postOrderTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Post-order traversal");
		postOrderTraversalHelper(root);
		this.ps = null;
	}

	/*
	 * Pre:
	 * node - A reference to a node in the binary search tree or null.
	 * 
	 * Post:
	 * Prints the post-order traversal of the binary search tree rooted at the specified node.
	 */
	private void postOrderTraversalHelper(BSTNode node) {
		if (node != null) {
			postOrderTraversalHelper(node.getLeft());
			postOrderTraversalHelper(node.getRight());
			printNode(node);
		}
	}

	/*
	 * Pre:
	 * ps - File-based PrintStream object for the output file.
	 * 
	 * Post:
	 * Prints the breadth-first traversal of the binary search tree.
	 */
	public void breadthFirstTraversal(PrintStream ps) {
		this.ps = ps;
		printTitle("Breadth-first traversal");
		int height = getHeight(root);
		
		for (int i = 1; i <= height; i++)
			breadthFirstTraversalHelper(root, i);
		
		this.ps = null;
	}
	
	/*
	 * Post:
	 * Returns the height of the specified node.
	 */
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

	/*
	 * Pre:
	 * node - A reference to a node in the binary search tree or null.
	 * level - Positive integer indicating the level in the binary search tree.
	 * 
	 * Post:
	 * Prints the nodes at the specified level in the binary search tree rooted at the specified node.
	 */
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
	
	/*
	 * Pre:
	 * ps - File-based PrintStream object for the output file.
	 * 
	 * Post:
	 * Prints the breadth-first traversal of the binary search tree using Queue.
	 */
	public void breadthFirstTraversalWithQueue(PrintStream ps) {
		this.ps = ps;
		printTitle("Breadth-first traversal with Queue");
		
		Queue<BSTNode> q = new Queue<BSTNode>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			BSTNode node = q.dequeue();
			printNode(node);
			
			if (node.getLeft() != null) {
				q.enqueue(node.getLeft());
			} 
			
			if (node.getRight() != null) {
				q.enqueue(node.getRight());
			} 
		}
	}

	/*
	 * Post:
	 * Returns the number of nodes in the binary search tree.
	 */
	public int count() {
		return countHelper(root);
	}

	/*
	 * Post:
	 * Returns the number of nodes in the binary search tree rooted at the specified node.
	 */
	private int countHelper(BSTNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + countHelper(node.getLeft()) + countHelper(node.getRight());
	}
}
