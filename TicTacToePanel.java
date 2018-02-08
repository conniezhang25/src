import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToePanel extends JPanel
{
   private JButton[][] gameBoard;
   private static final int ROWS = 3, COLUMNS = 3;
   private JLabel label;
   private String player;
   private boolean flag;
   private JButton reset;
   private int count;
   public TicTacToePanel()
   {
      count=0;
      setLayout(new BorderLayout());
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(3,3));
      add(center, BorderLayout.CENTER);
      gameBoard = new JButton[3][3];
      flag=false;
      for (int i = 0; i < ROWS; i++)
      {
         for (int j = 0; j < COLUMNS; j++)
         {
            gameBoard[i][j] = new JButton("");
            center.add(gameBoard[i][j]);
            gameBoard[i][j].setEnabled(true);
            gameBoard[i][j].addActionListener(new Listener1());
            
         }
            
      }
      JPanel north = new JPanel();
      label = new JLabel("Player 1's turn");
      label.setFont(new Font("Serif",Font.BOLD, 40));
      
      add(north, BorderLayout.NORTH);
      north.add(label);
      
      player = "o";
      
         reset = new JButton("Reset");
         reset.setEnabled(true);    
         add(reset, BorderLayout.SOUTH);
         reset.addActionListener(new ResetButton());

   }
    private class Listener1 implements ActionListener
      {
            public void actionPerformed (ActionEvent e)
            {
            		   if (player.equals("o"))
                     {
            			  player = "x";
                       label.setText("Player 2's turn");
                                              
                     }
            			else
                     {
            			  player = "o";   
                       label.setText("Player 1's turn");
                    
                     }
                              
               //System.out.print(player);
               for(int r=0; r<3; r++)
               {
                  for(int c=0; c<3; c++)
                  {
                     if(e.getSource()==gameBoard[r][c])
                     {                    
                        gameBoard[r][c].setText(player);
                        gameBoard[r][c].setFont(new Font("Serif",Font.BOLD, 40));
                        gameBoard[r][c].setEnabled(false);
                         count++;
                     }
                     if(count == 9)
                     {
                            label.setText("Tie game");
                     }
                   }
               }
                  //columns                                              
            for(int c=0; c<3; c++)
            {
               boolean colX=true;
               boolean colO=true; 
               for(int r=0; r<3; r++)
               {
                  if(!gameBoard[r][c].getText().equals("x"))
                  {
                     colX=false;
                  }
                  if(!gameBoard[r][c].getText().equals("o"))
                  { 
                     colO=false;
                  }                                        
               }
               if(colX||colO) 
               {
                     label.setText("Player " + player + " wins");
                     colX=false;
                     colO=false;
                     for(int i=0; i<3; i++)
                     {
                        for(int j=0; j<3;j++)
                        { 
                           gameBoard[i][j].setEnabled(false);
                        }
                     }                                    
               }
            }
                                                  
            for(int r=0; r<3; r++)
            {
               boolean rowX=true;//rows
               boolean rowO=true;
               for(int c=0; c<3; c++)
               {
                  if(!gameBoard[r][c].getText().equals("x"))
                  {
                     rowX=false;
                  }
                  if(!gameBoard[r][c].getText().equals("o"))
                  { 
                     rowO=false;
                   
                  }
                      
               } 
                if(rowX||rowO) 
                {
                  label.setText("Player " + player + " wins");
                  rowO=false;
                  rowX=false;
                  for(int i=0; i<3; i++)
                     {
                        for(int j=0; j<3; j++)
                        { 
                           gameBoard[i][j].setEnabled(false);
                        }
                     }
                }
             }                   
            
             boolean majorX = true;
             boolean majorO = true;              
            for(int i=0; i<3; i++)
            {
            
               if(!gameBoard[i][i].getText().equals("x"))
               {
                   majorX=false;
               }
               if(!gameBoard[i][i].getText().equals("o"))
               {
                   majorO=false;
               }
                                        
            }
             if(majorX||majorO) 
             {
                     for(int r=0; r<3; r++)
                     {
                        for(int c=0; c<3; c++)
                        { 
                           gameBoard[r][c].setEnabled(false);
                        }
                     }
                     label.setText("Player " + player + " wins");
                     majorO=false;
                     majorX=false;
             } 
        
             boolean minorX = true;
             boolean minorO = true;              
            for(int j=0; j<3; j++)
            {
            
               if(!gameBoard[gameBoard.length-1-j][j].getText().equals("x"))
               {
                   minorX=false;
               }
               if(!gameBoard[gameBoard.length-1-j][j].getText().equals("o"))
               {
                   minorO=false;
               }
                                                          
          }
          if(minorX||minorO) 
          {
              for(int r=0; r<3; r++)
                     {
                        for(int c=0; c<3; c++)
                        { 
                           gameBoard[r][c].setEnabled(false);
                        }
                     }
              label.setText("Player " + player + " wins");
              minorO=false;
              minorX=false;
              for(int r=0; r<3; r++)
               {
                    for(int c=0; c<3; c++)
                     { 
                           gameBoard[r][c].setEnabled(false);
                     }
                }
              
          } 
       }
        
     }
      private class ResetButton implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         { 
            for(int r=0; r<3; r++)
               {
                  for(int c=0; c<3; c++)
                  {
                     gameBoard[r][c].setEnabled(true);
                     gameBoard[r][c].setText("");
                  }
               }  
               player ="o"; 
               label.setText("Player 1's turn");
               count=0;             
      }
    }

    
    public static void main (String [] args)
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
             
         JFrame frame = new JFrame("Tic Tac Toe!");
         frame.setSize(400, 400);
         frame.setLocation(200, 100);
         frame.setContentPane(new TicTacToePanel());
         frame.setVisible(true);
    }
}
  