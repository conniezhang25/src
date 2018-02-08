import java.util.ArrayList;
public class TestForPartThree
{
   public static void main(String[] args)
   {
      ArrayList <WarriorPt2> list = new ArrayList<WarriorPt2>();
      
      WarriorPt2 connie = new Nerd ("Connie");
      WarriorPt2 angie = new Jock ("Angie");
      WarriorPt2 anisha = new Prep ("Anisha");
      WarriorPt2 sally = new Thug ("Sally");
      WarriorPt2 jill = new Freak ("Jill");
      
      list.add(connie);
      list.add(angie);
      list.add(anisha);
      list.add(sally);
      list.add(jill);
      
      int fighter;
      int fighter2;
      while(list.size()!=1)
      {
          fighter = (int)(Math.random()*list.size());
          fighter2 = (int)(Math.random()*list.size());
         
         for (WarriorPt2 v: list)
         {
            v.generateStats();
         }
        
         while(fighter==fighter2)
         {
            fighter2 = (int)(Math.random()*list.size());
         }
   
         System.out.println("\n"+list.get(fighter).getName()+ " fights " + list.get(fighter2).getName());
         
         list.get(fighter).fight(list.get(fighter2)); 
         
         if(list.get(fighter).isAlive()==false)
         {
            list.remove(fighter);
         }
         else
         {
            list.remove(fighter2);
         } 
      }
      System.out.println(list+"is the winner");



   }
}
/*

 Jill fights Sally
 Jill wins by IQ.
 
 Connie fights Jill
 Jill wins by IQ.
 
 Jill fights Angie
 Jill wins on strength.
 
 Anisha fights Jill
 Anisha wins by IQ.
 [Name:Anisha   IQ:105   Strength:57]is the winner
*/