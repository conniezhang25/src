/*
Name:Connie Zhang
Period:2
Date:12/2/16
Lab:coin converter
*/
import java.util.Scanner;
public class CoinConverter
{
   Scanner console = new Scanner(System.in);
   private static int numOfCents;
   //pre:none
   //Post:initialized the variables
   public CoinConverter(int numofCents)
   {
      this.numOfCents=numOfCents;
   }
   //pre:none
   //Post:num of quarters is returned
   public int getQuarters()
   {
      return numOfCents/25;
   }
   //pre:none
   //Post:num of dimes is returned
   public int getDimes()
   {
       return (numOfCents%25)/10;
   }
   //pre:none
   //Post:num of nickels is returned
   public int getNickels()
   {
      return  ((numOfCents%25)%10)/5;
   }
   //pre:none
   //Post:num of pennies is returned
   public int getPennies()
   {
      return ((numOfCents%25)%10)%5;
   }
   //pre:none
   //Post:instance variables are printed
   public String toString()
   {
      return "Change:"+numOfCents+"\nQuarters:"+getQuarters()+"\nDimes:"+getDimes()+"\nNickels:"+getNickels()+"\nPennies:"+getPennies();
   }
   public static void main (String [] args)
   {
      CoinConverter machine;
      int amountInCents;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter the amount you want to convert");
      
      numOfCents = input.nextInt();
      machine= new CoinConverter(numOfCents);
      
      System.out.println(machine);
      
   }

}
/*
      Program output:
      Enter the amount you want to convert0
   Change:0
   Quarters:0
   Dimes:0
   Nickels:0
   
       Enter the amount you want to convert100
 Change:100
 Quarters:4
 Dimes:0
 Nickels:0
 Pennies:0
 
     Enter the amount you want to convert95
 Change:95
 Quarters:3
 Dimes:2
 Nickels:0
 Pennies:0
 
     Enter the amount you want to convert99
 Change:99
 Quarters:3
 Dimes:2
 Nickels:0
 Pennies:4
 
     Enter the amount you want to convert60
 Change:60
 Quarters:2
 Dimes:1
 Nickels:0
 Pennies:0
 
     Enter the amount you want to convert75
 Change:75
 Quarters:3
 Dimes:0
 Nickels:0
 Pennies:0

*/