/*
Name:Connie Zhang
Period:2
Lab:13
Date:10/27/16
What I learned:
1.I learned that I had to put 49 instead of 50 in the while loop to get the last number for effectiveness
2. I learned to print the statement first before everything is evaluated to print the original effectiveness.
3. I learend that you could complete the same task with a for loop
*/
public class DrugPotency
{
   public static void main(String[] args)
   {
      int month = 0;
      double e =100.0;
      while(e>49)
      {
         System.out.println("month:" + month + "    effectiveness:"+e);
         month++;
         e*=.96;

      }
        System.out.print("discard");
      
   }
}

/*
               Program output:
                  month:0    effectiveness:100.0
               month:1    effectiveness:96.0
               month:2    effectiveness:92.16
               month:3    effectiveness:88.47359999999999
               month:4    effectiveness:84.93465599999999
               month:5    effectiveness:81.53726975999999
               month:6    effectiveness:78.27577896959998
               month:7    effectiveness:75.14474781081599
               month:8    effectiveness:72.13895789838334
               month:9    effectiveness:69.253399582448
               month:10    effectiveness:66.48326359915008
               month:11    effectiveness:63.82393305518407
               month:12    effectiveness:61.27097573297671
               month:13    effectiveness:58.82013670365764
               month:14    effectiveness:56.46733123551133
               month:15    effectiveness:54.20863798609088
               month:16    effectiveness:52.04029246664724
               month:17    effectiveness:49.95868076798135 
               discard
*/