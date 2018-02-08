import java.io.*;
import java.util.Stack;
public class SimpleStack {

	public static void main (String[] args)
	{
		Stack <String> stk = new Stack<String>();
	
		stk.push("one");
		stk.push("two");
		stk.push("three");
		
		String s; 
		while(!stk.isEmpty())
		{
			s=stk.pop();
			if(!stk.isEmpty())
			{
				s+=("_" + stk.pop());
				stk.push(s);
				
			}
			System.out.println(s);
			
		}
		
	}
	
	
	
}
