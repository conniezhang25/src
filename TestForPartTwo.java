public class TestForPartTwo
{
   public static void main (String[] args)
   {
      WarriorPt1[] fighters = new WarriorPt1 [5];
      fighters[0]=new Nerd("Connie");
      fighters[1] = new Jock("Angie");
      fighters[2] = new Prep("Anisha");
      fighters[3]=new Thug("Sally");
      fighters[4]=new Freak("Jill");
      
      for (WarriorPt1 u: fighters)
      {
         u.generateStats();
      }
      
      int fighter = (int)(Math.random()*5);
      int fighter2 = (int)(Math.random()*5);
      
      while(fighter==fighter2)
      {
         fighter2 = (int)(Math.random()*5);
      }
      
      System.out.println(fighters[fighter].getName()+ " fights " + fighters[fighter2].getName());
      fighters[fighter].fight(fighters[fighter2]);    

   }
}
/*
    Anisha fights Angie
 Anisha wins on strength.
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java TestForPartTwo
 Connie fights Anisha
 Connie wins by IQ.
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java TestForPartTwo
 Jill fights Anisha
 Jill wins on strength.
*/