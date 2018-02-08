public class Thug extends WarriorPt2
{
   public Thug(String name)
   {
      super(name);
   }
   public void generateStats()
   {
       iQ=(int)(Math.random()*31+60); 
       strength=(int)(Math.random()*21+80);

   }
}