/*
Name: Connie Zhang
Date:1/19/17
Lab:Employee Names
Period:2
What I learned:
1. I learned how to create a method that returns an array
2. I learned to store values like Strings in an array

*/
public class EmployeeNames
{

   public static String[] convertName(String[] lastName)
   {
      String [] formattedNames = new String[lastName.length];
      
      for (int i=0; i<lastName.length; i++)
      {
         String upperName = lastName[i].toUpperCase();
         formattedNames[i]= upperName.substring(upperName.length()-1)+
                           "." + upperName.substring(upperName.length()-2, upperName.length()-1)+
                           "." + lastName[i];
      }
      
      return formattedNames; 
      
   }
}