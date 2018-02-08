import java.awt.Color;
import java.util.*;
public class Maze_shell {
	   private final int VISITED = 3;
	   private final int PATH = 7;
	   private int [] [] grid = 
	       {
	      {1,1,1,0,1,1,0,0,0,1,1,1,1},
	      {1,0,1,1,1,0,1,1,1,1,0,0,1},
	      {0,0,0,0,1,0,1,0,1,0,1,0,0},
	      {1,1,1,0,1,1,1,0,1,0,0,1,1},
	      {1,0,1,0,0,0,0,1,1,1,0,0,1},
	      {1,0,1,1,1,1,1,1,0,1,1,1,0},
	      {1,0,0,0,0,0,0,0,0,0,0,0,0},
	      {1,1,1,1,1,1,1,1,1,1,1,1,1}
	      };

	   public boolean findAnExit (int x, int y)
	   {
	      String path = "";
	      return findAnExitHelper(x, y, path);
	   }  // FindAnExit


	   public boolean findAnExitHelper (int x, int y, String path)
	   {
		   if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0 || grid[x][y] == 3) {
		 	     return false;
			   } 
			   else
			   {
				   // Check if it is at the exit
	                           String currPath=path;
	                           path+= "["+ x+ ","+ y+"]";
				   grid[x][y] = 3;

				   if(x == grid.length-1 && y == grid[0].length-1)
	 
				   {
	                      System.out.println("Exit path:"); 
	                      System.out.println(path); 
				          grid[x][y] = 7;
					  return true;
				   }
				   else
				   {

					  if (findAnExitHelper(x, y+1, path)  == true)
	                   {
				              grid[x][y] = 7;
	                                      return true;
	                   }
					   if (findAnExitHelper(x, y-1, path)  == true)
	                   {
				              grid[x][y] = 7;
	                                      return true;
	                   }
					   if (findAnExitHelper(x+1, y, path)  == true)
	                   {
				              grid[x][y] = 7;
	                                      return true;
	                   }
					   if (findAnExitHelper(x-1, y, path)  == true)
	                   {
				              grid[x][y] = 7;
	                                      return true;
	                   }
	                        path=currPath; 
	                        return false;
				   } 
			   }

	   } // findAnExitHelper
	   public boolean findAnExitStack (int x, int y)
	   {
		   
	      return false;
	   }  // FindAnExit
	   

	   
	   public String toString()
	   {
		   String s="";
	      for(int i=0; i<grid.length; i++)
	      {
	    	  for(int j=0; j<grid[0].length; j++)
	    	  {
	    		  s+= grid[i][j] + " ";
	    	  }
	    	  s += "\n";
	      }
	      return s;
	   } // toString
	   
	   public static void main (String [] args)
	   {
	      // Assume that the exit of the maze is at the lower right hand corner of 
	      // the grid
	      Maze_shell m = new Maze_shell();
	      
	      // display the maze  
	      System.out.println (m);
	      Scanner input = new Scanner (System.in);
	      
	      System.out.println ("Enter current location (x and y coordinates: ");
	      int startX = input.nextInt();
	      int startY = input.nextInt();
	        
	      while (!m.findAnExit(startX, startY))
	      {
	         System.out.println ("Still trapped inside!");
	         System.out.println (m);
	         
	         System.out.println ("Re-enter current location (x and y coordinates: ");
	         startX = input.nextInt();
	         startY = input.nextInt();
	      }
	         
	      System.out.println ("Successfully exit the maze!!!");
	              
	      // display the path (indicated by 7) that leads to the exit of the maze
	      // also display locations tried
	      System.out.println (m);
	   } // main 
	} // Maze


	/********************************  Sample Runs
	*********************************  Run #1
	 7 8
	 [7,8][7,9][7,10][7,11][7,12]
	 Successfully exit the maze!!!
	 
	 3 3 3 0 3 3 0 0 0 3 3 3 3 
	 3 0 3 3 3 0 3 3 3 3 0 0 3 
	 0 0 0 0 3 0 3 0 3 0 1 0 0 
	 3 3 3 0 3 3 3 0 3 0 0 1 1 
	 3 0 3 0 0 0 0 3 3 3 0 0 1 
	 3 0 3 3 3 3 3 3 0 3 3 3 0 
	 3 0 0 0 0 0 0 0 0 0 0 0 0 
	 3 3 3 3 3 3 3 3 7 7 7 7 7 



	********************  Run #2
	0 0
	 [0,0][0,1][0,2][1,2][1,3][1,4][2,4][3,4][3,5][3,6][2,6][1,6][1,7][1,8][2,8][3,8][4,8][4,7][5,7][5,6][5,5][5,4][5,3][5,2]
	 [4,2][3,2][3,1][3,0][4,0][5,0][6,0][7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7][7,8][7,9][7,10][7,11][7,12]
	 Successfully exit the maze!!!
	 
	 7 7 7 0 1 1 0 0 0 1 1 1 1 
	 3 0 7 7 7 0 7 7 7 1 0 0 1 
	 0 0 0 0 7 0 7 0 7 0 1 0 0 
	 7 7 7 0 7 7 7 0 7 0 0 1 1 
	 7 0 7 0 0 0 0 7 7 1 0 0 1 
	 7 0 7 7 7 7 7 
	 
	 
	 ******************************  Run #3
	 3 12
	 no way out!
	 
	 1 1 1 0 1 1 0 0 0 1 1 1 1 
	 1 0 1 1 1 0 1 1 1 1 0 0 1 
	 0 0 0 0 1 0 1 0 1 0 1 0 0 
	 1 1 1 0 1 1 1 0 1 0 0 3 3 
	 1 0 1 0 0 0 0 1 1 1 0 0 3 
	 1 0 1 1 1 1 1 1 0 1 1 1 0 
	 1 0 0 0 0 0 0 0 0 0 0 0 0 
	 1 1 1 1 1 1 1 1 1 1 1 1 1 
	 

	*********************************/




/*
 * if(r<0 || c<0 || r>=matrix.length || c>=matrix[0].length || matrix[r][c] == 0 || matrix[r][c] == 3) {
		 	  		 	     board[r][c].setBackground(Color.red);
		 	  			  
		 	  			   else
		 	  			   {
		 	  				  
		 	  				 matrix[r][c] = 3;

		 	  				   if(r == matrix.length-1 && c == matrix[0].length-1)
		 	  				   {
		 	  	                       matrix[r][c] = 7;
		 	  	                      board[r][c].setBackground(Color.green);
		 	  				   }
		 	  				   else
		 	  				   {

		 	  					  if (findAnExitHelper(r, c+1)  == true)
		 	  	                   {
		 	  						matrix[r][c] = 7;
		 	  						board[r][c].setBackground(Color.green);
		 	  	                   }
		 	  					   if (findAnExitHelper(r, c-1)  == true)
		 	  	                   {
		 	  						matrix[r][c] = 7;
		 	  						board[r][c].setBackground(Color.green);
		 	  	                   }
		 	  					   if (findAnExitHelper(r+1, c)  == true)
		 	  	                   {
		 	  						matrix[r][c] = 7;
		 	  	                    board[r][c].setBackground(Color.green);
		 	  	                   }
		 	  					   if (findAnExitHelper(r-1, c)  == true)
		 	  	                   {
		 	  						matrix[r][c] = 7;
		 	  						board[r][c].setBackground(Color.green);
		 	  	                   }
		 	  	
		 	  					board[r][c].setBackground(Color.red);
		 	  				   } 
		 	  			   }
		 	        		

 */
