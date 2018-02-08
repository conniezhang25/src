

 // NOTE:  use for-each loops or iterators, not regular for-loops
   import java.io.*;
   import java.util.*;
    public class IteratorLab_shell
   {
       public static void main(String[] args)
      {
         System.out.println("Iterator Lab\n");
         int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
         for(int n : rawNumbers )
            System.out.print(n + " ");    
         ArrayList<Integer> numbers = createNumbers(rawNumbers);
         System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
         System.out.println("Count negative numbers: " + countNeg(numbers));
         System.out.println("Average: " + average(numbers));
         System.out.println("Replace negative numbers: " + replaceNeg(numbers));
         System.out.println("Delete zeros: " + deleteZero(numbers));
         String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
         ArrayList<String> movies = createMovies(rawMovies);
         System.out.println("Movies: " + movies);
         System.out.println("Movies: " +  removeDupes(movies));
      }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
       public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
    	   ArrayList<Integer> list = new ArrayList<Integer>();
    	   for(int i: rawNumbers)
    	   {
    		   list.add(i);
    	   }
    	   return list;
      }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
       public static ArrayList<String> createMovies(String[] rawWords) 
      {
    	   ArrayList<String> list = new ArrayList<String>();
    	   for(String s: rawWords)
    	   {
    		   list.add(s);
    	   }
    	   return list;
      }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
       public static int countNeg(ArrayList<Integer> a)
      {
    	   int count=0;
    	   for(int n: a)
    	   {
    		   if(n<0)
    			   count++;
    	   }
    	   return count;
      }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
       public static double average(ArrayList<Integer> a)
      {
    	   double sum=0;
    	   int count=0;
    	   
    	   for(int i: a)
    	   {
    		   sum+=i;
    		   count++;
    	   }
    	   return sum/count;
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
       public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
      {
    	   ListIterator<Integer> iter = a.listIterator();
    	   while(iter.hasNext())
    	   {
    		   if(iter.next()<0)
    			   iter.set(0);
    	   }
    	   return a;
    	   
    	   
    		   
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
       public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
      {
    	  Iterator<Integer> iter = a.iterator();
    	   while(iter.hasNext())
    	   {
    		   if(iter.next()==0)
    			   iter.remove();
    	   }
    	   return a;
    	   
    	   
       
      }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: start with an empty array and add movies as needed
       public static ArrayList<String> removeDupes(ArrayList<String> a)
      {
          ArrayList<String> movies = new ArrayList<String>();
          
          for(String s: a)
          {
        	  boolean found=false;
        	  for(String u: movies)
        	  {
        		  if(s.equals(u))
        			  found=true; 			  
        	  }
        	  if(!found)
            	  movies.add(s);
          }
          
          return movies;
      }
   
   }
/*Program OutPut:
 * Iterator Lab

-9 4 2 5 -10 6 -4 24 20 -28 ArrayList: [-9, 4, 2, 5, -10, 6, -4, 24, 20, -28]
Count negative numbers: 4
Average: 1.0
Replace negative numbers: [0, 4, 2, 5, 0, 6, 0, 24, 20, 0]
Delete zeros: [4, 2, 5, 6, 24, 20]
Movies: [High_Noon, High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No, Dr_No, Mary_Poppins, High_Noon, Tron]
Movies: [High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No]

 * */
