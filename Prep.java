public class Prep extends WarriorPt2
{

   public Prep(String name)
   {
      super(name);
   }
   public void generateStats()
   {
       iQ=(int)(Math.random()*61+90); 
       strength=(int)(Math.random()*51+40);
   }
}