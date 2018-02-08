/*
Name:Connie Zhang
Period:2
Date:12/14/16
Lab:Palindrome
What I learned
1. I struggled to come up with a way to compare each letter of a string
2. I learned how to use use the replace method
3. I learned to subtract 1 from the length in order to compare the characters in the string  
*/
import java.util.Scanner;
public class Palindrome
{
   public static void main(String[] args)
   {
      String s;
      boolean isPalindrome;
      Scanner console = new Scanner(System.in);
      
      for (int k = 1; k<8; k++)
      {
         System.out.print("Enter a string: ");
         s= console.nextLine();
         
         isPalindrome = check (s);
         if (isPalindrome == true)
         {
            System.out.println(s+" is a palindrome\n\n");
         }
         else
         {
            System.out.println(s+" is NOT a palindrome\n\n");
         }
      }
      
   }
   //Pre: s is a String 
   //Post: return true if s is a palindrome; otherwise, returns false
   public static boolean check(String s)
   {
       s = removeSpace(s);
      int i=0;
      while(i<=s.length())
      {
          if (s.charAt(i)== s.charAt(s.length()-(i+1)))
            if (i==s.length()-1)
            {
               return true;
            }
            else 
            {
               i++;
            }
          else
          {
            return false;  
          }  
          
                    
      }
      return false;
     
      
   }
   //Pre:s is a string
   //Post:return a string without a space in it
   public static String removeSpace(String s)
   {
      
              
       s = s.replace(" ", "");
       return s;
   }
}
/*
      Program Output:
          Enter a string: race car
   race car is a palindrome
   
   
   Enter a string: connie
   connie is NOT a palindrome
   
   
   Enter a string: anna
   anna is a palindrome
   
   
   Enter a string: dad
   dad is a palindrome
*/