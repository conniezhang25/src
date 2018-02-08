public class LocalCall extends PhoneCall
{ 
   private int duration, rate; 
   public LocalCall(int duration, int rate)
   {
      super(duration);
      this.rate = rate;
   }
   public double getRate()
   {
      return rate;
   }
   public int calculate()
   {
      return (int)(getRate()*duration);
   }
   public String toString()
   {
     return  super.toString() + "\nLC";
   }

}