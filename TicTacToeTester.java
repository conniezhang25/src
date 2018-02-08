import javax.swing.JOptionPane;

public class TicTacToeTester
{
   public static void main (String [] args)
	{
	   char player = 'x';
		TicTacToe game = new TicTacToe();
		while (true)
		{
			game.set (row, column, player);
			if (player == 'x')
			  player = 'o';
			else
			  player = 'x';   
           
         if(game.getWinner()=='x')
         {
            System.out.println("x wins");
            break;
         }
         else if(game.getWinner()=='o')
         {
            System.out.println("o wins");
            break;
         }
         else if(game.getWinner()=='t')
         {
            System.out.println("tie game");
            break;
         }
        
		} // while
      System.out.println(game);


	}  // main
} // TicTacToeTester
/*
   Program Output:
   
    | | | |
 | | | |
 | | | |
 
 |x| | |
 | | | |
 | | | |
 
 |x| | |
 |o| | |
 | | | |
 
 |x|x| |
 |o| | |
 | | | |
 
 |x|x|o|
 |o| | |
 | | | |
 
 |x|x|o|
 |o|x| |
 | | | |
 
 |x|x|o|
 |o|x|o|
 | | | |
 
 x wins
 |x|x|o|
 |o|x|o|
 | |x| |
 
 
 | | | |
 | | | |
 | | | |
 
 | | | |
 | |x| |
 | | | |
 
 |o| | |
 | |x| |
 | | | |
 
 |o| | |
 | |x|x|
 | | | |
 
 |o| | |
 |o|x|x|
 | | | |
 
 |o| | |
 |o|x|x|
 | | |x|
 
 |o|o| |
 |o|x|x|
 | | |x|
 
 |o|o| |
 |o|x|x|
 | |x|x|
 
 o wins
 |o|o|o|
 |o|x|x|
 | |x|x|
 
 | | | |
 | | | |
 | | | |
 
 |x| | |
 | | | |
 | | | |
 
 |x| | |
 |o| | |
 | | | |
 
 |x| | |
 |o|x| |
 | | | |
 
 |x| |o|
 |o|x| |
 | | | |
 
 x wins
 |x| |o|
 |o|x| |
 | | |x|
 
 | | | |
 | | | |
 | | | |
 
 | | | |
 | | |x|
 | | | |
 
 | | |o|
 | | |x|
 | | | |
 
 | | |o|
 |x| |x|
 | | | |
 
 | | |o|
 |x|o|x|
 | | | |
 
 | | |o|
 |x|o|x|
 | | |x|
 
 o wins
 | | |o|
 |x|o|x|
 |o| |x|
 
 | | | |
 | | | |
 | | | |
 
 | |x| |
 | | | |
 | | | |
 
 |o|x| |
 | | | |
 | | | |
 
 |o|x|x|
 | | | |
 | | | |
 
 |o|x|x|
 | |o| |
 | | | |
 
 |o|x|x|
 |x|o| |
 | | | |
 
 |o|x|x|
 |x|o|o|
 | | | |
 
 |o|x|x|
 |x|o|o|
 |x| | |
 
 |o|x|x|
 |x|o|o|
 |x|o| |
 
 tie game
 |o|x|x|
 |x|o|o|
 |x|o|x|
 
*/