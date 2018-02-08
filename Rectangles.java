/*
Name: Connie Zhang
Period: 2
Date:9/21/16
Lab:3
What I learned:
1. I learned that the Scanner class allows you to input values that you can use in your program
2. I learned that the operands work like PEMDAS so I had to put parenthesis around the value I wanted to multiply
3. I learned that the Scanner only takes in integers because I set it that way. For example, I can't type in the word "five" because that is a string 
*/

import java.util.Scanner;

public class Rectangles
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter a width:");
      int width = console.nextInt();
      System.out.print("Enter a height:");
      int height = console.nextInt();
      int area, perimeter;
      area = width*height;
      perimeter = 2*(width+height);
      System.out.println("Area:"+area);
      System.out.print("Perimeter:"+perimeter);
   }
}
/*
      Program output:
      
      Enter a width:6
      Enter a height:4
      Area:24
   Perimeter:20
      
    
*/