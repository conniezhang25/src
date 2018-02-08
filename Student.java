public class Student
{
   private int studentID;
   private String name;
   private double gPa;
   
   public Student( String name, int studentID, double gPa)
   {
      this.studentID = studentID;
      this.name=name;
      this.gPa=gPa;
   }
   public String toString()
   {
      return "Student ID:" + studentID +
             "\nName:" + name +
             "\nGPA:"  + gPa;
   }
   public int getID()
   {
      return studentID;
   }
   
   public String getName()
   {
      return name;
   }
   
   public double getGPA()
   {
      return gPa;
   }
      
}