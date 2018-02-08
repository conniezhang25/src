/*
Name: Connie Zhang
Period: 2
Lab: 5
Date: 9/27/16
What I learned:
1. I first didnt subtract the price from 100, so the program outputted the price I inputted as change. Once I realized that I had to return the change, I subtracted the price from 100 to get the change
2. I learned how to input the price I put in, into the print line by seperating the variable and the print statement.
3. I learned that to find the remainder change for each coin, I had to divide by the coin value
*/

import java.util.Scanner;
public class Dispenser 
{
   public static void main(String args[])
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter price of item (from 25 cents to a dollar, in 5-cent increment):");
      
      int price = console.nextInt();
      int change = 100- price;
      int quarters = change / 25;
      int dimes = (change%25)/10;
      int nickels = ((change%25)%10)/5;
      
      System.out.println("You brought an item for "+price+" cents and gave me a dollar, so your change is:");
      System.out.println(quarters + " quarter(s),");
      System.out.println(dimes + " dime(s),");
      System.out.println(nickels + " nickel(s)");
   }
}

/*
      Program Output:
      Enter price of item/n (from 25 cents to a dollar, in 5-cent increment):45
   You brought an item for 45 cents and gave me a dollar, so your change is:
   2 quarter(s),
   0 dime(s),
   1 nickel(s)
*/