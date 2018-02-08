import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListNodeLinkedListLab
{

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

   public static void main(String [] args)
   {
      Scanner input = new Scanner (System.in);
      ListNode <Integer> h = new ListNode(2, null);
      h= new ListNode(7, h);
      h= new ListNode(3, h);
      h= new ListNode(9, h);
      h= new ListNode(15, h);
        
      char option ;
      do
      {
         option = menu();
         if( option  == 'a')
         {
            System.out.println("list: ");
            printLinkedList(h);
         }	
         else if(option == 'b')
         {
            System.out.println("The List has atleast two element?");
            System.out.println(hasTwo(h));
         }	
         else if( option  =='c')
         {
            System.out.print("The size of the array is: ");
            System.out.println(size(h));
         }	
         else if( option  == 'd')
         {
            h = removeFirst(h);
            System.out.print("New list is: ");
            printLinkedList(h);
         }
         else  if( option  == 'e')
         {
            System.out.println("Enter number: ");
            int num = input.nextInt();
            add(h, new Integer(num));
            System.out.println("New list is: ");
            printLinkedList(h);
         }
         else if( option  == 'f')
         {
            h = reverseList(h);
            System.out.println("Reverse is: ");
            printLinkedList(h);
         }
         else if( option  == 'g')
         {
            h = rotate(h);
            System.out.println("rotated array is: ");
            printLinkedList(h);
         }
         else if( option  == 'h')
         {
            printLinkedList(h);
            System.out.println("\nmiddle node is: "+middleNode(h).getValue());
         }
         else if( option  == 'i')
         {
            h = removeLastRecur(h);
            System.out.print("New list is: ");
            printLinkedList(h);
         }
         else if( option  == 'k')
         {
            h = addLastRecur(h, 6);
            System.out.print("New list is: ");
            printLinkedList(h);
         }
         else if( option  == 'j')
         {
         
            System.out.println("Enter number: ");
            int val = input.nextInt();
             h = remove(h, val);
            System.out.println("New list is: ");
            printLinkedList(h);
         }
              
      } while (option != 'z');
   
   }  // end of main
   //Precondition: none
   //Postcondition:print ListNodes
   public static void printLinkedList(ListNode <Integer> head)
   {
      for(ListNode<Integer> temp = head; temp!=null; temp = temp.getNext())
      {
         System.out.println(temp.getValue());
      }
   }
   //Precondition:none
   //Postcondition:check if linked list has more than two ListNodes
   public static boolean hasTwo(ListNode <Integer> head)
   {
      int count =0; 
      for(ListNode<Integer> temp = head; temp!=null; temp = temp.getNext())
      {
         count++;
      }
      if(count >=2)
      {
         return true;
      }

      return false;
   
   }
   
  
    //Precondition:none
   //Postcondition:returns the size of the linkedlist
   public static int size(ListNode <Integer> head)
   {
      int count =0; 
      for(ListNode<Integer> temp = head; temp!=null; temp = temp.getNext())
      {
         count++;
      }
      return count;
   }
   //Precondition:none
   //Postcondition:removes the first listnode
   public static ListNode <Integer> removeFirst(ListNode <Integer> head)
   {	
     ListNode<Integer> temp = head; //create temp ListNode to refer to the first Listnode
     head = head.getNext();//set original head to next Listnode
     temp = null;//set temp to null to cut off the reference
     return head;
   }
   //Precondition:none
   //Postcondition:removes the last listnode
   public static ListNode <Integer> removeLastRecur(ListNode <Integer>  head)
   {	
      if(head==null)
      {
         return null;
      }
      else if(head.getNext()==null)
      {
          return head.getNext();
      }
      else
      {
         head.setNext(removeLastRecur(head.getNext()));
         return head;
      }
   }
   
   public static ListNode <Integer> removeLast(ListNode <Integer>  head)
   {	
      if(head!=null)
      {
         ListNode<Integer> temp = head;
         ListNode<Integer> previous = head;
         while(temp.getNext()!=null)
         {
            previous = temp; //follow the temp pointer
            temp = temp.getNext(); //moves the temp pointer to next node
            /*if(size(temp)==1)
            {
               temp = null;
            }*/
         }//ends if next node is null, but keeps previous at the node before/last node
         previous.setNext(null);//ends the linked list bc last is set to null
      }
      return head;
   }

   //Precondition:none
   //Postcondition:removes listnode at given value
   public static ListNode <Integer> remove(ListNode<Integer> head, Integer value)
   {	
      
       ListNode <Integer>temp = head;
       ListNode <Integer>previous = head;
       if(temp.getValue()==value)//removes first value
       {
         head = head.getNext();
         
       }
       else
       {
          while(temp!=null)
          {
            if(temp.getValue() == value)
            {
               previous.setNext(temp.getNext());//sets the current node to the next node
               break;
            }
            else
            {
              previous = temp;//previous follows temp 
              temp= temp.getNext();
            }
              
          }
      
     }
       return head;
   
  }
   //Precondition:none
   //Postcondition:adds listnode to the end
   public static void add(ListNode <Integer> head, Integer value)
   {
        ListNode<Integer> addNode = new ListNode<Integer>(value,null);//create new node to add
        ListNode<Integer> temp = head;
        while(temp.getNext()!=null)
        {
           temp = temp.getNext();//get to the last node
        }
        temp.setNext(addNode);//add node at the end
         
        
   }
   
   public static ListNode<Integer> addLastRecur(ListNode <Integer> head, Integer item)
   {
      if(head==null)
      return null;
      else if(head.getNext()==null)
      {
         head.setNext(new ListNode<Integer> (item, null));
         return head;
      }
      else
      {
         head.setNext(addLastRecur(head.getNext(), item));
         return head;
      }
   }
   //Precondition:none
   //Postcondition:reverses the listnode order
   public static ListNode <Integer>  reverseList(ListNode <Integer> head)
   {
      ListNode<Integer> temp = head;
      ListNode<Integer> newHead = new ListNode<Integer> (getLastVal(temp),null);//newhead is same as reverse but keeps pointer at the head
      ListNode<Integer> reverse = newHead;//create new listnode starting with last value
      
      while(temp.getNext()!=null)
      {
         removeLast(temp);//keeps removing last node until null
         ListNode<Integer> next = new ListNode<Integer> (getLastVal(temp),null);//gets the new last node
         reverse.setNext(next);//set next as the new last node -> reverse
         reverse = reverse.getNext();      
      }

      return newHead;
   }
   //Precondition:none
   //Postcondition:returns value of last listnode
   private static int getLastVal(ListNode <Integer> head)
   { 
      int last=0;
      for(ListNode<Integer>temp=head ;temp!=null; temp=temp.getNext())
      {
         last = temp.getValue();
      }
      return last;
   }
   //Precondition:none
   //Postcondition:rotates the last listnode to the front 
   public static ListNode <Integer> rotate(ListNode<Integer> head)
   {  
      ListNode<Integer> first = new ListNode<Integer>(getLastVal(head), null);//create a listnode with value of last listnode
      
      ListNode<Integer> temp= head;
        first.setNext(head);//add new listnode to front
        head = first;
        removeLast(head);//remove last listnode and set to null

     return head;
                
   }
   
   //Precondition:head is not null
   //Postcondition:returns middle node
   public static ListNode <Integer> middleNode(ListNode <Integer>head)
   {  
      ListNode<Integer> middleNode = head;

      if(head!=null)
      {
         int middle = size(head)/2;//get middle index
                  for(int i=0; i<middle; i++)
         {
            middleNode = middleNode.getNext();//middlenode value is set until reach middle index
         }
              
      }
       return middleNode;

      
   }
   //Precondition:none
   //Postcondition:quits
   public static void quit()
   {
      System.exit(0);
   }

   public static char menu()
   {
      Scanner input = new Scanner (System.in);
      System.out.println("\n====> What would you like to do?");
      System.out.println("a) Print list");
      System.out.println("b) Check if list has at least two nodes");
      System.out.println("c) Get size of the list");
      System.out.println("d) Remove first node");
      System.out.println("e) Add a node");
      System.out.println("f) Reverse");
      System.out.println("g) Rotate");
      System.out.println("h) Get middle node");
      System.out.println("i) Remove last node");
      System.out.println("j) Remove node");
      System.out.println("z) Quit?");
      String choice = input.next();
      return choice.charAt(0);   
   }  // end of menu
}
