/*
Name:Connie Zhang
Period:2
Lab:5 extention
Date:9/27/16
What I learned:
1. At first, I couldnt figure out how to get the penny value. I knew that I had to start with how I got the nickel value, but I had no idea where to go from then. I soon realized that I needed to use the % operator to find the remainder from the nickel. This would result in how many pennies needed for change
2. I learned that I need to test my program with many different cases to make sure it will work with any given problem
*/


import java.util.Scanner;
public class AdvancedDispenser 
{
   public static void main(String args[])
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter price of item (from 25 cents to a dollar:");
      
      int price = console.nextInt();
      int change = 100- price;
      int quarters = change / 25;
      int dimes = (change%25)/10;
      int nickels = ((change%25)%10)/5;
      int pennies = ((change%25)%10)%5;
      
      System.out.println("You brought an item for "+price+" cents and gave me a dollar, so your change is:");
      System.out.println(quarters + " quarter(s),");
      System.out.println(dimes + " dime(s),");
      System.out.println(nickels + " nickel(s)");
      System.out.println(pennies + " penny(ies)");
   }
}
/*
         Program output:
         Enter price of item (from 25 cents to a dollar:1
         You brought an item for 1 cents and gave me a dollar, so your change is:
      3 quarter(s),
      2 dime(s),
      0 nickel(s)
      4 penny(ies)
*/