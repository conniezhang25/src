public class TestPhoneCall
{
   public static void main(String[] args)
   {
      PhoneCall [] calls = new PhoneCall[4];
      
      calls[0] = new LocalCall(10, 2);
      calls[1] = new LongDistanceCall(3);
      calls[2] = new ReducedRateCall(8);
      
      for(PhoneCall call : calls)
         System.out.println(call+ "\n");
   }
}
/*
   Program Output
   
    Duration:10
 Rate:2.0
 Total cost:20
 LC
 
 Duration:3
 Rate:6.0
 Total cost:18
 LD
 
 Duration:8
 Rate:3.0
 Total cost:24
 LDRR
 
 null
 

*/