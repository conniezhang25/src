import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorDriver
{ 
    public static void main(String[] args)
   {
      boolean USE_CROSS_PLATFORM_UI = true;
      if(USE_CROSS_PLATFORM_UI)
      {
         try
         {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
         } 
         catch (Exception e) 
         {
            e.printStackTrace();
         }
      }
          
      JFrame frame = new JFrame("Calculator");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setContentPane(new CalculatorPanel());
      frame.setVisible(true);
   }
   
}