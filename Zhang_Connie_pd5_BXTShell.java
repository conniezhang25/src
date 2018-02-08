

	   //Name:      Date:
	   import java.util.*;

	 		
		/*******************
		Driver for a binary expression tree class.
		Input: a postfix string, each token separated by a space.
		**********************/
	    public class Zhang_Connie_pd5_BXTShell
	   {
	       public static void main(String[] args)
	      {
	         Zhang_Connie_pd5_BXTLab tree = new Zhang_Connie_pd5_BXTLab();
	         Scanner sc = new Scanner(System.in);
	         System.out.print("Input postfix string: ");
	         String s =  sc.nextLine();   // 14 -5 / ,   3 4 5 + *  ,  2 3 + 5 / 4 5 - *
	         tree.buildTree(s);
	         tree.display();
	         System.out.print("Infix order:  ");
	         tree.inorder();
	         System.out.print("\nPrint Expression:  ");
	         tree.printExp();
	         System.out.print("\nPrefix order:  ");
	         tree.preorder();
	         System.out.print("\nEvaluates to " + tree.evaluateTree());
	      }
	   }

