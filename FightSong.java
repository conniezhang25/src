/*
Name:Connie Zhang
Period:2
Date:10/3/16
Lab:6a(fight song)
What I learned:
1. You can't put a method in another method
2. I leanred not to write too many unnessecary methods like blank lines
3. I learned that System.out.print does not require a datatype to print out. You need a void method so it doesnt return anything. 
*/

public class FightSong
{
   public static void main(String[] args)
   {
      goTeam();
      doIt();
      System.out.println();
      goTeam();
      doIt();
      theBest();
      System.out.println("In the West.");
      goTeam();
      doIt();
      System.out.println();
      goTeam();
      doIt();
      theBest();
      System.out.println("in the West.");
      goTeam();
      doIt();
      System.out.println();
      goTeam();
      doIt();

      

      
   }
      public static void goTeam()
      {
         System.out.println("Go, team, go!");
      }
      
      public static void doIt()
      {
         System.out.println("You can do it.");
      }
      
      public static void theBest()
      {
         System.out.println("You're the best,");
      }
      


      
}

/*
            Program output:
            
            Go, team, go!
         You can do it.
         
         Go, team, go!
         You can do it.
         You're the best,
         In the West.
         Go, team, go!
         You can do it.
         
         Go, team, go!
         You can do it.
         You're the best,
         in the West.
         Go, team, go!
         You can do it.
         
         Go, team, go!
         You can do it.

*/