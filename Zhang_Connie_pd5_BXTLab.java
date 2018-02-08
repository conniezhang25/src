

	/*	NAME:Connie Zhang
	PERIOD:5
	DUE DATE: 1/22/18

	PURPOSE:   To learn the structure of a BXT and the differences between BXT and BST and BT

	WHAT I LEARNED:  I learned that BXT is built using postfix order and when building it, it is much 
	more efficient to use a helper stack. I also learned that the operands ar always the leaf nodes 
	in a BXT. 
	            
	CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): Jackie Yang helped me with my build tree method and evaluate method
	
	*/

	import java.util.*;

	 	/***********************************
		Represents a binary expression tree.
		The BXT can build itself from a postorder expression.  It can
		evaluate and print itself. It also prints an inorder string and a preorder string.  
		************************************/
	public class Zhang_Connie_pd5_BXTLab
	{
	   private int count;
	   private TreeNode root;
	   
	   public Zhang_Connie_pd5_BXTLab()
	   {
	      count = 0;
	      root = null;
	   }
	   public Zhang_Connie_pd5_BXTLab(Object obj)
	   {
	      count = 1;
	      root = new TreeNode(obj, null, null);
	   }
	      /***********************
	   	Builds a BXT from a postfix expression.  Uses a helper stack of TreeNodes.
	   	****************************/
	   public void buildTree(String str)
	   {
	         Stack<TreeNode> s = new Stack<TreeNode>();
	         StringTokenizer tokenizer = new StringTokenizer(str);
	         
	         while(tokenizer.hasMoreTokens())
	         {
	        	 String token = tokenizer.nextToken();
	        	 
	        	 if (isOperator(token))
	        	 {
	        		 TreeNode tr = s.pop();//pop right first
	        		 TreeNode tl = s.pop();//pop left
	        		 
	        		 
	        		 root = new TreeNode(token);
	        		 root.setLeft(tl);//set operator children to popped nodes
	        		 root.setRight(tr);
	        		 s.push(root);
	        		 
	        	 }
	        	 else
	        		 s.push(new TreeNode(token));
	        	 
	        		 
	         }
	         
	   }
	   public double evaluateTree()
	   {
	      return evaluateNode(root);
	   }
	   private double evaluateNode(TreeNode root)  //recursive
	   {
		   if(root==null)
		   {
			   return 0;
		   }
		   else if(isOperator(root.getValue().toString()))
		   {
			   double left = evaluateNode(root.getLeft());
			   double right = evaluateNode(root.getRight());
			   return computeTerm(root.getValue().toString(), left, right);//evaluate the node
		   }
		   else 
			   return Double.parseDouble(root.getValue().toString());
	   }
	   private double computeTerm(String s, double a, double b)
	   {
	          if(s.equals("+"))
	          {
	        	  return a+b;
	          }
	          if(s.equals("-"))
	          {
	        	  return a-b;
	          }
	          if(s.equals("*"))
	          {
	        	  return a*b;
	          }
	          if(s.equals("/"))
	          {
	        	  return a/b;
	          }
	           return a%b;
	   }
	   private boolean isOperator(String s)
	   {
	          return (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("%"));
	   }
	     //display() from TreeLab
	   public void display()
	   {
		   displayH(root, 0);
	   }
	   private void displayH(TreeNode t, int level)
	   {
	      if(t == null)
	         return;
	      displayH(t.getRight(), level + 1); //recurse right
	         
	      for(int k = 0; k < level; k++)
	         System.out.print("\t");
	      System.out.println(t.getValue());
	         
	      displayH(t.getLeft(), level + 1); //recurse left
	   }  // end of display
	      
	   public void preorder()
	   {
		   preorderH(root);
	   }
	   public static void preorderH(TreeNode t)//CLR
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   }
		   else 
		   {
			   System.out.print(t.getValue());
			   preorderH(t.getLeft());	
			   preorderH(t.getRight());
		   }
			   	   
	   }
	   public void inorder()
	   {
		   inorderH(root);
	   }
	   public static void inorderH(TreeNode t)//LCR
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   } 
		   else{
			   inorderH(t.getLeft());
		      System.out.print(t.getValue());
			   inorderH(t.getRight());
		   }
	   	 
	   }// preorder traverse
	   public void printExp()
	   {
		   printExpH(root);
	   }
	   
	   public void printExpH(TreeNode r)
	   {
		   if(r.getLeft()!=null)
		   {
			   System.out.print("(");
			   printExpH(r.getLeft());
		   }
		   System.out.print(r.getValue());
		   if(r.getRight()!=null)
		   {
			   printExpH(r.getRight());
			   System.out.print(")");
		   }
	   }
	}
	/*
	 * Program Output:
	 * Input postfix string: 14 -5 /
		-5
	/
		14
	Infix order:  14/-5
	Print Expression:  (14/-5)
	Prefix order:  /14-5
	Evaluates to -2.8
	 * 
	 * 
	 * 
	 * Input postfix string:  3 4 5 + * 
			5
		+
			4
	*
		3
	Infix order:  3*4+5
	Print Expression:  (3*(4+5))
	Prefix order:  *3+45
	Evaluates to 27.0
	 * 
	 * 
		 *Input postfix string: 2 3 + 5 / 4 5 - *
			5
		-
			4
	*
			5
		/
				3
			+
				2
	Infix order:  2+3/5*4-5
	Print Expression:  (((2+3)/5)*(4-5))
*/
	//Prefix order:  */+235-45
	//Evaluates to -1.0



