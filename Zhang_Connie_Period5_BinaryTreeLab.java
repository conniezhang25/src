

	 /*****************************************************************************************************************
	NAME:   Connie Zhang 

   
	PERIOD:5
	DUE DATE: 1/8/18

	PURPOSE: The purpose of this lab was to learn the basics of using recursion to traverse through 
	a binary tree. It was also 

	WHAT I LEARNED:  In the min/max methods I at first had a lot of trouble casting the object to a string or 
	character to be able to compare the values in the node. I tried a lot of casting but it didn't work for me--> to 
	solve this issue, I converted th object into a string using toString and then got the first character, since there 
	is only one character. I then used the character to directly compare the values to find the larger or smaller value. 
	I also compared the values in the left and right tree to the root node in case it was the root node
	
	
	            
	CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): My mom helped me to retrieve the character value from the node in the min 
	max method-- used to compare the values. 
	
	
	

	****************************************************************************************************************/


	import java.util.*;                     //for the queue interface
	public class Zhang_Connie_Period5_BinaryTreeLab {
	   public static void main(String[] args)
	   {
	      String s = "XCOMPUTERSCIENCE";
	   		
	      TreeNode root = new TreeNode("" + s.charAt(1), null, null);
	         
	       // The root node has index 1
	       // The second level nodes' indices: 2, 3
	       // The third level nodes' indices: 4,5,6,7
	       // Idea: based on the index of the node, log (pos) of base 2 calculates the level of the
	       //          node: root (index 1) on level 1. Node with index 2 or 3 is on level 2
	      for(int pos = 2; pos < s.length(); pos++)
	         insert(root, "" + s.charAt(pos), pos, (int)(1 + Math.log(pos) / Math.log(2)));
	      
	      // NOTE: The following 3 lines are supposed to further show you how insert works. You
	      //             uncomment them and see how the tree looks like with these 3 additional nodes
	       insert(root, "A", 17, 5); 
	       insert(root, "B", 18, 5); 
	       insert(root, "C", 37, 6); //B's right child
	      
	      // display the tree sideway; see the sample output at the end of this file
	      display(root, 0);
	      
	      System.out.print("\nPreorder: ");
	      preorderTraverse(root);
	      System.out.print("\nInorder: ");
	      inorderTraverse(root);
	      System.out.print("\nPostorder: ");
	      postorderTraverse(root);
	      
	      System.out.println("\n\nNodes = " + countNodes(root));
	      System.out.println("Leaves = " + countLeaves(root));
	      System.out.println("Grandparents = " + countGrands(root));  // count the number grandparent nodes
	      System.out.println("Only childs = " + countOnlys(root));	   // count the number of nodes that has only 1 child
	         
	      System.out.println("\nDepth = " + depth(root));                    
	      System.out.println("Height = " + height(root));
	      System.out.println("Width = " + width(root));

	      System.out.println("Min = " + min(root));
	      System.out.println("Max = " + max(root));	
	      
	      System.out.println("\nBy Level: ");
	      displayLevelOrder(root);     // level by level display of the nodes (starts from left to right for nodes on the same level)
	      
	   } // end of main
	   
	   
	   // insert a new node in the tree based on the node's level
	   public static void insert(TreeNode t, String s, int pos, int level)
	   {
	      TreeNode p = t;
	      for(int k = level - 2; k > 0; k--)
	         //  then 1 << 4 will insert four 0-bits at the right of 1 (binary representation of 1 is 1. 
	         // 1 << 4 results in 10000 (in binary)
	         if((pos & (1 << k)) == 0) 
	            p = p.getLeft();      // What does this do? Answer this question first.  What does '&' do? Google it!!!!
	         else                        //  We did not learn this in AP CS A!  :
	            p = p.getRight();    // What does this do? Answer this question first.
	            
	      if((pos & 1) == 0)
	         p.setLeft(new TreeNode(s, null, null));
	      else
	         p.setRight(new TreeNode(s, null, null));
	   } // end of insert
	      
	      
	   /*****************************************************************************************************   
	     postcondition: display the tree sideway   
	   *****************************************************************************************************/   
	   public static void display(TreeNode t, int level)
	   {
	      if(t == null)
	         return;
	      display(t.getRight(), level + 1); //recurse right
	         
	      for(int k = 0; k < level; k++)
	         System.out.print("\t");
	      System.out.println(t.getValue());
	         
	      display(t.getLeft(), level + 1); //recurse left
	   }  // end of display
	      
	      
	   public static void preorderTraverse(TreeNode t)//CLR
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   }
		   else 
		   {
			   System.out.print(t.getValue());
			   preorderTraverse(t.getLeft());	
			   preorderTraverse(t.getRight());
		   }
			   	   
	   }
	   
	   public static void inorderTraverse(TreeNode t)//LCR
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   } 
		   if(t.getLeft()!=null)
		   {
			   inorderTraverse(t.getLeft());
		   }
		   if(t!=null)
		   {
			   System.out.print(t.getValue());
			   
		   }
		   if(t.getRight()!=null)
		   {  	
			   inorderTraverse(t.getRight());
		   }
	   }
	    
	   public static void postorderTraverse(TreeNode t)//LRC
	   {
		   if(t==null)
		   {
			   System.out.print("");
		   } 
		   if(t.getLeft()!=null)
		   {
			   postorderTraverse(t.getLeft());
		   }
		   if(t.getRight()!=null)
		   {  	
			   postorderTraverse(t.getRight());
		   }
		   if(t!=null)
		   {
			   System.out.print(t.getValue());			   
		   }
	   }
	   
	   
	   public static int countNodes(TreeNode t)
	   {
	      if(t==null)
	      {
	    	  return 0;
	      }
	      return countNodes(t.getLeft()) + countNodes(t.getRight())+1;	      
	   }
	   
	   
	   public static int countLeaves(TreeNode t)
	   {
	      if(t==null)
	      {
	    	  return 0;
	      }
	      else if(t.getLeft()==null&&t.getRight()==null)//check if no children
	      {
	    	  return 1;
	      }
	      else 
	    	  return countLeaves(t.getLeft())+ countLeaves(t.getRight());
	   }
	   	   
	   public static int countGrands(TreeNode t)
	   {
		   if(t==null)//base case
			   return 0;  
		   else if(t.getLeft()!=null)//check if parent is null first
		   {
				   if(t.getLeft().getLeft()!=null || t.getLeft().getRight()!=null)//check grandchild left and right
				   {
					   return 1+countGrands(t.getLeft())+countGrands(t.getRight());//continue to check grandchildren
				   }
		   }
		   else if(t.getRight()!=null)
		   {
				 if(t.getRight().getRight()!=null||t.getRight().getLeft()!=null)
				 {
					  return 1+countGrands(t.getRight())+countGrands(t.getLeft());
				 }
		   }
		   else
			   return countGrands(t.getLeft()) + countGrands(t.getRight());
		   return 0;//not sure why i still have to return 0?
		  
	   }
	   	   
	   public static int countOnlys(TreeNode t)
	   {
	       if(t==null)
	    	   return 0;
	       else if((t.getLeft()==null|| t.getRight()==null)&& !(t.getLeft() == null && t.getRight() == null))  //check if one child is null but not both 
	    	   return 1+countOnlys(t.getLeft()) + countOnlys(t.getRight());//count only childs and continue to check the rest of the tree
	       else    
	    	   return countOnlys(t.getLeft()) + countOnlys(t.getRight());//traverse through the tree- recursive call
	    		 
	   }
	   public static int depth(TreeNode t)//counts the number max number of nodes that it takes from the root to leaf
	   {
		   if (t == null)
	            return -1;//take out the root node to accurately count the path 
	        else
	        {
	        	int lDepth = depth(t.getLeft());
	        	int rDepth = depth(t.getRight());
	        	        	 
	            return Math.max(lDepth, rDepth)+1;
	        }
	   }
	      
	   public static int height(TreeNode t)
	   {
	      return depth(t);
	   }
		   
	   public static Object min(TreeNode t)
	   {
		   if (t == null)
	            return null;
		       Object lmin = min(t.getLeft());//get the left most min value
			   Object rmin = min(t.getRight());//get the right most min value
			   
			   Object min = t.getValue();//root value
			   char minChar = min.toString().charAt(0);//convert object to char
			   
			   if(lmin != null)//check if lmin is not null before converting to char
			   {				   
				   char lminChar = lmin.toString().charAt(0);
				   if(lminChar<minChar)//compare left min to root min value
			        minChar = lminChar;
			   }
			   if(rmin != null)
			   {				   
				   char rminChar = rmin.toString().charAt(0);
				   if(rminChar<minChar)
			        minChar = rminChar;
			   }
			   
			   return minChar;
			   
		
			   
	   }
	      
	   public static Object max(TreeNode t)
	   {
		   if (t == null)
	            return null;
		       Object lmax = max(t.getLeft());
			   Object rmax = max(t.getRight());
			   
			   Object max = t.getValue();
			   char maxChar = max.toString().charAt(0);
			   
			   if(lmax != null)
			   {				   
				   char lmaxChar = lmax.toString().charAt(0);
				   if(lmaxChar>maxChar)
			        maxChar = lmaxChar;
			   }
			   if(rmax != null)
			   {				   
				   char rmaxChar = rmax.toString().charAt(0);
				   if(rmaxChar>maxChar)
			        maxChar = rmaxChar;
			   }
			   
			   return maxChar;
	   }
	   
	   /*****************************************************************************************************
	        This method is not recursive.  
	        Hint: Use a local queue to store the children of the current node.
	   *****************************************************************************************************/
	   public static void displayLevelOrder(TreeNode t)
	   {
		   if(t==null)
		   {
			   return;
		   }
	      Queue<TreeNode> display = new LinkedList<TreeNode>();
	      display.add(t);
	      while(!display.isEmpty())
	      {
		   	  
		    	  TreeNode temp = display.peek();
		    	  System.out.print(temp.getValue());
		    	  display.remove();
			      if(temp.getLeft()!=null)
			      {			      			      
				      display.add(temp.getLeft());
			      }
			      if(temp.getRight()!=null)
			      {	  
			    	  display.add(temp.getRight());
			      }
			      
		      
	      }
	      
	    	  
	   }
	   public static int width(TreeNode t)
	   {
		   int maxWidth=0;
		   int localWidth=0;
		   
		   Queue<TreeNode> q = new LinkedList<TreeNode>();   
		   q.add(t);
		   q.add(null);
		   
		   while(!q.isEmpty())
		   {
			   TreeNode temp = q.remove();
			   if(temp==null)
			   {
				   if(localWidth>maxWidth)
				   {
					   maxWidth=localWidth;
					   localWidth=0;
					   if(!q.isEmpty())
					   q.add(null);
				   }
			   }
			   else 
			   {
				   q.add(temp.getLeft());
				   q.add(temp.getRight());
				   localWidth++;
			   }
		   }
		   return maxWidth;
		   
	   }
	}  // end of TreeLab_shell


	   /***************************************************
		  
	      ----jGRASP exec: java Lab01
	    
	    			E
	    		E
	    			C
	    	M
	    			N
	    		T
	    			E
	    C
	    			I
	    		U
	    			C
	    	O
	    			S
	    					C
	    				B
	    		P
	    				A
	    			R
	    
	    Preorder: C O P R A S B C U C I M T E N E C E 
	    Inorder: R A P B C S O C U I C E T N M C E E 
	    Postorder: A R C B S P C I U O E N T C E E M C 
	    
	    Nodes = 18
	    Leaves = 8
	    Grandparents = 5
	    Only childs = 3
	    
	    Depth = 6
	    Height = 5
	    Min = A
	    Max = U
	    
	    By Level: 
	    COMPUTERSCIENCEABC
	   
	    *******************************************************
	    *
	    *
	    *My Output:
	    *			E
		E
			C
	M
			N
		T
			E
C
			I
		U
			C
	O
			S
					C
				B
		P
				A
			R

Preorder: COPRASBCUCIMTENECE
Inorder: RAPBCSOCUICETNMCEE
Postorder: ARCBSPCIUOENTCEEMC

Nodes = 18
Leaves = 8
Grandparents = 5
Only childs = 3

Depth = 5
Height = 5
Width = 8
Min = A
Max = U

By Level: 
COMPUTERSCIENCEABC
	    */


