/*
Name:Connie Zhang
Date:1/17/17
Period:2
Lab:Student Body
*/
import java.util.Scanner;
public class StudentBody
{
   private Student[] students;

   public StudentBody()
   {
      students = new Student[3];
   }
   public void init()
   { 
      String name; 
      double gPa;
      int id;   
      for (int i =0; i<students.length; i++)
      {
      
          System.out.println ("Enter the name, gpa, and id  of the student you are looking for: ");     
          Scanner keyboard = new Scanner (System.in);    
          name = keyboard.nextLine();
          gPa = keyboard.nextDouble();
          id = keyboard.nextInt();
          
          students[i] =new Student(name,id,gPa);
       }
   }
   public String toString()
   {
      return "\n" + students[0] +
              "\n" + students[1] +
              "\n" + students[2];
   }
   public Student search(int id)
   {
      if(students[0].getID() == id)
      {
         return students[0];
         
      }
      else if(students[1].getID() == id)
      {
         return students[1];
      }
      else if(students[0].getID() == id)
      {
         return students[2];
      }
      else 
      {
         return null;
      }
   }
}
/*
Program output:

 Enter the name, gpa, and id  of the student you are looking for: 
 connie
 4.0
 1446551
 Enter the name, gpa, and id  of the student you are looking for: 
 lau
 3.6
 28495
 Enter the name, gpa, and id  of the student you are looking for: 
 angie
 4.0
 823955
 Enter the id of the student you are looking for: 
 1446551
 Student ID:1446551
 Name:connie
 GPA:4.0
 Student Body Information:
 Student ID:1446551
 Name:connie
 GPA:4.0
 Student ID:28495
 Name:lau
 GPA:3.6
 Student ID:823955
 Name:angie
 GPA:4.0
 
 
 Enter the name, gpa, and id  of the student you are looking for: 
 connie
 5.6
 34895
 Enter the name, gpa, and id  of the student you are looking for: 
 lau
 2.5
 43895
 Enter the name, gpa, and id  of the student you are looking for: 
 angie
 3.5
 34895
 Enter the id of the student you are looking for: 
 28956
 Student not found 
 Student Body Information:
 Student ID:34895
 Name:connie
 GPA:5.6
 Student ID:43895
 Name:lau
 GPA:2.5
 Student ID:34895
 Name:angie
 GPA:3.5

*/