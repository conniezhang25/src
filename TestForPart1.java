public class TestForPart1
{
   public static void main (String[] args)
   {
      Warrior lau = new Warrior("lau", 'N');
      Warrior pete = new Warrior("pete", 'J');
      
      lau.generateStats();
      pete.generateStats();
      
      System.out.println(lau);
      System.out.println(pete);
      
      lau.fight(pete);
      
   }
}