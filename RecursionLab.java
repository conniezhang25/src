/***********************************************************************************************************************************************
 * Name: Connie Zhang         
 * Period: 5
 * Name of the Lab: RecursionLab
 * Purpose of the Program: The purpose of this lab is to understand basics of recursion- 
 * understand difference between iterative and recursive versions
 * Due Date: 10/12/17
 * Date Submitted:10/12/17
 * What I learned: 
 * 1.I learned that in order to return a value through recursion, you must pass the return 
 * to the next call. I had trouble with this concept in the Powerof3 method. I forgot to return the 
 * boolean from the method. This prevented the correct value from being returned. Without this return 
 * statement, I had to return false at the end of the method. 
 * 2. I learned that recursion is not necessarily better than an iterative version. It may just be cleaner and neater.
 * 
 * How I feel about this lab: I felt that this lab was a little challenging. I thought that being able to convert iterative methods into recursive
 * methods took me a while to get a hang of. Other than that, I think that recursive methods are useful and are cleaner methods
 * What I wonder: 
 * Student(s) who helped me (to what extent):  Jackie Yang helped me realize that I need to return my method when I call it 
 * in order to pass the value to the next call. Justin Guo told me that chars have an internal reference of ints
 * Student(s) whom I helped (to what extent):
 *************************************************************************************************************************************************/
import java.util.Scanner;   
public class RecursionLab {

	   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
	   public static void letters(char c)
	   {
		   if(c == 'a')
		   {
			   System.out.println("" + c);
		   }
		   else
		   {
			   letters((char)(c-1));
			   System.out.println(c);
		   }	   
		   
	   }
		//Pre: none - Post: returns number of times two can go into x
	   public static int twos(int x)
	   {
		   if(x%2!=0)
		   {
			   return 0; //if odd, no factors of 2
		   }
		   else if (x%2==0)
	       {
	    	   return 1 + twos(x/2); // add one each time number is divisible 
	       }
		   return 0;
	   }
		//Pre: none - Post: returns if x is a power of 3
	   public static boolean powerof3(int x)
	   {
		   if(x==1)
			  {
				   return true; //check until remainder is 1 --> power of 3
			  }
			  else if(x%3!=0)
			  {
				  return false;  //if not divisible by 3, immediately false
			  }
			  else
			  {
				  return powerof3(x/3);		//return the boolean to return	  
			  }
	   }
		//Pre: none - Post: returns String of x reversed 
	   public static String reverse(long x)
	   {
		   if(x/10==0)
			 {
				 return "" + x;
			 }
			 else
			 {
				 String s = "" + x%10;//start with last digit as first
				 s = s+reverse(x/10);// add next digits
				 return s;
			 }
			 
	   }
		//Pre: x > 0 - Post: Prints x in base 5
	   public static void base5(int x)
	   {
		   if(x<5)
		   {
			   System.out.print(x);
		   }
		   else
		   {
			   base5(x/5);
			   System.out.print(x%5);//find the remainder--> base
		   }
	   }
		// Pre: x > 0 - Post: Prints x with commas
	   public static void printWithCommas(long x)
	   {
	   }
		
		
	   public static void main(String []args)
	   {
	      Scanner scan = new Scanner (System.in);
	      int choice;
	      do
	      {
	         System.out.println("\n\n1)Letters"+
	                           "\n2)Twos"+
	                           "\n3)Power Of 3"+
	                           "\n4)Reverse"+
	                           "\n5)Base 5"+
	                           "\n6)Print With Commas"+
	                           "\n7)Exit");
	         choice = scan.nextInt();
	         if (choice == 1)
	         {
	            System.out.println("Enter a letter");
	            char charA = scan.next().charAt(0);
	            if (charA < 'a' || charA > 'z')
	               System.out.println("That letter not valid");
	            else
	               letters(charA);
	         }
	         else if (choice == 2)
	         {
	            System.out.println("Enter a number");
	            System.out.println(twos(scan.nextInt()));
	         }
	         else if (choice == 3)
	         {
	            System.out.println("Enter a number");
	            System.out.println(powerof3(scan.nextInt()));
	         }
	         else if (choice == 4)
	         {
	            System.out.println("Enter a number");
	            System.out.println(reverse(scan.nextLong()));
	         }
	         else if (choice == 5)
	         {
	            System.out.println("Enter a number");
	            int number = scan.nextInt();
	            if (number > 0)
	               base5(number);
	            else
	               System.out.println("That number is not valid");
	         }
	         else if (choice == 6)
	         {
	            System.out.println("Enter a number");
	            int number = scan.nextInt();
	            if (number > 0)
	               printWithCommas(number);
	            else
	               System.out.println("That number is not valid");
	         }
	      }while(choice != 7);
	   }
}
