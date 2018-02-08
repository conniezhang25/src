/*
Name:Connie Zhang
Period:2
Date:12/2/16
Lab:Vending machine
What I learned:
1.I learned that using a default constructor and non default constructor can have the same output if u call a method or first assign it to a variable
2.I learned that it matters which order you set your variables equal to
*/
public class VendingMachine
{
   private int sodaCanCount;
   private int tokenCount;
   
   //pre:none
   //Post:set variables to default values
   public VendingMachine()
   {
      sodaCanCount=10;
      tokenCount=0;
   }
   //pre:none
   //Post:initialized the variables
   public VendingMachine(int cans)
   {
      sodaCanCount=cans;
      tokenCount=0;
   }
   //pre:none
   //Post:changes the token number and soda can count
   public void insertToken()
   {
      tokenCount++;
      sodaCanCount--;
   }
   //pre:none
   //Post:increases the sodacancount by the number of cans
   public void addCans(int cans)
   {
      sodaCanCount+=cans;
   }
   public String toString()
   {
      return "Cans:"+sodaCanCount+"\ntokens:"+tokenCount;
   }
}



/*
         program output:
         Cans:28
         tokens:2
         Cans:20
         tokens:0

*/