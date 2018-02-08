/*
Name:Connie Zhang
Date:2/27/16
Period:2
Lab:Minesweeper
What I learned:
1. I learned how to go through a 2-d array and test if each coordinate was a bomb or not
2. I learned to count the mines that are left, right, diagonal, and above and below a point
How I feel:
1. I felt so excited about this lab because I thought it was very fun to code a game. Although, it gave me some troubles like counting the mines, it was very rewarding to be able to play this game. 
*/
import java.util.Scanner;
public class Minesweeper
{
   static Scanner console = new Scanner (System.in); 
   public static void main(String[] args)
   {
      
      int size = welcomeAndAskForSizeOfField();
      int [] [] minesfield = new int [size] [size];
      char [] []outputField = new char[size] [size];
      
      init(minesfield, outputField);
      displayBombs(minesfield);
      displayOutput(outputField);
     
      
      boolean gameOver = false; 
      while(gameOver != true)
      {
         gameOver = playGame(minesfield, outputField);
         displayOutput(outputField);
      }
      displayBombs(minesfield);
      if(checkStatus(minesfield)==true)
      {
         System.out.println("Game over, you win!");
      }
    }
   
   public static int welcomeAndAskForSizeOfField()
   {
       
       System.out.print ("Welcome to the MineSweeper! \n Choose size of grid(Press 1 for 5x5, Press 2 for 10x10)");
       if(console.nextInt() == 1)
       {
         return 5;
       }
       else 
       {
         return 10;
       }
   }
   
   public static void init(int[] []mines, char [] []output)
   {
      for(int r =0; r< output.length; r++)
      {
         for(int c =0; c<output[0].length; c++)
         output[r][c] = ' ';
      }//generate a random minefield
      for(int r=0; r<mines.length; r++)
      {
         for(int c=0; c<mines[0].length; c++)
            mines[r][c] =(int)(Math.random()*2);
      }
      
   }
   public static void displayOutput(char [] [] output)
   {
      for(int r=0; r<output.length; r++)
      {
         for(int c=0; c<output[0].length; c++)
         {
            System.out.print("[" + (char)(output[r][c]) + "]");
         }
         System.out.println();
      }
   }
   public static int countMines(int[] [] mines, int r, int c)
   {
     int m =0;
     for(int row = r-1; row<=r+1; row++)
     {
        for(int col =c-1; col<=c+1; col++)
        {  
            if(!(row<0 || row>mines.length-1 || col<0 || col>mines[0].length-1))
            {
              
               if(mines[row][col]==1)
               {
                  m++;
               }
            }
                        
         }
      }
   

      return m;

   }
   public static boolean playGame(int [] []mines, char [] [] outputBoard)
   {
      System.out.println("enter the coordinates");  
       int r = console.nextInt();
       int c = console.nextInt();
       
       if(mines[r][c] == 1)
       {
         outputBoard[r][c] = 'X';
         System.out.println("Opps!! you stepped on a bomb, game over");
         return true;
       }
       else
       {
         outputBoard[r][c] = (countMines(mines,r, c) + "").charAt(0);
         mines[r][c]=-1;
         return checkStatus(mines); 
       }
   }
              
       //Step 1:  ask for the coordinates of a location
      	//              check if there is a mine at that location
      	//              if yes, put 'X' at that location on the outputBoard, 
      	//              and return true.
      	//
      	// Otherwise (i.e. no bomb at that location)
      	//            1) Check the number of mines in adjacent locations (countMines(r,c))
      	//            and put the count (need to change it to a char first, see below)
      	//            at that location on the outputBoard.
      	//
      	//            E.g. if the number of mines is 3, then convert 3 to a char '3' 
      //                   by:      outputBoard[r][c] = (3 + "").charAt(0);
         //
      	//             2) Another thing to do in step 2:update mines[r][c] = -1 
      //             (-1 indicates that location r,c has been marked.
      
