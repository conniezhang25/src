/*
Name: Connie Zhang
Period:2
Date:10/5/16
Lab:6 pt 2
Pre Condition: none
Post Condition:  multAdd returns the value of the first two doubles multiplied and the last one added, and spike returns the multAdd of the formula given 
What I learned:
1. I learned that you can call a method in another method
2. I learned that you can print out method if you have the arguments in the parenthesis 
3. I learned how to use many functions of the Math method
*/
public class MultAdd
{
   public static void main(String[] args)
   {
        System.out.println(multAdd (1., 2., 3.));
        System.out.println(multAdd(.5,(Math.cos(Math.PI/4)),Math.sin(Math.PI/4)));
        System.out.println(multAdd(Math.log10(10), 1.0, Math.log10(20)));
        System.out.println(yikes(1));
        
   }
   public static double multAdd(double a, double b, double c)
   {
      return a*b+c;
   }
   public static double yikes (double x)
   {
        return multAdd(x, (Math.exp(-x)), Math.sqrt(1-( Math.exp(-x))));
      
   }
   
   
}
/*
               Program Output:
                   5.0
                1.0606601717798212
                2.3010299956639813
                1.1629395387920924  //x=1
                
                5.0
                1.0606601717798212
                2.3010299956639813 
                0.0                 //x=0


*/