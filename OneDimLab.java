 /*
Name:Connie Zhang
Period:2
Date:1/10/17
What I learned:
1.I learned that you have to specify the length of an array
2.I learned to use two forloops to make the negative array not the same length as the orginal array
3.I learned to make an index variable to loop through the array to find the position 
 */
 public class OneDimLab
   {
      public static void main(String[] args)
      {
         int [] array = {15, -5, 25, 75, 9, -2, -80, -100, 99, 21, 23, 40, 45, 67,
                          100, 44, 28, 1, 3};
         
      
         System.out.println ("Max: "+findMax(array));
         System.out.println ("Min: " + findMin(array));
         System.out.println ("Max Index: " + findMaxIndex(array));
         System.out.println ("Min Index: "+findMinIndex(array));
         System.out.println ("The fact that 3 is in the array is: "+find (array, 3));
      
         System.out.print("Positive: ");
         printArray (posArray(array));
         System.out.println("");
         System.out.print("Negative:");
         printArray (negArray(array));
         System.out.println("");
      				   
      	
         System.out.print("Even: ");
         printArray (evenMembers(array)); 
         System.out.println("");
         System.out.print("Odd: "); 
         printArray (oddMembers(array)); 			
         System.out.println(""); 
      	      
         System.out.println("Sum : " + sum(array));
         System.out.println("Avg : " + average(array));
      
      }  // main
   
      // post condition: find and return the max element in a
      public static  int findMax(int [] a)
      {
         int max= a[0];
         for (int i = 0; i<a.length; i++)
         {
            if(a[i]>max)
            {
               max = a[i];
            }
         }
         return max;

      }
      //Pre Condition: int array
      // post condition: find and return the index of the max element in a
      public static int findMaxIndex(int [] a)
      {
         int maxIndex = 0;
         for (int i = 0; i<a.length; i++)
         {
            if(a[i]> a[maxIndex])
            {
               maxIndex = i;
            }
         }
         return maxIndex;

      }
      //pre condition: int array
      // post condition: find and return the min element in a
      public static int findMin(int [] a)
      {
         int min= a[0];
         for (int i = 0; i<a.length; i++)
         {
            if(a[i]<min)
            {
               min = a[i];
            }
         }
         return min;

      }
      //pre condition: int array
      // post condition: find and return the index of the min element in a
      public static int findMinIndex(int [] a)
      {
        int minIndex = 0;
         for (int i = 0; i<a.length; i++)
         {
            if(a[i]< a[minIndex])
            {
               minIndex = i;
            }
         }
         return minIndex;


      }
      //pre condition: int array, int target
      // post condition: check to see if target can be found in a or not.  If yes, returns
   //                             true; otherwise, returns false.
      public static boolean find (int [] a, int target)
      {
         
         for(int k = 0; k<a.length;k++)
         {
            if(a[k]==target);
            {
               return true;
            }
         }
         return false; 
	
      } 
      //pre condition: int array
      // post condition: put all the negative numbers in a in an array and return it
      public static int [] negArray (int [] a)
      {
         int [] temp = new int [a.length];
         int index = 0;
         
         for(int i = 0; i<a.length;i++)
         {
            if(a[i]<0)
            {
               temp[index++]= a[i];
            }
            
         }
         
         int [] negative = new int[index];
         for(int i = 0; i<index; i++)
         {
            negative[i]= temp[i];
         }

          return negative;   
      }
      //pre condition: int array
      // post condition: put all the positive numbers in a in an array and return the array
      public static int [] posArray(int [] a)
      {
         int [] temp = new int [a.length];
         int index = 0;
         
         for(int i = 0; i<a.length;i++)
         {
            if(a[i]>0)
            {
               temp[index++]= a[i];
            }
            
         }

         int [] positive = new int [index];         
         for(int i = 0; i<index;i++)
         {
            positive[i] = temp[i];
         }
          return positive;  
      }
   	// pre condition: int array
      // post condition: sum up all the numbers in a and return the sum
      public static int sum (int [] a)
      {
         int sum =0;
         for (int i= 0; i<a.length; i++)
         {
            sum+=a[i];
         }
         return sum;

      }
      // pre condition: int array
      // post condition: find the average of all the numbers in a 
      public static double average(int [] a)
      {
         double sum = 0.0;
         for (int i= 0; i<a.length; i++)
         {
            sum += a[i];
         }
         return sum /a.length;

      }
	   // pre condition: int array
      // post condition: put all the even numbers in a in an array and return the array
      public static int [] evenMembers(int [] a)
      {
         int [] temp = new int [a.length];
         int index = 0;
         
         for(int i = 0; i<a.length;i++)
         {
            if(a[i]%2==0)
            {
               temp[index++]= a[i];
            }
            
         }

         int [] even = new int [index];        
         for(int i = 0; i<index;i++)
         {
            even[i]=temp[i];            
            
         }
         
          return even;
      	
      }
   	// pre condition: int array
      // post condition: put all the odd numbers in a in an array and return the array	 
      public static  int [] oddMembers(int [] a)
      {
         int [] temp = new int [a.length];
         int index = 0;
         
         for(int i = 0; i<a.length;i++)
         {
            if(a[i]%2!=0)
            {
               temp[index++]= a[i];
            }
            
         }

         int [] odd = new int [index];
         for(int i = 0; i<index;i++)
         {
            odd[i]=temp[i];            
            
         }
          return odd;
      }
   	// pre condition: int array
      // post condition: print all the elements in a onto the screen
      public static void printArray (int [] a)
      {
         for (int i = 0; i< a.length; i++) {
            System.out.print(a[i]+",");
         }
      }
   
   }
   /*
   
   Program Output:
   
    Max: 100
 Min: -100
 Max Index: 14
 Min Index: 7
 The fact that 3 is in the array is: true
 Positive: 15,25,75,9,99,21,23,40,45,67,100,44,28,1,3
 Negative:-5,-2,-80,-100
 Even: -2,-80,-100,40,100,44,28
 Odd: 15,-5,25,75,9,99,21,23,45,67,1,3
 Sum : 408
 Avg : 21.473684210526315
   */
   