import java.util.Scanner;

public class CopyOfMaze_shell {
	private final int VISITED = 3;
	private final int PATH = 7;
	private int[][] grid = { 
			{ 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public boolean findAnExit(int x, int y) {
		String path = "";
		return findAnExitHelper(x, y, path);
	} // FindAnExit

	public boolean findAnExitHelper(int x, int y, String path) {
		boolean found = false;
		int maxX = grid.length - 1;
		int maxY = grid[0].length - 1;
		String currLoc = "[" + x + "," + y + "]";
		
		grid[x][y] = VISITED;
		path += currLoc;
		
		if (x == maxX && y == maxY) { // find the exit	
			System.out.println(path);
			return true;
		} 
		
		if (y >= 0 && (y+1) <= maxY && grid[x][y+1] == 1) { // move right
			found = findAnExitHelper(x, y+1, path);
		} else if (x >= 0 && (x+1) <= maxX && grid[x+1][y] == 1) { // move down
			found = findAnExitHelper(x+1, y, path);
		} else if (x <= maxX && (x-1) >= 0 && grid[x-1][y] == 1) { // move up
			found = findAnExitHelper(x-1, y, path);
		} else if (y <= maxY && (y-1) >= 0 && grid[x][y-1] == 1) { // move left
			found = findAnExitHelper(x, y-1, path);
		} 
		
		if (!found) {
			path = path.substring(0, path.length()-currLoc.length());
		}
		
		return found;
	} // findAnExitHelper

	public String toString() {
		String s = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				s += grid[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	} // toString

	public static void main(String[] args) {
		// Assume that the exit of the maze is at the lower right hand corner of
		// the grid
		CopyOfMaze_shell m = new CopyOfMaze_shell();

		// display the maze
		System.out.println(m);
		Scanner input = new Scanner(System.in);

		System.out.println("Enter current location (x and y coordinates: ");
		int startX = input.nextInt();
		int startY = input.nextInt();

		while (!m.findAnExit(startX, startY)) {
			System.out.println("Still trapped inside!");
			System.out.println(m);

			System.out
					.println("Re-enter current location (x and y coordinates: ");
			startX = input.nextInt();
			startY = input.nextInt();
		}

		System.out.println("Successfully exit the maze!!!");

		// display the path (indicated by 7) that leads to the exit of the maze
		// also display locations tried
		System.out.println(m);
	} // main
} // Maze

/********************************
 * Sample Runs Run #1 7 8 [7,8][7,9][7,10][7,11][7,12] Successfully exit the
 * maze!!!
 * 
 * 3 3 3 0 3 3 0 0 0 3 3 3 3 3 0 3 3 3 0 3 3 3 3 0 0 3 0 0 0 0 3 0 3 0 3 0 1 0 0
 * 3 3 3 0 3 3 3 0 3 0 0 1 1 3 0 3 0 0 0 0 3 3 3 0 0 1 3 0 3 3 3 3 3 3 0 3 3 3 0
 * 3 0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 3 3 3 3 3 7 7 7 7 7
 * 
 * 
 * 
 ******************** Run #2 0 0
 * [0,0][0,1][0,2][1,2][1,3][1,4][2,4][3,4][3,5][3,6][2,6][1,6][1,7][1
 * ,8][2,8][3,8][4,8][4,7][5,7][5,6][5,5][5,4][5,3][5,2]
 * [4,2][3,2][3,1][3,0][4,0
 * ][5,0][6,0][7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7][7,
 * 8][7,9][7,10][7,11][7,12] Successfully exit the maze!!!
 * 
 * 7 7 7 0 1 1 0 0 0 1 1 1 1 3 0 7 7 7 0 7 7 7 1 0 0 1 0 0 0 0 7 0 7 0 7 0 1 0 0
 * 7 7 7 0 7 7 7 0 7 0 0 1 1 7 0 7 0 0 0 0 7 7 1 0 0 1 7 0 7 7 7 7 7
 * 
 * 
 ****************************** Run #3 3 12 no way out!
 * 
 * 1 1 1 0 1 1 0 0 0 1 1 1 1 1 0 1 1 1 0 1 1 1 1 0 0 1 0 0 0 0 1 0 1 0 1 0 1 0 0
 * 1 1 1 0 1 1 1 0 1 0 0 3 3 1 0 1 0 0 0 0 1 1 1 0 0 3 1 0 1 1 1 1 1 1 0 1 1 1 0
 * 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1
 *********************************/
