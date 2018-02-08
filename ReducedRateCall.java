public class ReducedRateCall extends LongDistanceCall
{
   private int duration;
   public ReducedRateCall(int duration)
   {
      super(duration);
   }
   public double getRate()
   {
      return super.getRate()/2;
   }
   public int calculate()
   {
      return super.calculate();
   }
   public String toString()
   {
     return  super.toString() + "RR";
   }
      

}
   
   
