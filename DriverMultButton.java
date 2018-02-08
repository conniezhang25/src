import javax.swing.*;
public class DriverMultButton
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
          
      JFrame frame = new JFrame("Lab 00");
      frame.setSize(400,350);
      frame.setLocation(200,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PanelMultButton());
      frame.setVisible(true);

   }
}
      
   