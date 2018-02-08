import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PennyPitchDriver
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
          
      JFrame frame = new JFrame("Penny Pitcher!");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setContentPane(new PennyPitcherPanel());
      frame.setVisible(true);
   }
   
}