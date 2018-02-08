/***********************************************************************************************************************************************
 * Name: Connie Zhang         
 * Period: 5
 * Name of the Lab: DLL
 * Purpose of the Program: The purpose of this program was to learn the basic methods of DLL 
 * learn the differences between DLL and SLL
  * Due Date: 10/7/17
 * Date Submitted:10/7/17
 * What I learned: 
 * 1.I learned that DLL is a lot easier to code because of the function getPrev. This allows 
 * the user to be able to go backwards in a linked list. I think this is easier than SLL because 
 * it has more functions.
 * 2. I learned that in DLL, you can link it so that it becomes circular. This is helpful so 
 * that you can reference the last index based on head. 
 * 3. I learned that having a dummy head node is very helpful in referencing nodes in the linked 
 * list because it makes my code more efficient 
 * ... 
 * How I feel about this lab: I felt that this lab was significantly easier to code than the SLL
 * lab. This was mostly due to the versatility of DLL. It makes it very easy to get access to almost
 * every node without having to tediously loop through it. Also, having the function to go backwards
 * in the list is very useful as well. 
 * What I wonder: 
 * Student(s) who helped me (to what extent):  Angie Zhou and Megan Liu: helped me debug my add Last method.
 * Student(s) whom I helped (to what extent):
 *************************************************************************************************************************************************/
public class DLL <E>
{
   // private static nested class
   private class DLNode <E>
   {
      private E value;
      private DLNode prev;
      private DLNode next;
      public DLNode(E arg, DLNode <E> p, DLNode <E> n)
      {
         value=arg;
         prev=p;
         next=n;
      }
      public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
      public void setValue(E arg)
      {
         value=arg;
      }
      public void setNext(DLNode <E> arg)
      {
         next=arg;
      }
      public void setPrev(DLNode <E> arg)
      {
         prev=arg;
      }
      public DLNode <E> getNext()
      {
         return next;
      }
      public DLNode <E> getPrev()
      {
         return prev;
      }
      public E getValue()
      {
         return value;
      }
   }  // end of DLNode
   
   //*********************************************************************************************  DLL class

   private int size;
   private DLNode <E> head = new DLNode <E> (); //dummy node--very useful--simplifies the code
   
 //Precondition:none
  //Postcondition: returns size
   public int size()
   {
      return size;
   }
   
 //Precondition:none
   /* appends obj to end of list; increases size;
     @return true  */
   public boolean add(E obj)
   {
	   if(size==0)
	   {
		   DLNode<E> newLast = new DLNode<E> (obj, head, head);//adds node after head
		   head.setPrev(newLast);
		   head.setNext(newLast);
	   }
	   else
	   {
		   DLNode<E> newLast = new DLNode<E> (obj, head.getPrev(), head);//constructs new node at end
		   
		     head.getPrev().setNext(newLast);	   //links head to last value
		     head.setPrev(newLast);
		   }
	   
	   size++;
	   return true;
      
   }
   //Precondition: index does not equal 0
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, E obj)
   {
	   int c=0; 
	   
	   for(DLNode<E>temp = head.getNext(); temp!=head; temp = temp.getNext())
	   {
		   c++;//gets the node at the index
		   if(c== index)
		   {
			   DLNode<E> add = new DLNode<E> (obj, temp.getPrev(), temp); //constructs node at that index
			   temp.getPrev().setNext(add);
			   temp.setPrev(add);
			   
		   }
	   }
	   size++;
   }
   //Precondition:none
   /* return obj at position index.  
   	*/
   public E get(int index)
   {
	   int c=0;
      for(DLNode<E>temp = head.getNext(); temp!=head; temp = temp.getNext())
      {
    	  c++;  //index of node
    	  if(c == index)
    	  {
    		 return temp.getValue();
    	  }
      }
      return null;
   }
 //Precondition:index does not equal 0
   /* replaces obj at position index.  
   	*/
   public void set(int index, E obj)
   {
	   
	   int c=0;
	   
	   for(DLNode<E>temp = head.getNext(); temp!=head; temp = temp.getNext())
	   {
		   c++;
		   if(c==index)
		   {
			   temp.setValue(obj);	//changes temp to be new node value
		   }
	   }
	   
   }
 //Precondition:index does not equal 0
   /*  removes the node from position index.  decrements size.
     @return the object at position index.
    */
   public E remove(int index)
   {
      int c=0; 
      for(DLNode<E> temp = head.getNext(); temp!=head; temp = temp.getNext())
      {
    	  c++;
    	  if(c == index)
    	  {
    		  DLNode<E> prev = temp.getPrev();	//gets nodes before and after temp
    		  DLNode<E> next = temp.getNext();
    		  
    		  prev.setNext(next);	//set prev and next to be linked, cuts off temp
    		  next.setPrev(prev);
    		  
    		  size--;
    		  return temp.getValue();
    	  }
      }
      return null;
  }
   
 //Precondition:none
   /* inserts obj at front of list; increases size;
     */
   public void addFirst(E obj)
   {
	   DLNode<E> first = new DLNode<E> (obj, head, head.getNext());//constructs new node at first position
	   head.setNext(first);
	   first.setPrev(head);
   }
   
 //Precondition:none
   /* appends obj to end of list; increases size;
       */
   public void addLast(E obj)
   {
	   add(obj);	//same as add method before
   }
   
 //Precondition:none
   //Postcondition: returns first node
   public E getFirst()
   {
      return head.getNext().getValue();
   }
   
 //Precondition:none
   //Postcondition:returns last node
   public E getLast()
   {
      return head.getPrev().getValue();
   }
   
 //Precondition:none
   //Postcondition: removes first node
   public E removeFirst()
   {
	   DLNode<E> first = new DLNode<E> (getFirst(), head, head.getNext().getNext());
	   head.setNext(first.getNext());	//sets head to the second value, cuts off first node
	   first.getNext().setPrev(head);
	   
      return first.getValue();
   }
   
   //Precondition:none
   //Postcondition: removes last node
   public E removeLast()
   {
      DLNode<E> last = new DLNode<E> (getLast(), head.getPrev().getPrev(), head);
      head.setPrev(last.getPrev());
      last.getPrev().setNext(head);		//sets the second to last node to head, cuts off original last node
      
      return last.getValue();
   }
   
 //Precondition:none
   //PostCondition:returns list as a string
   public String toString()
   {
	   String s ="";
	   for(DLNode<E>temp = head.getNext(); temp!=head; temp = temp.getNext())
	   {
		  s+= "\n" + temp.getValue();
	   }
	   return s;
   }



   public static void main(String args[])
   {
      DLL <String> list = new DLL <String> ();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Dumpling");
      list.add("Escargot");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(3);
      System.out.println(list);
      System.out.println("Size: " +list.size());
      System.out.println("Removed "+ obj);
      System.out.print("Add at 3:   ");
      list.add(3,"Cheese");
      System.out.println(list);
      System.out.println("Get values at 1 and first: " + list.get(1)+" and " + list.getFirst());
      System.out.println("No change: " +list);
      System.out.println( list.removeFirst() + " is now removed!"); 
      System.out.println(list);
      System.out.print("Add first:  ");
      list.addFirst("Anchovie");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      System.out.print("Set the second:  ");
      list.set(2, "Rread");
      System.out.println(list);
   }
}


