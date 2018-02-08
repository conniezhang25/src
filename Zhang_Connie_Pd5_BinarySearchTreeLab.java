	/*****************************************************************************************************************
	NAME:Connie Zhang
	PERIOD:5
	DUE DATE: 1/15/18

	PURPOSE:   Learn some basic methods of the Binary Search Tree and how it is different than a
	normal Binary Tree- it is sorted  

	WHAT I LEARNED:  I learned that the binary search tree has many differences than the binary tree. For
	example, the insert method is a lot easier to understand exactly where to insert the node because there 
	is a specific structure to it. Also, printing the tree in order is also straightforward as it is the same 
	as the inorder traversal of a binary tree.   
	            
	CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): 

	****************************************************************************************************************/
	import java.util.Scanner;
		/****************************************************************
		Practice with a Binary Search Tree. Uses TreeNode.
	    Prompt the user for an input string.  Build a Binary Search Tree 
		using Comparables.  Display it as a sideways tree (take the code 
		from the Tree Lab).  Prompt the user for a target and search the tree 
		for it.  Display the tree's minimum and maximum values.  Print 
		the data in order from smallest to largest.
		*****************************************************************/
public class Zhang_Connie_Pd5_BinarySearchTreeLab {

	
	   public static void main(String[] args)
	   {
	          // your code goes here
		  System.out.println("insert a string:");
		  Scanner input = new Scanner(System.in);
		   String s = input.next();
		   TreeNode root = new TreeNode("" + s.charAt(0), null, null);
		   for(int pos = 1; pos < s.length(); pos++)
		         insert(root, "" + s.charAt(pos));
		   
		   display(root, 0);
		   
		   System.out.print("\nInputTarget: ");
		   char r = input.next().charAt(0);
		   find(root, r);
		   
		    
		      System.out.print("\nMin: ");
		      System.out.print(min(root));
		      
		      System.out.print("\nMax: ");
		      System.out.print(max(root));
	        
		      System.out.println("\nInOrder: ");
		      smallToLarge(root);
	        
	        
	        
	   }
	      
	   	/****************************************************************
	   	Recursive algorithm to build a BST:  if the node is null, insert the 
	   	new node.  Else, if the item is less, set the left node and recur to 
	   	the left.  Else, if the item is greater, set the right node and recur 
	   	to the right.   
	   	*****************************************************************/
	   public static TreeNode insert(TreeNode t, String s)
	   {  	
	      if(t==null)
	      {
	    	  return new TreeNode(s.charAt(0));
	      }
	      else {
	    	  if(s.substring(0).compareTo(t.getValue().toString())<=0)
	    	  {
	    		  if(t.getLeft()!=null)
	    		  {
	    			  insert(t.getLeft(), s);
	    		  }
	    		  else 
	    		  {
	    			  t.setLeft( new TreeNode(s.charAt(0)));//insert a leaf node when value is less than or equal to the root
	    			  return t.getLeft();
	    		  }
	    	  }
	    	  else if(s.substring(0).compareTo(t.getValue().toString())>0)
	    	  {
	    		  if(t.getRight()!=null)
	    		  {
	    			  insert(t.getRight(), s);
	    		  }
	    		  else
	    		  {
	    			  t.setRight( new TreeNode(s.charAt(0)));//insert a node when the value is greater than the root
	    			  return t.getRight();
	    		  }
	    	  }
	      }
	      return t;
	      	
	   }
	   public static void display(TreeNode t, int level)
	   {
	      if(t == null)
	         return;
	      
	      display(t.getRight(), level + 1); //recurse right
	      
	      for(int k = 0; k < level; k++)
	         System.out.print("\t");
	      System.out.println(t.getValue());
	      
	      display(t.getLeft(), level + 1); //recurse left
	   }
	   	
	     /***************************************************************
	      Iterative algorithm:  create a temporary pointer p at the root.  
	   	While p is not null, if the p's value equals the target, return true.  
	   	If the target is less than the p's value, go left, otherwise go right.   
	   	If the target is not found, return false. 
	      
	   	Find the target. Recursive algorithm:  If the tree is empty, 
	   	return false.  If the target is less than the current node 
	   	value, return the left subtree.  If the target is greater, return 
	   	the right subtree.  Otherwise, return true.   
	   . ****************************************************************/    
	   public static boolean find(TreeNode t, Comparable x)
	   {
	     if(t==null)
	     {
	    	 System.out.print(x+" is not found");
	    	 return false;
	     }
	     else if(x.compareTo(t.getValue().toString().charAt(0))<0) //if less than the root, go left
	     {
	    	 return find(t.getLeft(), x);
	     }
	     else if(x.compareTo(t.getValue().toString().charAt(0))>0)//if greater than the root, go right
	     {
	    	 return find(t.getRight(), x);
	     }
	     else 
	     {
	    	 System.out.print("found: "+x);
	    	 return true;
	     }
	   }
	   
	     /***************************************************************
	   	starting at the root, return the min value in the BST.   
	   	Use iteration.   Hint:  look at several BSTs. Where are 
	   	the min values always located?  
	   	***************************************************************/
	   public static Object min(TreeNode t)
	   {
		   	if(t==null)
		      {
		    	  return null;
		      }
		      if(t.getLeft()==null)
		      {
		    	  return t.getValue();
		      }
		      return min(t.getLeft());//recurse all the way left till found min
	      
	   }
	   /*****************************************************************
	   	starting at the root, return the max value in the BST.  
	   	Use recursion!
	    *****************************************************************/
	   public static Object max(TreeNode t)
	   {
		   if(t==null)
		      {
		    	  return null;
		      }
		      if(t.getRight()==null)
		      {
		    	  return t.getValue();
		      }
		      return max(t.getRight());//recurse all the way right till found max
	   }
	   public static void smallToLarge(TreeNode t)//inorder traverse
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   }
		   else 
		   {
			   smallToLarge(t.getLeft());
			   System.out.print(t.getValue());			   	
			   smallToLarge(t.getRight());
		   }
	   }
	}  //end of class

/*
 * Program Output: 
 * insert a string:
american 
		r
			n
	m
			i
		e
			c
a
	a

InputTarget: x
x is not found
Min: a
Max: r
InOrder: 
aaceimnr

insert a string:
MAENIRAC
		R
	N
M
			I
		E
			C
	A
		A

InputTarget: I
found: I
Min: A
Max: R
InOrder: 
AACEIMNR
 */
