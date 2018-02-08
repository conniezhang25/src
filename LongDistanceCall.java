public class LongDistanceCall extends PhoneCall
{
   private int duration; 
   public LongDistanceCall(int duration)
   {
      super(duration);
   }
   public double getRate()
   {
      return 6.0;
   }
   public int calculate()
   {
      return (int)(getDuration()*getRate());
   }
   public String toString()
   {
     return  super.toString() + "\nLD";
   }
      

}
   