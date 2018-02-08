/*
Name:Connie Zhang
Period:2
Date:10/17/16
Lab:10
What I learned:
I learned that the order for the statements matter for the one that is testing if it is the same point
I learned how to use the logical operators 
*/
import java.util.Scanner;
public class Slope
{
   static Scanner console = new Scanner(System.in);
   public static void main(String[] args)
   {
      System.out.println("Enter the coordinantes of point 1(x,y):");
      int x1 = console.nextInt();
      int y1 = console.nextInt();
      System.out.println("Enter the coordinantes of point 2(x,y):");
      int x2 = console.nextInt();
      int y2 = console.nextInt();
      
      if (x1 == x2 && y1==y2)
      {
         System.out.println("Alert! It is the same point.");
      }
      else if (x1==x2)
      { 
         System.out.println("Alert! The line is vertical.");
         
      }
      else if (y1==y2)
      {
         System.out.println("Alert! The line is horizontal.");
      }
      else
      {
         System.out.println("The slope of the line is:"+(double)(y2-y1)/(x2-x1));
      }

   }
}
/*
            Program Output:
            Enter the coordinantes of point 1(x,y)
            0 5
         Enter the coordinantes of point 2(x,y):
           2 5
          Alert! The line is horizontal. 
         
          Enter the coordinantes of point 1(x,y):
            2 3
          Enter the coordinantes of point 2(x,y):
             1 6
          The slope of the line is:-3.0
   
            Enter the coordinantes of point 1(x,y):
            2 5
          Enter the coordinantes of point 2(x,y):
            4 5
          Alert! The line is horizontal.

            Enter the coordinantes of point 1(x,y):
            2 5
          Enter the coordinantes of point 2(x,y):
            2 5
          Alert! It is the same point.
 

*/