public class Jock extends WarriorPt2
{

   public Jock(String name)
   {
      super(name);
   }
   public void generateStats()
   {
        iQ=(int)(Math.random()*61+80); 
        strength=(int)(Math.random()*51+50);
   }
}