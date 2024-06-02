package lab04;
import java.util.Scanner;
import java.io.*;

/*
 * 
 */

public class Main4 {

    public static void main(String[] args) {
        
    	BST bst = new BST();
    	
//        Dollar[] dollars = new Dollar[20];
//        dollars[0] = new Dollar(57, 12);
//        dollars[1] = new Dollar(23, 44);
//        dollars[2] = new Dollar(87, 43);
//        dollars[3] = new Dollar(68, 99);
//        dollars[4] = new Dollar(111, 22);
//        dollars[5] = new Dollar(44, 55);
//        dollars[6] = new Dollar(77, 77); 
//        dollars[7] = new Dollar(18, 36);
//        dollars[8] = new Dollar(543, 21); 
//        dollars[9] = new Dollar(20, 21);
//        dollars[10] = new Dollar(345, 67);
//        dollars[11] = new Dollar(36, 18);
//        dollars[12] = new Dollar(48, 48);
//        dollars[13] = new Dollar(101, 00);
//        dollars[14] = new Dollar(11, 00);
//        dollars[15] = new Dollar(21, 00);
//        dollars[16] = new Dollar(51, 00);
//        dollars[17] = new Dollar(1, 00);
//        dollars[18] = new Dollar(251, 00);
//        dollars[19] = new Dollar(151, 00);
        
    	Dollar[] dollars = new Dollar[6];
        dollars[0] = new Dollar(4, 00);
        dollars[1] = new Dollar(2, 00);
        dollars[2] = new Dollar(5, 00);
        dollars[3] = new Dollar(1, 00);
        dollars[4] = new Dollar(3, 00);
        dollars[5] = new Dollar(6, 00);

        for (int i = 0; i < dollars.length; i++) {
        	bst.insert(dollars[i]);
        }
        
        System.out.println(bst.search(new Dollar(3, 00)));
        
        
        String data = "This is a text inside the file.";

        try {
            PrintStream output = new PrintStream("output.txt");

            output.print(data);
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }       
        
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    	
        printOutput(bst);
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	
	        System.out.println("\nWould you like to: "
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
	        	System.out.println("\nBreadth-first: ");
	            bst.breadthFirstTraversal(); 
	        } else if (s.equals("s")) {
	        	searchNodes(bst, sc);
	        } else if (s.equals("d")) {
	        	deleteNodes(bst, sc);
	        	System.out.println("\nBreadth-first: ");
	            bst.breadthFirstTraversal(); 
	        } else if (s.equals("p")) {
	        	printOutput(bst);
	        } else if (s.equals("e")) {
	        	System.out.println("exit");
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
    		System.out.println(e.getMessage());
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
    		System.out.println(e.getMessage());
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
    		System.out.println(e.getMessage());
    	}
    }
    
    public static void printOutput(BST bst) {
    	bst.breadthFirstTraversal(); 
        bst.inOrderTraversal(); 
        bst.preOrderTraversal();
        bst.postOrderTraversal();
    }
    
    
}