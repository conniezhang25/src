import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Battleship extends JPanel
{
   private JButton[][] board;
   private int[][] matrix;
   private int hits, torpedoes;
   private JLabel label;
   private JButton reset;
   public Battleship()
   {
      setLayout(new BorderLayout());
      hits = 0;
      torpedoes = 20;
      
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("You have 20 torpedoes.");
      north.add(label);
      
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
      board = new JButton[10][10];
      matrix = new int[10][10];
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            matrix[r][c] = 0;
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener( new Handler1(r, c) );
            center.add(board[r][c]);
         }
      
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
      
      placeShip();
   }
   
   private void placeShip()
   {
      int coin = (int)(Math.random() * 2 + 1); 
      int r, c;
                  
      if(coin ==1)//vertical 
      {
            
         r = (int)(Math.random()*7);
         c = (int)(Math.random()*7);
         for (int row = r; row<r+4; row++)
         {
            matrix[row][c]=1;
         }
      }
          
      else if(coin==2)//horizontal 
      {
         r = (int)(Math.random()*7);
         c = (int)(Math.random()*7);
                
         for (int col = c; col<c+4; col++)
         {
            matrix[r][col]=1;
         } 
      }
   }
                            
      
   
   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
              // The following two statements are for debugging purpose
            //System.out.println (myRow);
            //System.out.println (myCol);
            
         
         if(matrix[myRow][myCol]==1)
         {
            hits++;
            board[myRow][myCol].setBackground(Color.green);
            board[myRow][myCol].setEnabled(false);
                   
         }
         else
         {
            board[myRow][myCol].setBackground(Color.red);
            board[myRow][myCol].setEnabled(false);
         }
         if(torpedoes==0)
         {
            
            reset.setEnabled(true);
            for(int r=0; r<board.length; r++)
               {
                  for(int c=0; c<board[0].length; c++)
                  {
                     if(matrix[r][c]==1)
                     {
                        board[r][c].setBackground(Color.green);
                     }
                     board[r][c].setEnabled(false);
                  }
               }
            label.setText("You lose, press reset to play again!");
            
         }
         else
         {
            torpedoes--;
            label.setText("You have "+torpedoes+" torpedoes!");
         }  
         if(hits==4)
            {
               reset.setEnabled(true);
               label.setText("You WON"); 
               for(int r=0; r<board.length; r++)
               {
                  for(int c=0; c<board[0].length; c++)
                  {
                     board[r][c].setEnabled(false);
                  }
               } 
          
            }
         
             
      }   // actionPerformed of Handler
   }
      
          // Handling the Reset button
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         for(int r=0; r<board.length; r++)
         {
            for(int c=0; c<board[0].length; c++)
            {
               matrix[r][c]=0;
               board[r][c].setBackground(Color.blue);
               board[r][c].setEnabled(true);
            }
         }
         placeShip();
         torpedoes=20;
         hits=0;
         label.setText("you have "+torpedoes+" torpedoes");
           
      }  // actionPerformed of Handler2
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
          
      JFrame frame = new JFrame("Battleship!");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setContentPane(new Battleship());
      frame.setVisible(true);
   }
}
