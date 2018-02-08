import java.util.Scanner;
public class LinearEquationSolver
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner (System.in);
      
      System.out.print("Enter the coefficients of the linear equation:");
      
      double m, b;
      m=input.nextDouble();
      
      b=input.nextDouble();
      
      System.out.println("The Solutions of the equation:"+ (-1.0*b/m));   }
}
