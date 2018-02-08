	//Name:   Connie Zhang
	//Date:2/4/18
	// What I learned:I learned that in order to compare items, I need to make sure the value is in bounds and is not null
	//I learned that the item does not have to be greater than all the items on the level above, just its parents
	// How I feel about this lab:
	// I am wondering:
	//Credits: Angie Zhou helped me realize that I need to check if the index is in bounds and not null in order to keep comparing. 
	//Jackie Yang helped me to understand the need to keep track of the items index to keep reheaping up and down.
	import java.util.*;
public class Zhang_Connie_Pd5_HeapPriorityQueueLab {

	   private static final int DFLT_CAPACITY = 1024;
	   private Object items[];  // use a 1-D array instead of ArrayList
	   private int numItems;  // number of elements in items


	  
	   public Zhang_Connie_Pd5_HeapPriorityQueueLab()
	   {
	         items = new Object[DFLT_CAPACITY];
	         numItems=0;
	   }
	   
	   
	   public Zhang_Connie_Pd5_HeapPriorityQueueLab (int initialCapacity)
	   {
	          items = new Object[initialCapacity];
	          numItems = 0;
	   }
	   
	   public boolean isEmpty()
	   {
	         
	      return numItems==0;  
	   
	   }
	   
	   public Object peek()
	   {
	      return items[0];  	    
	   }
	   
	   public Object remove()
	   {
		  System.out.println("removed: " + peek());
	      Object temp = items[numItems-1];
	      items[0] = temp;					//swap first and last element to make remove easier
	      temp = items[numItems-1];
	      items[numItems-1] = null; //delete "last" element
	      numItems--;
	      reheapDown(); //reheap the new root down to correct space
	      
	      return temp;
	   }
	   
	   public boolean add(Object obj)
	   {
		   
		   if(numItems==items.length)
		      {
		    	  doubleCapacity();		//if added more items than intended, double 
		      }
		 
	      items[numItems] = obj;
	      numItems++;
	      reheapUp();  //correct position on new item 
	      return true;  
	     
	   }
	   public void swap(int a, int b)
	   {
		   Object temp = items[a];
		   items[a] = items[b];
		   items[b] = temp;
	   }
	   private void reheapDown()
	   {
		   int deletePos = 0;
		   //if the object is less than its children, keep reheaping
		   while((((((Comparable)(items[(deletePos*2)+1])).compareTo((Comparable)(items[deletePos])))<0)||(((((Comparable)(items[(deletePos*2)+2])).compareTo((Comparable)(items[deletePos])))<0))))
		   {
			   if(items[deletePos*2+1] !=null&&(items[deletePos*2+2] !=null))//make sure children arent null before comparing 
			   {
				   if(((((Comparable)(items[(deletePos*2)+1])).compareTo((Comparable)(items[deletePos])))<0)&&((((((Comparable)(items[(deletePos*2)+2])).compareTo((Comparable)(items[deletePos])))<0))))
				   {
					   if(((((Comparable)(items[(deletePos*2)+1])).compareTo((Comparable)(items[(deletePos*2)+2])))<0))
					   {
						   swap(deletePos, deletePos*2+1);			   
						   deletePos = (deletePos*2)+1;		   
					   }
					   else if((((((Comparable)(items[(deletePos*2)+2])).compareTo((Comparable)(items[(deletePos*2)+1])))<0)))//find smallest child and swap 
					   {
						   swap(deletePos, deletePos*2+2);
						   deletePos = (deletePos*2)+2;
					   }

				   }
				   else if(((((Comparable)(items[(deletePos*2)+1])).compareTo((Comparable)(items[deletePos])))<0))//if only one child is smaller, swap 
				   {
					   swap(deletePos, deletePos*2+1);			   
					   deletePos = (deletePos*2)+1;	
				   }
				   else 
				   {
					   swap(deletePos, deletePos*2+2);			   
					   deletePos = (deletePos*2)+2;	
				   }
			   
			   } 
			   else if((items[deletePos*2+1])==null&&(items[deletePos*2+2] !=null))//if only child but still smaller, swap 
				{
				   swap(deletePos, deletePos*2+2);			   
				   deletePos = (deletePos*2)+2;	
				}
			   else if((items[deletePos*2+1])!=null&&(items[deletePos*2+2] ==null))
				{
				   swap(deletePos, deletePos*2+1);			   
				   deletePos = (deletePos*2)+1;	
				}
			   if(deletePos*2+2>numItems)//make sure to not swap with item not in array 
			   {
				   break;
			   }   
				   
		   }
		   
		   display();
		   System.out.println();
		 
	   }

	     
	   private void reheapUp()
	   {
			   int addedPos = numItems-1;
				   while((((Comparable)(items[addedPos])).compareTo((Comparable)(items[(addedPos-1)/2])))<0)//if item is smaller than its parent, swap 
				   {	
					   System.out.println("swapped: " + items[addedPos]);
					   swap(addedPos,(addedPos-1)/2);
					   addedPos = (addedPos-1)/2;			   		   
				   }
				   display();
				   System.out.println();
				 
			
	   }
	   private void display()
	   {
		   for(int i=0; i<numItems; i++)
		   {
			   System.out.print(items[i]+ " ");
		   }
	   }
	   
	   private void doubleCapacity()
	   {   
		   Object[] doubleItems = new Object[numItems*2];
		   
		   for(int i=0; i<numItems;i++)
		   {
			   doubleItems[i] = items[i];
		   }
		   		   items = doubleItems;
	   }

	public static void main(String[] args)
	{
		Zhang_Connie_Pd5_HeapPriorityQueueLab test = new Zhang_Connie_Pd5_HeapPriorityQueueLab(10);
		test.add(10);
		test.add(20);
		test.add(80);
		test.add(40);
		test.add(60);
		test.add(85);
		test.add(99);
		test.add(50);
		test.add(700);
		System.out.println();

		
		System.out.println("adding new: ");
		System.out.println();
		test.add(21);
		System.out.println();

		test.add(100);
		System.out.println();

		test.add(55);
		System.out.println();


		System.out.println("deleting: ");
		System.out.println();
		test.remove();
		System.out.println();

		test.remove();
		System.out.println();

		test.remove();	
		System.out.println();


	}
	     
	}  //HeapPriorityQueue_shell

/*
 * Program Output:
 * 10 
10 20 
10 20 80 
10 20 80 40 
10 20 80 40 60 
10 20 80 40 60 85 
10 20 80 40 60 85 99 
10 20 80 40 60 85 99 50 
10 20 80 40 60 85 99 50 700 

adding new: 

swapped: 21
10 20 80 40 21 85 99 50 700 60 

10 20 80 40 21 85 99 50 700 60 100 

swapped: 55
swapped: 55
10 20 55 40 21 80 99 50 700 60 100 85 

deleting: 

removed: 10
20 21 55 40 60 80 99 50 700 85 100 

removed: 20
21 40 55 50 60 80 99 100 700 85 

removed: 21
40 50 55 85 60 80 99 100 700 

 * 
 */

