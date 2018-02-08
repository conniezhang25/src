public class Freak extends WarriorPt2
{

   public Freak(String name)
   {
      super(name);
   }
   public void generateStats()
   {
       iQ=(int)(Math.random()*121+60); 
        strength=(int)(Math.random()*100+1);


   }
}