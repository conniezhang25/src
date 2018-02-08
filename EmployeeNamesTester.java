import java.util.Scanner;
public class EmployeeNamesTester
{
   private static String [] lastName;
   public static void main (String[] args)
   {
      Scanner console = new Scanner(System.in);
      lastName = new String[10];
      String last; 
      
      for(int i=0; i<lastName.length; i++)
      {
         System.out.println("Enter employee number:"+ (i+1)+ "'s last name");
         last = console.nextLine();
      
         lastName[i]=last; 
         
      }
      System.out.println(EmployeeNames.convertName(lastName));
   }
   public String toString()
   {
      for(String u: lastName)
      {
         System.out.println(u);
      }
   }
   
}