/***********************************************************************************************************************************************
 * Name: Connie Zhang         
 * Period: 5
 * Name of the Lab: AreaFill_shell
 * Purpose of the Program: The purpose of this program was to learn how to use recursive backtracing. 
  * Due Date: 10/16/17
 * Date Submitted:10/16/17
 * What I learned: 
 * 1.I learned that it is important to have a return statement once the conditions are invalid. This
 * is important in order for you not to cause a stack overflow error. 
 * 2. I learned to be clear about what index is referring to what. This cause me a lot of 
 * confusion when I was trying to differenciate between the user input and the array. I also had to take 
 * into consideration the first line which was the row and col numbers.
 * 3. I learned that recursively backtracing is very effective when solving problems such as this and 
 * escaping the maze because once one condition is false, you can return back to the previous position and 
 * check from there. 
 * ... 
 * How I feel about this lab: I feel that this lab was very interesting. I think that backtracing recursively is very useful 
 * especially in problems like this. I think that it was good to learn how to code this lab and I learned a lot from it 
 * 
 * What I wonder: 
 * Student(s) who helped me (to what extent):  My mom helped me with the fill method. She explain to me
 * the importance of checking the boundaries first and returning whenever the boundaries were not valid or
 * the char did not match. She also helped me debug the index part when the user entered the row and col because I 
 * got confused with the indexes of the array and the index that the user inputed 
 * Student(s) whom I helped (to what extent): Jackie Yang- I helped her understand how to recursively fill the area and 
 * make sure to check boundaries first in one statement so that once it is invalid, you return
 *************************************************************************************************************************************************/
	   
 import java.util.Scanner;
 import java.io.*;
public class AreaFill_shell {

	      public static char[][] grid = null;
	   
	       public static void main(String[] args) throws FileNotFoundException
	      {
	    	 try
	    	 {
		         Scanner sc = new Scanner(System.in);
		         System.out.print("Filename: ");
		         String filename = sc.next();
		         grid = read(filename);
		         display(grid);
		         System.out.println("Enter character to replace: ");
		         char replace = sc.next().charAt(0);
		         System.out.print("\nEnter ROW COL to fill from: ");
		         int row = sc.nextInt();
		         int col = sc.nextInt(); 
		         fill(grid, row-1, col-1, grid[row-1][col-1], replace); //convert user input to array index
		         display(grid);
		         sc.close();
	    	 }
	    	 catch (ArrayIndexOutOfBoundsException e)
	    	 {
	    		 System.out.println("Invalid!");
	    	 }
	      }
	       public static char[][] read(String filename)throws FileNotFoundException
	      {
	    	   File file = new File("src/"+filename);
	    	   Scanner input = new Scanner(file);
	    	   String line = "";
	    	 
	    	   int row = input.nextInt();
	    	   int col = input.nextInt();
	    	   line = input.nextLine();// absorbs the first line
	    	  
	    	   char[][] fileArr = new char[row][col];
	    	 
	    	   for(int i=0; i<row; i++)
	    	   {
	    		   line = input.nextLine();
	    		   char[] chars = line.toCharArray();//since it is a string, convert to char array 
	    		   
	    		   for(int j=0; j<col; j++)
	    		   {
	    			   
	    			   fileArr[i][j] = chars[j];//fill with chars from each col
	    		   }
	    		   	    	   
	    	   }
	    	    	 
	    	   return fileArr;
	      }
	      
	       public static void display(char[][] g)
	      {  
	         for(int i=0; i<g.length; i++)
	         {
	        	 for(int j=0; j<g[0].length; j++)
	        	 {
	        		 System.out.print(g[i][j]);
	        		 
	        	 }
	        	 System.out.println();
	         }
	      }
	       public static void fill(char[][] g, int r, int c, char ch, char replace) //recursive method
	      {  
	    	 if(r<0 || c<0 || r>=g.length || c>= g[0].length || g[r][c] != ch)//check boundaries and if char is the same as the original 
	    	 {
	    		 return ;
	    	 }
	    	 
	    	 else
	    	 {
	    			 g[r][c] = replace; //replace all similar chars with new char
	    			 fill(g, r+1, c, ch, replace);//keep checking r until not the same char or hits a boundary 
	    			 fill(g, r-1, c, ch, replace);
	    			 fill(g, r, c+1, ch, replace);//keep checking c until not the same char or hits a boundary 
	    			 fill(g, r, c-1, ch, replace);
	    			 
	    	 }
	      }
	   
}

