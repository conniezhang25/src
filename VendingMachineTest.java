public class VendingMachineTest 
{

   public static void main (String[] args)
   {
      VendingMachine machine = new VendingMachine();
      VendingMachine javaMachine = new VendingMachine(20);
      
      machine.addCans(20);
      machine.insertToken();
      machine.insertToken();
      
      System.out.println(machine);
      System.out.println(javaMachine);
   }
}