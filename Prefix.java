
	   import java.util.*;
	   public class Prefix extends Infix
	   {
	      public static void main(String[] args)
	      {
	         System.out.println("Enter a valid prefix expression (single digits only),");
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
	    	  }
	    	  for(int c=x.length()-1; c>=0;c--)
	    	  {
	    		 if(isOperator(x.charAt(c)))
	    		  {
	    			  int num1=num.pop();
	    			  int num2=num.pop();
	    			  result= eval(num2, num1, x.charAt(c));//gets second number first to evaluate subtract and divide correctly 
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
