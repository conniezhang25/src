//  Name:Connie Zhang

//  Date:11/14/17
//  Period:5
//  What I Learned:
//1. I learned the importance of order of operations because when you pop the number from the stack 
//it pops the last number, but for division and substraction, you need the second number to subtract of divide first 
//2. I learned that using a stack is very helpful to evaluate expressions because it keeps everything in order 
//
   import java.util.*;
   public class Postfix
   {
      public static void main(String[] args)
      {
         System.out.println("Enter a valid postfix expression (single digits only),");
         System.out.println("such as 35*1+");
         Scanner keyboard = new Scanner(System.in);
         String s = keyboard.next();  
         while(!s.equals("-1"))
         { 
            System.out.println(s + "  --->  " + eval(s) + "\n");
         // //        System.out.println((s = "354*+7*") + " = " + eval(s) + "\n");
         // //          System.out.println((s = "82-") + " = " + eval(s) + "\n");
         // //          System.out.println((s = "82/") + " = " + eval(s) + "\n");
            s = keyboard.next();
         }
      }
      public static int eval(String x)
      {
    	  Stack<Integer> num = new Stack<Integer>();
    	  int result=0;
    	  for(char c:x.toCharArray())
    	  {
    		  if(!isOperator(c))
    		  {
    			  int n = Character.getNumericValue(c);//converts char to int 
    			  num.push(n);
    		  }
    		  else if(isOperator(c))
    		  {
    			  int num1=num.pop();
    			  int num2=num.pop();
    			  result= eval(num2, num1, c);//gets second number first to evaluate subtract and divide correctly 
    		      num.push(result);
    				 
    		  }
    		  
    	  }
    	  return result;//return result after all operations are complete
    	  	 
      }
      public static int eval(int a, int b, char ch)//(5+7)
      {
    	  if(isOperator(ch))
    	  {
    		  if(ch=='+')
    		  {
    			  return a+b;
    		  }
    		  else if(ch=='-')
    		  {
    			  return a-b;
    		  }
    		  else if(ch=='*')
    		  {
    			  return a*b;
    		  }
    		  else if(ch=='/')
    		  {
    			  return a/b;
    		  }
    		  
    	  }
          return 0;
      }
      public static boolean isOperator(char ch)
      {
    	  if(ch=='+' || ch=='-' || ch=='/' || ch=='*')
    	  {
    		  return true;
    	  }
         return false;     
      }
   }
   
   /*
    * Program OutPut:
    * Enter a valid postfix expression (single digits only),
such as 35*1+
345*+
345*+  --->  23


34*5+
34*5+  --->  17


45+53*-
45+53*-  --->  -6


34+56+*
34+56+*  --->  77


345+*2-5/
345+*2-5/  --->  5


812*+93/-
812*+93/-  --->  7
    */