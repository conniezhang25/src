public class EmployeeNamesTest
{
   public static void main (String[] args)
   {
      String [] lastName ={"Lau", "Zhang", "Lopez", "Smith"}; 
      String[] formattedNames=new String [lastName.length];
      formattedNames = EmployeeNames.convertName(lastName);      
      for(int i=0; i<lastName.length; i++)
      {
          System.out.println(formattedNames[i]);     
      }
      
   }
}
/*

      Program Output:
      U.A.Lau
   G.N.Zhang
   Z.E.Lopez
   H.T.Smith
 

*/
