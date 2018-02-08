
import java.util.*;
public class Infix extends Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Enter an infix expression, single digits");
      System.out.println("such as 1+2*3 or (1+2)*3");
      Scanner keyboard = new Scanner(System.in);//  (3*(4+5)-2)/5
      String s = keyboard.next();  
      while(!s.equals("-1"))
      {
         System.out.println(s + "  -->  " + trans(s) + "  -->  " + Postfix.eval(trans(s)) + "\n");
         s = keyboard.next();  
      }
   }
   public static String trans(String x)
   {
	   String postfix = "";
	   Stack<Character> stk = new Stack<Character>();
	   for(char c: x.toCharArray())
	   {
		   if(Character.getNumericValue(c)>0)
		   {
			   postfix +=Character.getNumericValue(c);
		   }
		   else if(c=='(')
		   {
			   stk.push(c);
		   }
		   else if(c==')')
		   {
			   while(!stk.isEmpty()&&stk.peek()!='(')
			   {
				   postfix+=stk.pop();
			   }
			   if(!stk.isEmpty())
			   {
				   stk.pop();
			   }
		   }
		   else if(Postfix.isOperator(c))
		   {
			   if(!stk.isEmpty()&&!isLower(c, stk.peek()))
			   {
				   stk.push(c);
			   }
			   else
			   {
				   while(!stk.isEmpty()&&isLower(c, stk.peek())) //continue while operator is lower in precedence 
				   {
					   if(stk.peek()!='(')
					   {
						   postfix+=stk.pop(); //add to postfix if not paren
					   }
					   else
					   {
						   c = stk.pop(); 
					   }
					   
					   
				   }	
				   stk.push(c);//push if stack is empty 
			   }
			   
		   }
		   
		   
	   }
	   while(!stk.empty())
	   {
		   postfix+=stk.pop();
	   }
      return postfix;
   }
   public static boolean isLower(char char1, char char2)//char2 is lower in precedence
   {
	   if((char2=='+' || char2 == '-') &&(char1 =='+' || char1=='-'))
	   {
		   return true;
	   }
	   else if((char2=='*' || char2 == '/') &&(char1 =='+' || char1=='-'||char1 =='*' || char1=='/'))
	   {
		   return true;
	   }
	   else if((char2 ==')')&(char1 =='+' || char1=='-'||char1 =='*' || char1=='/'))
	   {
		   return true;
	   }
	   else
		   return false;
   }
}
/*
 * OutPut:
 * Enter an infix expression, single digits
such as 1+2*3 or (1+2)*3
3+4*5
3+4*5  -->  345*+  -->  23


3*4+5
3*4+5  -->  34*5+  -->  17


(4+5)-5*3
(4+5)-5*3  -->  45+53*-  -->  -6


(3+4)*(5+6)
(3+4)*(5+6)  -->  34+56+*  -->  77


(3*(4+5)-2)/5
(3*(4+5)-2)/5  -->  345+*2-5/  -->  5



8+1*2-9/3
8+1*2-9/3  -->  812*+93/-  -->  7
 */
