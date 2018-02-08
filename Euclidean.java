/*
Name:Connie Zhang
Period:2
Date:10/24/16
Lab:12
Pre-condition:Enter 2 positive integers
Post-condition:returns the GCD
What I learned:
1. I learned how to use a while loop effectively 
2. I learned that I needed to switch the variables in order to find the GCD
*/
import java.util.Scanner;
public class Euclidean
{
   static Scanner console = new Scanner(System.in);
   public static void main(String[] args)
   {
         System.out.println("Enter a positive number:");
         int n1=console.nextInt();
         if (n1<=0)
         {
            System.out.println("Error!Enter a positive number!");
            n1= console.nextInt();
         }
         
         System.out.println("Enter a positive number:");
         int n2=console.nextInt();
         if (n2<=0)
         {
            System.out.println("Error!Enter a positive number!");
            n2=console.nextInt();
         }
         
         int larger;
         int smaller;
         if (n1>n2)
         {
             larger = n1;
             smaller = n2;
         }
         else
         {
             larger = n2;
             smaller = n1;
         }
             
             System.out.println("The GCD is:"+gcd(n1, n2));         
   }
         public static int gcd (int larger, int smaller)
         {
            while(smaller!=0)
            {
               int remainder = larger%smaller;
               int temp = smaller;       
               larger = temp;
               smaller = remainder;               
            }
               int gcd = larger;
               return gcd;  
         }
   
   
}
/*
               Program Output:
               Enter a positive number:
               56
            Enter a positive number:
              16
            The GCD is:8
            
            Enter a positive number:
              -3
            Error!Enter a positive number!
              56
            Enter a positive number:
              16
            The GCD is:8
            
            Enter a positive number:
              56
            Enter a positive number:
              -2
            Error!Enter a positive number!
              16
            The GCD is:8
 
            Enter a positive number:
              16
            Enter a positive number:
              56
            The GCD is:8
            


*/