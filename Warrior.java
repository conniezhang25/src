/*
Name:Connie Zhang
Period:2
Date:12/2/16
Lab:Warrior
*/
public class Warrior
{
   private String name;
   private int iQ;
   private int strength;
   private char clique;
   
   //Pre:clique == 'N', 'J', 'P', 'T', 'F' 
   //Post:initializes variables
   public Warrior(String name, char clique)
   {
      this.name=name;
      this.clique=clique;
   }
   //Pre:none
   //Post:the clique is returned
   public char getClique()
   {
      return clique;
   }
   //pre:none
   //Post:strength is returned
   public int getStrength()
   {
      return strength;
   }
   //pre:none
   //Post:IQ is returned
   public int getIq()
   {
      return iQ;
   }//pre:none
   //Post:random iq and strength are generated based on clique
   public void generateStats()
   {
      if (getClique()=='N')
      {
        iQ=(int)(Math.random()*61+120); 
        strength=(int)(Math.random()*61+20);
      }
      else if (getClique()=='J')
      {
        iQ=(int)(Math.random()*61+80); 
        strength=(int)(Math.random()*51+50);
      }
      else if (getClique()=='P')
      {
        iQ=(int)(Math.random()*61+90); 
        strength=(int)(Math.random()*51+40);
      }
      else if (getClique()=='T')
      {
        iQ=(int)(Math.random()*31+60); 
        strength=(int)(Math.random()*21+80);
      }
      else if (getClique()=='W')
      {
        iQ=(int)(Math.random()*121+60); 
        strength=(int)(Math.random()*100+1);
      }
    }  
    //pre:none
   //Post:a winner is choosen based on iq or strength
    public void fight(Warrior other) 
    {
      if((this.getIq()-other.getIq())>20)
      {
         System.out.println(name + " wins by IQ.");
      }
      else if((other.getIq()-this.getIq())>20)
      {
         System.out.println(name + " wins by IQ.");
      }
      else if(this.getStrength()>other.getStrength())
      {
         System.out.println(name + " wins on strength.");         
      }
      else if(other.getStrength()>this.getStrength())
      {
         System.out.println(name + " wins on strength.");         
      }

    } 
    //pre:none
    //Post:checks if the two warriors are equal
    public boolean equals(Warrior other)
    {
      return this.name.equals(other.name) &&
             this.clique==other.clique &&
             this.iQ==other.iQ&&
             this.strength==other.strength;
    }
    //pre:none
    //Post:initialized variables are printed  
    public String toString()
    {
       return "Name:" + name + 
              "   Clique:"+clique +
              "   IQ:"+ iQ +
              "   Strength:"+strength;
    }
    

}
/*
      Program Output:
      
          Name:lau   Clique:N   IQ:142   Strength:45
       Name:pete   Clique:J   IQ:135   Strength:71
       lau wins on strength.
*/