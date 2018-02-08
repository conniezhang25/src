/*
Name:Connie Zhang
Period:2
Date:10/13/16
Lab:8
What I learned:
1. I learned that the else statement doesnt need a condition in order to execute. 
2. Before I added the statement for the numbers to be equal, when I tried to run the program wouldnt have an output becuase I didnt have a condition for that case, so I realized I needed another case 
3. I learned not to put a ; at the end of a statement because when I accidently did, it gave me an error else without if. I was confused by this statement because I thought I included an if statement, however the compiler couldnt recognize it 
*/

import java.util.Scanner;

public class Division
{
   static Scanner console = new Scanner(System.in);
   public static void main (String[] args)
   {
      System.out.print("Enter first number:");
      int first = console.nextInt();
      System.out.print("Enter second number:");
      int second = console.nextInt();
      
      if (first>second)
      {
         int quotient= first/second;
         int remainder = first % second;
         System.out.println("quotient:" +quotient);
         System.out.println("remainder:" +remainder);
      }
      else if (second>first)
      {
         int quotient= second/first;
         int remainder = second % first;
         System.out.println("quotient:"+quotient);
         System.out.println("remainder:"+remainder);
      }
      else
      {
         int quotient= first/second;
         int remainder = first % second;
         System.out.println("quotient:" +quotient);
         System.out.println("remainder:"+remainder);

      }
      
   }
}
/*
                  Program output:
                  Enter first number:3
                 Enter second number:7
               quotient:2
               remainder:1
               
               Enter first number:5
               Enter second number:2
               quotient:2
               remainder:1
                  
                  Enter first number:4
                 Enter second number:4
               quotient:1
               remainder:0
*/