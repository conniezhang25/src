/*
Name:Connie Zhang
Period:2
Date:10/21/16
Lab:11
What I learned:
1. I learned that to be able to access a variable, you need to declare it outside the for loop to be able to use it outside of the for loop
2. I learned how to use a for loop correctly, and how to use the variable that is in the statement
*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class Burger
{
   static Scanner console = new Scanner(System.in);
   public static void main (String[] args)
   {
      final double wage = 5.15;
      final double taxRate = 0.3;
      double totalPay = 0;
      int hours = 0;
      DecimalFormat d = new DecimalFormat("0.00");
      if (hours>=0)
      {
         for (int k=1; k<= 4; k++)
         {
            System.out.print("How many hours did you work in week " + k + "?");
            hours = console.nextInt();
            double pay = (hours * wage)*(1-taxRate);
            System.out.println("Your take-home pay is $"+ d.format(pay));
            totalPay += pay;
         
         }
         
         System.out.println("Your total pay for the month is $" + d.format(totalPay));
         System.out.println("Hope you enjoy working at Babbage Burgers");
       } 
       else
       {
         System.out.println("error! Please enter a positive number");
       } 
      
   }
   
   
}
/*
                  Program Output:
                  
                   How many hours did you work in week 1?35
                Your take-home pay is $126.17
                  How many hours did you work in week 2?41
                Your take-home pay is $147.81
                  How many hours did you work in week 3?37
                Your take-home pay is $133.38
                  How many hours did you work in week 4?45
                Your take-home pay is $162.23
                Your total pay for the month is $569.59
                Hope you enjoy working at Babbage Burgers
                
                 How many hours did you work in week 1?-1
                 Your take-home pay is $-3.60
                   How many hours did you work in week 2?-45
                  Your take-home pay is $-162.2 
                  How many hours did you work in week 3?50
                 Your take-home pay is $180.25
                 How many hours did you work in week 4?20
                 Your take-home pay is $72.10
                 Your total pay for the month is $86.52
                 Hope you enjoy working at Babbage Burgers
                 
                  How many hours did you work in week 1?45
                  Your take-home pay is $162.23
                    How many hours did you work in week 2?50
                  Your take-home pay is $180.25
                    How many hours did you work in week 3?35
                  Your take-home pay is $126.17
                    How many hours did you work in week 4?45
                  Your take-home pay is $162.23
                  Your total pay for the month is $630.88
                  Hope you enjoy working at Babbage Burgers

*/