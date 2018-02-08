import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToePanel extends JPanel
{
   private JButton [] [] board;
   private static final int ROWS = 3, COLUMNS = 3;
   public TicTacToePanel()
   {
      setLayout(new BorderLayout());
      JPanel center= new JPanel();
      board = new JButton [ROWS][COLUMNS];
      for (int i = 0; i < ROWS; i++)
      {
         for (int j = 0; j < COLUMNS; j++)
         {
             board[i][j] = new JButton("");
             center.add(board[i][j],BorderLayout.CENTER );
             board[i][j].setEnabled(true);
          }
            
      }
   }  // default constructor
   
   // post-condition: set a field in the board. The field must be unoccupied
  /* public void set (int i, int j, char player)
   {
      if (board [i][j] != ' ')
         throw new IllegalArgumentException ("Position occupied");
      board[i][j] = player;
   }  // set*/
  /*    
   public char getWinner()
   {
      int count=0;
      for(int r=0; r<board.length; r++)
      { 
         if(board[r][0]=='x'&&board[r][1]=='x'&&board[r][2]=='x')
         {
            return 'x';
         }
         else if(board[r][0]=='o'&&board[r][1]=='o'&&board[r][2]=='o') 
         { 
            return 'o';
         }
      
      }
      for(int c=0; c<board.length; c++)
      {
         if(board[0][c]=='x'&&board[1][c]=='x'&&board[2][c]=='x')
         {
            return 'x';
         }
         
         else if(board[0][c]=='o'&&board[1][c]=='o'&&board[2][c]=='o') 
         { 
            return 'o';
         }
                    
               
      }
      String major = "";
      String minor = "";
        
      for(int i=0; i<board.length; i++)
      {
         major+=board[i][i];
         minor += board[i][board.length-1-i];
      }
      if(major.equals("xxx"))
      {
         return 'x';
      }
      else if(major.equals("ooo"))
      {
         return 'o';
      }
      else if(minor.equals("xxx"))
      {  
         return 'x';
      } 
      else if(minor.equals("ooo"))
      {
         return 'o';
      }
      for(int r=0; r<board.length; r++)
      {
         for(int c=0; c<board[0].length; c++)
         {
            if(board[r][c]!=' ')
            {
               count++;
            }
         }
      }
      if(count == 9)
      {
         return 't'; 
      }
      else
      {
         return ' ';
      }
   }
   public String toString()
   {
      String r = "";
      for (int i = 0; i < ROWS; i++)
      {
         r = r + "|";
         for (int j = 0; j < COLUMNS; j++)
         {
            r = r + board[i][j] + "|";
         }
         r = r + "\n";
      }
      return r;
   } // toString*/
}