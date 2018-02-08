/*
name: Connie Zhang
period:2
Date:9/23/16
Lab: 4a
What I learned:
1.I learned that the nextInt can be assigned to multiple variables because it stores it in a variable each time a new input is entered
2.I learned that there are many ways to code one program.
3.I learned to put parenthesis around the entire value you want to divide or else another value will be printed out.
*/
import java.util.Scanner;

public class Average
{
   public static void main(String args[])
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter a number:");
      int a = console.nextInt();
      System.out.print("Enter a number:");
      int b = console.nextInt();
      System.out.print("Enter a number:");
      int c = console.nextInt();
      
      int average = (a+b+c)/3;
      System.out.println(average);
      
    
   }
}
/*
            Program Output:
            
            Enter a number:4
            Enter a number:6
            Enter a number:2
           4
*/