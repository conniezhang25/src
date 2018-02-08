public abstract class WarriorPt2
{
   public String name;
   public int iQ;
   public int strength;
   public boolean alive;
   
   
   //Pre:clique == 'N', 'J', 'P', 'T', 'F' 
   //Post:initializes variables
   public WarriorPt2(String name)
   {
      this.name=name;
      alive=true;
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
   }
   public String getName()
   {
      return name;
   }
   public void die()
   {
      alive = false;
   }
   public boolean isAlive()
   {
      return alive;
   }
   //pre:none
   //Post:random iq and strength are generated based on clique
   public abstract void generateStats();
       //pre:none
   //Post:a winner is choosen based on iq or strength
    public void fight(WarriorPt2 other) 
    {
      if((this.getIq()-other.getIq())>20)
      {
         System.out.println(this.getName() + " wins by IQ.");
         other.die();
      }
      else if((other.getIq()-this.getIq())>20)
      {
         System.out.println(other.getName() + " wins by IQ.");
         this.die();
      }
      else if(this.getStrength()>other.getStrength())
      {
         System.out.println(this.getName() + " wins on strength.");
         other.die();         
      }
      else if(other.getStrength()>this.getStrength())
      {
         System.out.println(other.getName()+ " wins on strength."); 
         this.die();        
      }

    } 
    //pre:none
    //Post:checks if the two warriors are equal
    public boolean equals(WarriorPt2 other)
    {
      return this.name.equals(other.name) &&
             this.iQ==other.iQ&&
             this.strength==other.strength;
    }
    //pre:none
    //Post:initialized variables are printed  
    public String toString()
    {
       return "Name:" + name + 
              "   IQ:"+ iQ +
              "   Strength:"+strength;
    }
    

}
