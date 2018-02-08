//  Name:Connie Zhang 
//  Date:12/10/17
//  Period:5
//  What I Learned:
//1. I learned the difference between an iterator and a for each loop- an
//iterator allows you to change the data structure while a for each loop only iterates through it
//Credits: Thomas Bae- he helped me with the constructor and helping me understand what to cast each variable and 
//the reason for casting them 
import java.util.*;
public class MyStack<E> implements Iterable<E>{
	private static class ListNode <E> 
	   {    
	      private E value;    
	      private ListNode <E>  next; 
	      public ListNode  (E  initValue, ListNode <E> initNext)    
	      { 
	         value = initValue; 
	         next = initNext; 
	      }  
	      public E getValue()  
	      { 
	         return value; 
	      }    
	   
	      public ListNode <E> getNext() 
	      { 
	         return next;  
	      } 
	   
	      public void setValue(E theNewValue)
	      { 
	         value = theNewValue;
	      }
	   
	      public void setNext(ListNode  <E> theNewNext)
	      { 
	         next = theNewNext; 
	      }
	   
	   }  // end of ListNode

	private ListNode<E> head;
	
	public MyStack ()
	{
		head=(ListNode <E>)new ListNode<Object> (0, null); // cant instatiate E --> Object
		ListNode <E> ll = head;//temporary list node to hold head value b/c dont want to change pointer of head
		for(int i=1; i<10;i++)
		{	
			ListNode<E> temp = (ListNode<E>)new ListNode<Object> (i, null); //new listnode to add each time
			ll.setNext(temp);
			ll = ll.getNext();
		}
		
	}
	public E push(E obj)
	{
		head = new ListNode<E> (obj,head);
		return obj;
	}
	public E pop()
	{
		E temp = head.getValue();
		head = head.getNext();
		return temp;
	}
	
	public E peek()
	{
		return head.getValue();
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	public Iterator <E> iterator()
	{
		return new MyIterator();
	}
	
	public class MyIterator <E> implements Iterator<E>
	{
		private ListNode temp = head;
		public boolean hasNext()
		{	
			return (temp!=null);
		}
		
		public E next()
		{
			E val = (E)temp.getValue();//store current value
			temp= temp.getNext(); //shift pointer
			return val;
		}
		
	}
	public static void main (String[] args)
	{
		MyStack <Integer> s = new MyStack <Integer>();
		
		Iterator<Integer> iter = s.iterator();
		System.out.println("Traversing s using an iterator:");
		while(iter.hasNext())
		{
			System.out.print(iter.next());
		}
		
		System.out.println("\n\nTraversing s using a for-each loop: ");
		for(int i:s)
		{
			System.out.print(i);
		}
	}
	

}
/*
 * Traversing s using an iterator:
0123456789

Traversing s using a for-each loop: 
0123456789
 * 
 */
