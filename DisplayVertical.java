/*
Name: Connie Zhang
Period:2
Date: 9/23/16
Lab: 4b
What I learned
1. I learned how to use the % operand and the / to get a digit of a number
2. I learned to use parenthesis  correctly so that PEMDAS would not affect the digit value
3. I learned that the last digit is always %10

*/

import java.util.Scanner;
public class DisplayVertical
{
   public static void main(String args[])
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter a 4-digit number:");
      int number = console.nextInt();
      int thousands = number/1000;
      int hundreds = (number/100)%10;
      int tens = (number/10)%10;
      int ones = number%10;
      
      System.out.println(thousands);
      System.out.println(hundreds);
      System.out.println(tens);
      System.out.println(ones);
      

   }
}
/*
         Program Output:
         
         Enter a 4-digit number:4863
         4
         8
         6
         3

*/
