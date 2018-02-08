/*
Name:
Period: 
Date
*/



import java.util.Scanner;

public class Quadform
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      int a = console.nextInt();
      int b = console.nextInt();
      int c = console.nextInt();
      
      findFirstRoot(a,b,c);
      findSecondRoot(a,b,c);
      findDiscriminant(a,b,c);
      
      
     

      

   }
   public static double findFirstRoot(int a, int b, int c)
   {
      double root1 = ((-b + Math.sqrt((b*b)-4*a*c))/(2*a)); 
      System.out.println("The First Root is:" + root1);
      return root1;
   }
   
   
   public static double findSecondRoot(int a, int b, int c)
   {
      double root2 = ((-b - Math.sqrt((b*b)-4*a*c))/(2*a));
      System.out.println("The Second Root is:" + root2);
      return root2;
   }
   public static double findDiscriminant(int a, int b, int c)
   {
      double discriminant = b*b - 4*a*c;
      System.out.println("The Discriminant:" + discriminant);
      return discriminant;
   }
}

