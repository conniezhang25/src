
import java.util.*;
public class ParenMatch
{
   public static final String left  = "([{<";
   public static final String right = ")]}>";
   public static void main(String[] args)
   {
   
      System.out.println("Enter an expression with grouping symbols,");
      System.out.println("such as (2+3)-[5*(6+1)]IndexMals");
      Scanner keyboard = new Scanner(System.in);
      String s = keyboard.next();  
      while(!s.equals("-1"))
      {
         boolean flag = check(s);
         if(flag)
            System.out.println(s + " is good.");
         else
            System.out.println("No, no, no.  Bad.  " + s);
         System.out.println();
         s = keyboard.next();
      }
   }
   // precondition:
   // postcondition: 
   public static boolean check(String s)
   {
	   
	   Stack <Character> stack = new Stack<Character>();
	   boolean flag=  true;
	   for(char c: s.toCharArray())
	   {
		   if(c=='[' || c=='{'|| c=='('||c=='<')
		   {
			   stack.push(c);	   //push left parens into stack to compare 
		   }
		   else if((c==']' || c=='}'|| c==')' ||c=='>'))
		   {			    
				 if(stack.isEmpty()) //check if there is a left paren 				
					 return false;
				 
				 else if(right.indexOf(c) == left.indexOf(stack.peek())) //compare the index of left and right parens
				 {
					 stack.pop();
					 flag = true;
				 }
				 else 
					 return false;
				 
				 
				 //System.out.println(right.indexOf(c));
				 //System.out.println(left.indexOf(stack.pop()));				 
		   }
		   
		   if(!stack.isEmpty())//check if matching at the end--> no left over parens 
			   flag=false;
	   }  
		   return flag;
   }
}
/*
 * Program Output:
 * Enter an expression with grouping symbols,
such as (2+3)-[5*(6+1)]IndexMals
5+7
5+7 is good.

(5+7)
(5+7) is good.


)5+7(
No, no, no.  Bad.  )5+7(


((5+7)*3)
((5+7)*3) is good.


((5+7)*)3
((5+7)*)3 is good.

<{5+7}*3>
<{5+7}*3> is good.

(5+7)*3
(5+7)*3 is good.


5+(7*3)
5+(7*3) is good.


((5+7)*3
No, no, no.  Bad.  ((5+7)*3


[(5+7]*3)
No, no, no.  Bad.  [(5+7]*3)


[(5+7)*3])
No, no, no.  Bad.  [(5+7)*3])


([(5+7)*3]
No, no, no.  Bad.  ([(5+7)*3]

 */
