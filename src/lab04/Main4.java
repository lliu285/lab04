package lab04;
import java.util.Scanner;
import java.io.*;

/*
 * Lab 4
 * Names: Lucia Liu, Nithya Ramasubramonian
 * Due date: 6/1/24
 * Purpose: The purpose of this lab is to practice implementing Binary Search Trees through a Dollar modeling scenario.
 */
public class Main4 {

    public static void main(String[] args) {
        
    	BST bst = new BST();
    	
        Dollar[] dollars = new Dollar[20];
        dollars[0] = new Dollar(57, 12);
        dollars[1] = new Dollar(23, 44);
        dollars[2] = new Dollar(87, 43);
        dollars[3] = new Dollar(68, 99);
        dollars[4] = new Dollar(111, 22);
        dollars[5] = new Dollar(44, 55);
        dollars[6] = new Dollar(77, 77); 
        dollars[7] = new Dollar(18, 36);
        dollars[8] = new Dollar(543, 21); 
        dollars[9] = new Dollar(20, 21);
        dollars[10] = new Dollar(345, 67);
        dollars[11] = new Dollar(36, 18);
        dollars[12] = new Dollar(48, 48);
        dollars[13] = new Dollar(101, 00);
        dollars[14] = new Dollar(11, 00);
        dollars[15] = new Dollar(21, 00);
        dollars[16] = new Dollar(51, 00);
        dollars[17] = new Dollar(1, 00);
        dollars[18] = new Dollar(251, 00);
        dollars[19] = new Dollar(151, 00);

        for (int i = 0; i < dollars.length; i++) {
        	bst.insert(dollars[i]);
        }
        printOutput(bst);
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	
	        System.out.println("\n\nWhat would you like to do? Choose an option below."
	        		+ "\na) Add"
	        		+ "\ns) Search"
	        		+ "\nd) Delete"
	        		+ "\np) Print output"
	        		+ "\ne) Exit program");
	        
	        String s = sc.nextLine();
	        
	        while (s.equals("")) {
	        	s = sc.nextLine();
	        }
	        
	        if (s.equals("a")) {
	        	addNodes(bst, sc);
	        } else if (s.equals("s")) {
	        	searchNodes(bst, sc);
	        } else if (s.equals("d")) {
	        	deleteNodes(bst, sc);
	        } else if (s.equals("p")) {
	        	printOutput(bst);
	        } else if (s.equals("e")) {
	        	printOutput(bst);
	        	break;
	        } else {
	        	System.out.println("Please choose a valid operation.");
	        }
        }
        
    }
    
    public static void addNodes(BST bst, Scanner sc) {
    	System.out.print("Enter the whole part: ");
    	int w = sc.nextInt();
    	System.out.print("Enter the fraction part: ");
    	int f = sc.nextInt();
    	
    	try {
    		Dollar d = new Dollar(w, f);
    		bst.insert(d);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public static void searchNodes(BST bst, Scanner sc) {
    	System.out.print("Enter the whole part: ");
    	int w = sc.nextInt();
    	System.out.print("Enter the fraction part: ");
    	int f = sc.nextInt();
    	
    	try {
    		Dollar d = new Dollar(w, f);
    		if (bst.search(d)) {
    			System.out.println("The value, $" + w + "." + f + ", was found.");
    		} else {
    			System.out.println("The value, $" + w + "." + f + ", was not found.");
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public static void deleteNodes(BST bst, Scanner sc) {
    	System.out.print("Enter the whole part: ");
    	int w = sc.nextInt();
    	System.out.print("Enter the fraction part: ");
    	int f = sc.nextInt();
    	
    	try {
    		Dollar d = new Dollar(w, f);
    		bst.delete(d);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public static void printOutput(BST bst) {
		try {
			File file = new File("output.txt");
			PrintStream ps = new PrintStream(file);
			bst.breadthFirstTraversal(ps); 
	        bst.inOrderTraversal(ps); 
	        bst.preOrderTraversal(ps);
	        bst.postOrderTraversal(ps);
	        bst.breadthFirstTraversalWithQueue(ps);
	        //System.out.println(file.getAbsolutePath());
	        ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
    }
    
    
}
