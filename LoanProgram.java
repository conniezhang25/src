/*
Name:Connie Zhang
Period:2
Date:10/11/16
Lab:7
Pre-Condition:none
Post-Condition:return the year, rate, amount, that was given by the user and payment returns the monthly payment calculated by the formula
What I learned:
1. I learned that to multiply the value of a method, it is much easier to store that value into a variable and mutiply that way, so it isnt as confusing
2. An error I had was trying to figure out how to display the payment. I soon realized the meaning behind the decimal format and used that in my program
3. I learned that you can use another method as arguments for another methid as long as you store the value into a variable

*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanProgram
{
   static Scanner console = new Scanner(System.in);
   public static void main(String[] args)
   {
      int years;
      double amount, rate, payment;
      amount = getAmount();
      rate = getRate();
      years = getYears();
      payment = findPayment(amount, rate, years);
      displayPayment(payment);
       
   }
   
   public static double getAmount()
   {
      System.out.print("Enter the amount the be borrowed:");
      double a = console.nextDouble();
      if (a<0 || a > 100000)
      {
         System.out.print ("invalid. Enter Amount:");
         a = console.nextDouble();
         
      }
      return a;
   }
   public static double getRate()
   {
      System.out.print("Enter the annual interest rate as a percent:");
      double rate = console.nextDouble();
      if (rate<0 || rate > 10)
      {
         System.out.print ("invalid. Enter rate:");
         rate = console.nextDouble();
         
      }
      return rate/100.0/12.0;

   }
     public static int getYears()
   {
      System.out.print("Enter the length of the loan in years:");
      int years = console.nextInt();
      if (years<0 || years > 20)
      {
         System.out.print ("invalid. Enter rate:");
         years = console.nextInt();
         
      }
      return years;
   }
   public static double findPayment(double amount, double rate, int years)
   {
      amount = getAmount();
      rate = getRate();
      years = getYears();
      return amount*(rate)*Math.pow(((rate)+1), (years*12))/(Math.pow(((rate)+1), (years*12))-1);
   }
   public static void displayPayment(double payment)
   {
     DecimalFormat d = new DecimalFormat("0.00");
     System.out.println("Monthly payment:$" + d.format(payment));
   }
}
/*
         Program Output;
         
          Enter the amount the be borrowed:2500
          Enter the annual interest rate as a percent:4
          Enter the length of the loan in years:2
        Monthly payment:$108.56

*/
