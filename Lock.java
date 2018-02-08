/*
Name:Connie Zhang
Period:2
Lab:9
Date:10/13/16
What I learned:
1.I learned that the order you the numbers appear matter when entering a combination code
2. I learned to use the && to combine statements to make my program more clear
3.I learned to type caste the Math.random because it is a double.
*/

import java.util.Scanner;

public class Lock
{
   static Scanner console = new Scanner(System.in);
   public static void main (String [] args)
   {
      int first, second, third;
      
      first = (int)(Math.random() * 50 + 1);
      second = (int)(Math.random() * 50 +1);
      third = (int)(Math.random() * 50 +1);
      
      System.out.println(first+","+second+","+ third);
      
      System.out.println("It is\"" + theLockIsOpen(first, second, third)+"\""+ "that the lock is open.");
      

   }
   public static boolean theLockIsOpen (int first, int second, int third)
   {
      System.out.print("Enter the three numbers. Separate each by a space:");
      int firstNum = console.nextInt();
      int secondNum = console.nextInt();
      int thirdNum = console.nextInt();
      
      if ((Math.abs(first-firstNum)<=3) && (Math.abs(second-secondNum)<=3) && (Math.abs(third-thirdNum)<=3 ))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
 /*
            Program Output:
            19,44,42
            Enter the three numbers. Separate each by a space:20 44 40
         It is"true"that the lock is open.
         
         8,14,5
           Enter the three numbers. Separate each by a space:13 20 2
         It is"false"that the lock is open.]
         
         39,39,1
           Enter the three numbers. Separate each by a space:1 39 39
         It is"false"that the lock is open.
      

 */
}
