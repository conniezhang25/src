/*
Name:Connie Zhang
Period:2
Lab:6 pt 1
Date:10/5/16
Precondition: none
PostCondition:returns the date in american and european format
What I learned:
1. I learned how to call a method, with the method name and arguments in the parenthesis
2. I learned that I can put different datatypes in the parameters
3. An error I had was I tried to return an int or String, but the method was void, so I had to print it out
*/
public class PrintAmerican
{
   public static void main(String[] args)
   {
   
      printAmerican(16, "July", 2011, "Saturday");
      printEuropean(16, "July", 2011, "Saturday");      
     
   }
   public static void printAmerican(int date, String month, int year, String day)
   {

      System.out.println("American format:");
      System.out.println(day  + "," + month + " " + date + "," + year);

   }
      public static void printEuropean(int date, String month, int year, String day)
   {
      System.out.println("European format:");
      System.out.print(day + " " + date+ " " + month+ "," +" " +year);

   }
}
/*
               Program output:
               
               American format:
            Saturday,July 16,2011
            European format:
            Saturday 16 July, 2011
*/
