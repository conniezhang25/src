/*
name: Connie Zhang
period: 2
Date:9/21/16
Lab:2
What I learned:
1. I learned how to define variables correctly. For example setting numbers a integers and words as Strings.
2. I learned that you can add integers and strings together. This allowed me to put the date together when printing.
3. I learned that you can define more than one variable on the same line if they are the same type.
*/

public class Date
{
   public static void main(String[] args)
   {
      String day, month;
      int date, year;
      day = "Saturday";
      month = "July";
      date = 16;
      year = 2011;
      System.out.println("American format:");
      System.out.println(day  + "," + month + " " + date + "," + year);
      System.out.println("European format:");
      System.out.print(day + " " + date+ " " + month+ "," +" " +year);
      
      
     
   }
}
/*
      Program Output:
      
    American format:
 Saturday,July 16,2011
 European format:
 Saturday 16 July, 2011
*/