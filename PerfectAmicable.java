/*
Name:Connie Zhang
Date:10/31/16
Lab:15
Period:2
Precondition:one int, 2 ints
Postcondition:returns the aliquot sum, perfect numbers,and amicable pairs
What I learned:
1. I learned to use a nested for loop
2. I learned that I had to say x!=y in order not to print the perfect numbers again
*/
import java.util.Scanner;
public class PerfectAmicable
{
   static Scanner console = new Scanner(System.in);
   public static void main (String[] args)
   {  
      System.out.println("Level-A:");
      System.out.println("Aliquot sum:"+Aliquot(console.nextInt()));
      System.out.println("Level-B:");
      System.out.println("Perfect numbers:");
      Perfect();
      System.out.println("Level-C:");
      System.out.println("Perfect numbers:");
      Perfect();
      System.out.println("Amicable pairs:");
      for(int j=2; j<=500; j++)
      {
         for(int k=2; k<=500; k++)
         {
          
          Amicable(j,k); 
         }   
      }
            System.out.println(Prime(5));


     
   }
   public static int Aliquot(int num)
   {
      int sum =0;
         for (int i=1; i<num; i++)
         { 
            if (num%i==0)
            {
               sum+=i;
            }
         }
        return sum;
   }
   public static void Perfect()
   {
      for(int k=2; k<=500; k++)
      {
        if(k==Aliquot(k))
        {
            System.out.println(k);
        } 
      }
   }
   public static void Amicable(int x, int y)
   {
      if (Aliquot(x)==y && Aliquot(y) ==x&& x!=y)
      {
         System.out.println(x+" " +y);
      }
            

   }
   public static boolean Prime(int c)
   {
      for (int i=2; i<c; i++)
      {
         if (c%i==0)
         {
            return false;
         }
      }
      return true;
   }
   


}
/* 
         Program Output:
         
            Level-A:
           15
         Aliquot sum:9
         Level-B:
         Perfect numbers:
         6
         28
         496
         Level-C:
         Perfect numbers:
         6
         28
         496
         Amicable pairs:
         220 284
         284 220

*/