/*
 * Program Output:
 * Filename: area.txt
xxxx............................
...xx...........................
..xxxxxxxxxxxx..................
..x.........xxxxxxx.............
..x...........0000xxxx..........
..xxxxxxxxxxxx0..000............
..xxxxxxxxx...0...00.....0000000
..........xx.......0000000000000
.....xxxxxxxxx........0.........
....xx.................00000....
....xx.....................00...
.....xxxxxxxxxxxxxxxxxx....00...
......................xx...00...
.......................xxxx00000
............................0000
Enter character to replace: 
$

Enter ROW COL to fill from: 10 10
xxxx............................
...xx...........................
..xxxxxxxxxxxx..................
..x.........xxxxxxx.............
..x...........0000xxxx..........
..xxxxxxxxxxxx0$$000............
..xxxxxxxxx$$$0$$$00.....0000000
..........xx$$$$$$$0000000000000
.....xxxxxxxxx$$$$$$$$0.........
....xx$$$$$$$$$$$$$$$$$00000....
....xx$$$$$$$$$$$$$$$$$$$$$00...
.....xxxxxxxxxxxxxxxxxx$$$$00...
......................xx$$$00...
.......................xxxx00000
............................0000


Filename: Area.txt
xxxx............................
...xx...........................
..xxxxxxxxxxxx..................
..x.........xxxxxxx.............
..x...........0000xxxx..........
..xxxxxxxxxxxx0..000............
..xxxxxxxxx...0...00.....0000000
..........xx.......0000000000000
.....xxxxxxxxx........0.........
....xx.................00000....
....xx.....................00...
.....xxxxxxxxxxxxxxxxxx....00...
......................xx...00...
.......................xxxx00000
............................0000
Enter character to replace: 
#

Enter ROW COL to fill from: 1 8
xxxx############################
...xx###########################
..xxxxxxxxxxxx##################
..x.........xxxxxxx#############
..x...........0000xxxx##########
..xxxxxxxxxxxx0..000############
..xxxxxxxxx...0...00#####0000000
..........xx.......0000000000000
.....xxxxxxxxx........0.........
....xx.................00000....
....xx.....................00...
.....xxxxxxxxxxxxxxxxxx....00...
......................xx...00...
.......................xxxx00000
............................0000

Filename: area.txt
xxxx............................
...xx...........................
..xxxxxxxxxxxx..................
..x.........xxxxxxx.............
..x...........0000xxxx..........
..xxxxxxxxxxxx0..000............
..xxxxxxxxx...0...00.....0000000
..........xx.......0000000000000
.....xxxxxxxxx........0.........
....xx.................00000....
....xx.....................00...
.....xxxxxxxxxxxxxxxxxx....00...
......................xx...00...
.......................xxxx00000
............................0000
Enter character to replace: 
%

Enter ROW COL to fill from: 20 20 
Invalid!

Filename: area2.txt
..........00
...0....0000
...000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...00000....
Enter character to replace: 
%

Enter ROW COL to fill from: 9 4
..........00
...0....0000
...000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...%%%%%....

Filename: area2.txt
..........00
...0....0000
...000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...00000....
Enter character to replace: 
#

Enter ROW COL to fill from: 0 4
Invalid!

Filename: area2.txt
..........00
...0....0000
...000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...00000....
Enter character to replace: 
&

Enter ROW COL to fill from: 4 2
..........&&
...&....&&&&
...&&&&&&&&&
&&&&.....&&&
............
..#########.
..#...#####.
......#####.
...00000....


Filename: area2.txt
..........00
...0....0000
...000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...00000....
Enter character to replace: 
^

Enter ROW COL to fill from: 1 4
^^^^^^^^^^00
^^^0^^^^0000
^^^000000000
0000.....000
............
..#########.
..#...#####.
......#####.
...00000....

Filename: area3.txt
+++
@+@
@+@
@@@
Enter character to replace: 
$

Enter ROW COL to fill from: 1 1
$$$
@$@
@$@
@@@

Filename: area3.txt
+++
@+@
@+@
@@@
Enter character to replace: 
*

Enter ROW COL to fill from: 2 1
+++
*+*
*+*
***


 */
