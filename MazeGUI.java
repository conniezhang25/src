import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

	public class MazeGUI extends JPanel
	{
	   private JButton[][] board;
	   private int[][] matrix;
	   private JLabel label;
	   private JButton reset, recursion;
	   public MazeGUI()
	   {
	      setLayout(new BorderLayout());
	      
	      JPanel north = new JPanel();
	      north.setLayout(new FlowLayout());
	      add(north, BorderLayout.NORTH);
	      label = new JLabel("Welcome to the Maze Game!");
	      north.add(label);
	      
	      JPanel center = new JPanel();
	      center.setLayout(new GridLayout(10,10));
	      add(center, BorderLayout.CENTER);
	      board = new JButton[10][10];
	      matrix = new int[10][10];
	      
	      ArrayList<Color> colors = new ArrayList<>();
	      colors.add(Color.white);
	      colors.add(Color.black);
	      
	      Random rand = new Random();
	      for(int r = 0; r < 10; r++)
	         for(int c = 0; c < 10; c++)
	         {
	            board[r][c] = new JButton();
	            Color random = colors.get(rand.nextInt(colors.size()));
	            board[r][c].setBackground(random);
	            board[r][c].addActionListener( new ActionListener1(r, c) );
	            center.add(board[r][c]);
	            
	            if(r==0&&c==0)
	            {
	            	board[r][c].setBackground(Color.yellow);
	            	matrix[r][c] =9;
	            }
	            if(r==9&&c==9)
	            {
	            	board[r][c].setBackground(Color.blue);
	            	matrix[r][c] =1;
	            }
	            if(random.equals(Color.white))
	            {
	            	matrix[r][c] = 1;
	            }
	            else if(random.equals(Color.black))
	            	matrix[r][c] = 0;
	            
	            
	            	
	         }
	      
	      JPanel subPanel = new JPanel();
	      
	      reset = new JButton("Reset");
	     reset.addActionListener( new ActionListener2());
	      reset.setEnabled(true);
	      subPanel.add(reset);
	      
	      recursion = new JButton("Recursion");
	      recursion.addActionListener(new ActionListener3());
	      recursion.setEnabled(true);
	      subPanel.add(recursion);
	      
	      add(subPanel, BorderLayout.SOUTH);
	      
	      
	      
	   }
	   public String toString()
	   {
		   String s="";
	      for(int i=0; i<matrix.length; i++)
	      {
	    	  for(int j=0; j<matrix[0].length; j++)
	    	  {
	    		  s+= matrix[i][j] + " ";
	    	  }
	    	  s += "\n";
	      }
	      return s;
	   } // toString
	   private class ActionListener1 implements ActionListener//change button
	   {
		   private int myRow, myCol;
		      public ActionListener1(int r, int c)
		      {
		         myRow = r;
		         myCol = c;
		      }
	      public void actionPerformed(ActionEvent e)
	      {
	         if(board[myRow][myCol].getBackground().equals(Color.black))
		     {
		        	board[myRow][myCol].setBackground(Color.white);
		        	matrix[myRow][myCol] = 1;
		     } 
		     else if(board[myRow][myCol].getBackground().equals(Color.white))
		     {
		    	 board[myRow][myCol].setBackground(Color.black);
	         	matrix[myRow][myCol] = 0;
		     }
		    	 
	      }  
	   }
	   private class ActionListener2 implements ActionListener//reset button
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  ArrayList<Color> colors = new ArrayList<>();
		      colors.add(Color.white);
		      colors.add(Color.black);
		      
		      Random rand = new Random();
	    	  for(int r = 0; r < 10; r++)
	 	         for(int c = 0; c < 10; c++)
	 	         {
	 	        	Color random = colors.get(rand.nextInt(colors.size()));
		            board[r][c].setBackground(random);
		            board[r][c].addActionListener(new ActionListener1(r, c));
	 	            
	 	            if(r==0&&c==0)
	 	            {
	 	            	board[r][c].setBackground(Color.yellow);
	 	            	matrix[r][c]=1;
	 	            }
	 	            if(r==9&&c==9)
	 	            {
	 	            	board[r][c].setBackground(Color.blue);
	 	            	matrix[r][c]=1;
	 	            }
	 	           
	 	         }
	    	  
		    	 
	      }  
	   }
	   private class ActionListener3 implements ActionListener//recursion
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  for(int r = 0; r < 10; r++)
	    	  {
		 	         for(int c = 0; c < 10; c++)
		 	         {
		 	        	 if(board[r][c].getBackground().equals(Color.yellow))
		 	        	 {
		 	        		 if(!findAnExit(r, c))
			 	     	      {
			 	     	         label.setText("Still trapped inside!");
			 	     	         
			 	     	      }
		 	        	 }
		 	        	 
		 	         }
	    	  }
	    	} 
	        public boolean findAnExit(int row, int col)
	        {
	        	if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || matrix[row][col] == 0 || matrix[row][col] == 3) 
	        	{ 
	  			    return false;
	        	}
	  			   else
	  			   {
	  				 board[row][col].setBackground(Color.green);
	  				   matrix[row][col] = 3;
	  				 System.out.println("test3");
	  				 System.out.println(row+","+col);

	  				   if(row == matrix.length-1 && col == matrix[0].length-1)
	  				   {
	  	                       //matrix[row][col] = 7;
	  	                      board[row][col].setBackground(Color.green);
	  	                    System.out.println("test8");
	  	                      label.setText("You solved the maze!!");
	  	                    return true;
	  				   }
	  				   else
	  				   {
	  					 //board[row][col].setBackground(Color.green);
	  					 System.out.println("test1");
	  					  if (findAnExit(row, col+1)  == true)
	  	                   {
	  						  System.out.println("test2");
	  						//matrix[row][col] = 7;
	  						board[row][col].setBackground(Color.green);
	  						return true;
	  	                   }
	  					   if (findAnExit(row, col-1)  == true)
	  	                   {
	  						//matrix[row][col] = 7;
	  						//board[row][col].setBackground(Color.green);
	  						return true;
	  	                   }
	  					   if (findAnExit(row+1, col)  == true)
	  	                   {
	  						//matrix[row][col] = 7;
	  	                    //board[row][col].setBackground(Color.green);
	  	                  return true;
	  	                   }
	  					   if (findAnExit(row-1, col)  == true)
	  	                   {
	  						//matrix[row][col] = 7;
	  						//board[row][col].setBackground(Color.green);
	  						return true;
	  	                   }
	  					 //board[row][col].setBackground(Color.green);
	  					board[row][col].setBackground(Color.red);
	  					 System.out.println("test5");
	  					return false;

	  				   } 
	  					 
	  				 
	  				   
	  			   }
	        	
	        }
	   }
	   private class ActionListener4 implements ActionListener//stack
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Stack<JButton> solve = new Stack<JButton>();
	    	  for(int r = 0; r < 10; r++)
	    	  {
		 	         for(int c = 0; c < 10; c++)
		 	         {
		 	        	 if(board[r][c].getBackground().equals(Color.yellow))
		 	        	 {
		 	        		 
		 	        		
		 	        	 }
		 	        	 
		 	         }
	    	  }
	      }
	      
	   }
	   
	   public static void main(String[] args)
	   {
	      boolean USE_CROSS_PLATFORM_UI = true;
	      if(USE_CROSS_PLATFORM_UI)
	      {
	         try
	         {
	            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	         } 
	         catch (Exception e) 
	         {
	            e.printStackTrace();
	         }
	      }
	          
	      JFrame frame = new JFrame("Zhang_Connie_Maze");
	      frame.setSize(400, 400);
	      frame.setLocation(200, 100);
	      frame.setContentPane(new MazeGUI());
	      frame.setVisible(true);
	   }

}
