/*
Name:Connie Zhang
Period:2
Date:2/10/17
Lab:Nerd Wars Pt2 and Pt3
What I learned:
1.I learned that you can modify an abstract method in a subclass
2.I learned to extend classes to inherit abstract methods
*/
public abstract class WarriorPt1
{
   public String name;
   public int iQ;
   public int strength;
   
   //Pre:clique == 'N', 'J', 'P', 'T', 'F' 
   //Post:initializes variables
   public WarriorPt1(String name)
   {
      this.name=name;
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
   //pre:none
   //Post:random iq and strength are generated based on clique
   public abstract void generateStats();
   //pre:none
   //Post:a winner is choosen based on iq or strength
    public void fight(WarriorPt1 other) 
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
    public boolean equals(WarriorPt1 other)
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
