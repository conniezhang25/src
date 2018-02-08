/***********************************************************************************************************************************************
 * Name: Connie Zhang         
 * Period: 5
 * Name of the Lab: TextEditor
 * Purpose of the Program: To experiment with stack and how it works, understand how to manipulate this datat ype 
  * Due Date: 11/12/17
 * Date Submitted:11/11/17
 * What I learned: 
 * 1.I learned that you can only access the top object of a stack 
 * 2.I learned that you have to check if the stack is empty when the char is $ or - in case it is the first character, 
 * so it wont go to the else statement or into the stack. I had trouble with this because at first I wanted to 
 * solve the issue of two $$ or -- in a row. If the stack was already empty from the first - or $, I had to make sure it 
 * didn't cause an exception, which is why I added the statement to check if its wasn't empty into the if statement. However, 
 * this caused a problem when I tested the case of just $ or - in the beginning because it didn't satisfy both conditions and when to the 
 * else statement and pushed into the stack 
 * ... 
 * How I feel about this lab: I feel good about this lab. I think in this lab, it made it easy to visualize where the data was in the stack and how to manipulate it 
 * What I wonder: I wonder if this lab would be more or less efficient if i used a different data type for example array or linked list?
 * Student(s) who helped me (to what extent):  Jackie Yang: helped me to understand the need to check if the stack was empty inside the if statement when checking for $ or - 
 * instead of checking in the same if statement with && because when i did that it went to the else statement and added the char to my stack 
 * Student(s) whom I helped (to what extent): 
 *************************************************************************************************************************************************/
import java.util.Scanner;
import java.util.Stack;
public class TextEditor {

	public static void main (String[] args)
	{
		String yn = "y";
		
	while(!yn.equals("n"))
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line of text: ");
		String s = input.nextLine();
		String output = "";
		
		Stack<Character> edit = new Stack<Character>();
		for(char c:s.toCharArray())
		{
			if(c=='$')
			{
			  if(!edit.isEmpty())
			  {
				while(!edit.isEmpty())
				{
					edit.pop();
				}
			  }
			}
			else if(c=='-')
			{
				if(!edit.isEmpty())
				{
					edit.pop();
				}
			}
			else
			{
				edit.push(c);				
			}
		}
		for(char c:edit)
		{
			output+=c;
		}		
		System.out.println("Here is the line you entered: "+ output);
		
		System.out.println("Again(y/n)?");
		yn = input.next();
	}
			
	}
	

}
/*Program Output:
Enter a line of text: 
Ca-noe$Ra3-fx-t
Here is the line you entered: Raft
Again(y/n)?
y
Enter a line of text: 
AP$$-Compp-utee-r Sic--cei--ience
Here is the line you entered: Computer Science
Again(y/n)?
y
Enter a line of text: 
$test
Here is the line you entered: test
Again(y/n)?
y
Enter a line of text: 
&-
Here is the line you entered: 
Again(y/n)?
_
Enter a line of text: 
$hello$
Here is the line you entered: 
Again(y/n)?
y
Enter a line of text: 
testing
Here is the line you entered: testing
Again(y/n)?
n
*/