      	//             3) If all the cells that do not contain bombs have been marked, then
      //             the checkStatus() method should returns true--game over.
      	//-------------------------------------------------------------------------------
      private static boolean checkStatus (int [] [] mines)
      {
           for(int row=0; row<mines.length; row++)
            {
               for(int col=0; col<mines[0].length; col++)
               {
                  if(mines[row][col]==0)
                  {
                     return false; 
                  }
               }
             }
         return true;


      }
      public static void displayBombs(int [] []mines)	
      {
         for(int r=0; r<mines.length; r++)
         {
            for(int c=0; c<mines[0].length; c++)
            {
               System.out.print("[" + (mines[r][c]) + "]");
            }
           System.out.println();
         }
         
      }    
   
}
/*
Program Output:

 Welcome to the MineSweeper! 
  Choose size of grid(Press 1 for 5x5, Press 2 for 10x10)1
 [0][1][1][1][1]
 [1][0][0][0][1]
 [0][0][0][1][1]
 [1][0][1][0][0]
 [0][1][1][0][0]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 enter the coordinates
 0 0
 [2][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 enter the coordinates
 4 4
 [2][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][0]
 enter the coordinates
 4 0
 [2][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 1 2
 [2][ ][ ][ ][ ]
 [ ][ ][4][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 2 0
 [2][ ][ ][ ][ ]
 [ ][ ][4][ ][ ]
 [2][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 1 1
 [2][ ][ ][ ][ ]
 [ ][3][4][ ][ ]
 [2][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 2 1
 [2][ ][ ][ ][ ]
 [ ][3][4][ ][ ]
 [2][3][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 3 1
 [2][ ][ ][ ][ ]
 [ ][3][4][ ][ ]
 [2][3][ ][ ][ ]
 [ ][4][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 2 2
 [2][ ][ ][ ][ ]
 [ ][3][4][ ][ ]
 [2][3][2][ ][ ]
 [ ][4][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 1 3
 [2][ ][ ][ ][ ]
 [ ][3][4][6][ ]
 [2][3][2][ ][ ]
 [ ][4][ ][ ][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 3 3
 [2][ ][ ][ ][ ]
 [ ][3][4][6][ ]
 [2][3][2][ ][ ]
 [ ][4][ ][4][ ]
 [2][ ][ ][ ][0]
 enter the coordinates
 3 4
 [2][ ][ ][ ][ ]
 [ ][3][4][6][ ]
 [2][3][2][ ][ ]
 [ ][4][ ][4][2]
 [2][ ][ ][ ][0]
 enter the coordinates
 4 3
 [2][ ][ ][ ][ ]
 [ ][3][4][6][ ]
 [2][3][2][ ][ ]
 [ ][4][ ][4][2]
 [2][ ][ ][2][0]
 [-1][1][1][1][1]
 [1][-1][-1][-1][1]
 [-1][-1][-1][1][1]
 [1][-1][1][-1][-1]
 [-1][1][1][-1][-1]
 Game over, you win!
 
  Welcome to the MineSweeper! 
  Choose size of grid(Press 1 for 5x5, Press 2 for 10x10)1
 [0][0][0][0][0]
 [0][0][1][0][0]
 [0][0][1][0][1]
 [1][1][1][1][0]
 [1][0][0][1][0]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 enter the coordinates
 0 0
 [0][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 enter the coordinates
 3 2
 Opps!! you stepped on a bomb, game over
 [0][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ]
 [ ][ ][X][ ][ ]
 [ ][ ][ ][ ][ ]
 [-1][0][0][0][0]
 [0][0][1][0][0]
 [0][0][1][0][1]
 [1][1][1][1][0]
 [1][0][0][1][0]
 
     Welcome to the MineSweeper! 
  Choose size of grid(Press 1 for 5x5, Press 2 for 10x10)2
 [0][1][0][1][1][0][0][0][0][1]
 [0][0][0][1][1][1][0][0][0][0]
 [0][1][1][0][0][0][0][0][0][0]
 [0][0][1][0][1][1][1][0][0][1]
 [0][0][0][0][1][1][0][1][0][1]
 [0][0][1][0][1][0][0][1][1][1]
 [0][0][1][0][0][1][0][0][1][1]
 [1][0][1][0][0][0][1][1][0][0]
 [0][0][0][0][1][1][0][1][0][0]
 [0][0][1][1][0][0][0][0][1][0]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 0 5
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 1 7
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 2 5
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][ ][ ][5][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 7 9
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][ ][ ][5][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 2 3
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 0 6
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 6 2
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 6 4
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 1 3
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][2][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 0 9
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][2][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 enter the coordinates
 9 9
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][2][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][1]
 enter the coordinates
 5 3
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][2][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][2][ ][ ][ ][1]
 enter the coordinates
 6 5
 Opps!! you stepped on a bomb, game over
 [ ][ ][ ][ ][ ][3][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][0][ ][ ]
 [ ][ ][ ][5][ ][5][3][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][X][ ][ ][ ]
 [ ][2][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [1][ ][ ][ ][ ][ ][4][ ][ ][ ]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][2]
 [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 [ ][ ][ ][ ][ ][2][ ][ ][ ][1]
 [0][1][0][1][1][-1][0][0][0][1]
 [0][0][0][1][1][1][0][-1][0][0]
 [0][1][1][-1][0][-1][-1][0][0][0]
 [-1][0][1][0][1][1][1][0][0][1]
 [0][-1][0][0][1][1][0][1][0][1]
 [0][0][1][0][1][0][0][1][1][1]
 [-1][0][1][0][0][1][-1][0][1][1]
 [1][0][1][0][0][0][1][1][0][-1]
 [0][0][0][0][1][1][0][1][0][0]
 [0][0][1][1][0][-1][0][0][1][-1]
 
 
*/