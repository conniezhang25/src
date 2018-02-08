public class Nerd extends WarriorPt2
{

   public Nerd(String name)
   {
      super(name);
   }
   public void generateStats()
   {
      int iQ=(int)(Math.random()*61+120); 
      strength=(int)(Math.random()*61+20);
   }
}