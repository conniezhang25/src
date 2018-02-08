/*
Name:Connie Zhang
Period:2
Date:2/8/17
Lab:Phone Call
What I learned:
1.I leanred that child classes can have different method bodies of the same parent class of a method
2.I learned to reuse the methods from the parent class as much as I could
How I feel about this lab:
At first I was confused about how an abtract class and methods would work, allowing the child class customize it to their function, but now I feel that I have a better understanding
*/
public abstract class PhoneCall
{
   private int duration; 
   public PhoneCall(int duration)
   {
      this.duration = duration; 
   }
   public int getDuration()
   {
      return duration;
   }
   abstract double getRate();
   
   private int calculate()
   {
      return (int)(getDuration()*getRate());
   }
   public String toString()
   {
      return "Duration:" + getDuration()+
             "\nRate:" + getRate() +
             "\nTotal cost:" + calculate();
   }
}