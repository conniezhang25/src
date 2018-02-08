
import java.io.*;
   import java.util.*;
   
   public class PrintQueue
   {
      private static Scanner in;
      private static Queue<String> q;
      private static int jobNumber =100;
      
      public static void main(String[] args) throws Exception
      {
         q = new LinkedList<String>();
         in = new Scanner(System.in);
         String prompt = "Add, Print, Delete, eXit:  ";
         System.out.print(prompt);
         String str = in.next();
         while(!str.equals("X"))
         {
            if(str.equals("A"))
               add();
            else if(str.equals("P"))
               printJob();  
            else if(str.equals("D"))
               delete();
            else
               System.out.println("   invalid command");
            printQueue();
            System.out.print(prompt);
            str = in.next();
         }
         in.close();
      }
      
      public static void add()
      {
    	  q.add(jobNumber+"");
    	  jobNumber++;
    	  
      }
      public static void printJob()
      {
    	  System.out.println(q.peek());
      }
   			
      public static void delete()
      {
    	  System.out.println("Enter job number: ");
    	  String delete = in.nextInt()+"";
    	  for(String s: q)
    	  {
    		  if(s.equals(delete))
    		  {
    			  q.remove(s);
    			  System.out.println("Job deleted: "+s);
    			  return;
    		  }      		  
    	  }
    	  System.out.println("Error--job does not exist");
      }
      public static void printQueue()
      { 
    	  System.out.println(q);
      }
   }
   /*
    * Program Output:
    Add, Print, Delete, eXit:  A
	[100]
	Add, Print, Delete, eXit:  A
	[100, 101]
	Add, Print, Delete, eXit:  A
	[100, 101, 102]
	Add, Print, Delete, eXit:  P
	100
	[100, 101, 102]
	Add, Print, Delete, eXit:  A
	[100, 101, 102, 103]
	Add, Print, Delete, eXit:  D
	Enter job number: 
	105
	Error--job does not exist
	[100, 101, 102, 103]
	Add, Print, Delete, eXit:  D
	Enter job number: 
	101
	Job deleted: 101
	[100, 102, 103]
	Add, Print, Delete, eXit:  X
  
   */
