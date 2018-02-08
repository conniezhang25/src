   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.text.DecimalFormat;
    public class SubwayTokensPanel extends JPanel
   {
      private JLabel label;
      private double total;
      private JButton reset;
       public SubwayTokensPanel()
      {
         setLayout(new BorderLayout());
         total = 0.0;
      
         JPanel panel = new JPanel();
         panel.setLayout(new GridLayout(2,3));
         add(panel, BorderLayout.CENTER);
         addButton(panel, "+1.00", 1.0);     
         addButton(panel, "+0.10", 0.1);
         addButton(panel, "+0.01", 0.01);
         addButton(panel, "-1.00", -1.0);    
         addButton(panel, "-0.10", -0.1);
         addButton(panel, "-0.01", -0.01);
         
         label = new JLabel("0.00");
         label.setFont(new Font("Serif", Font.BOLD, 20));
         label.setForeground(Color.blue);
         add(label, BorderLayout.NORTH);
  
         reset = new JButton("Reset");
         reset.setEnabled(true);    
         add(reset, BorderLayout.SOUTH);
         reset.addActionListener(new ResetButton());
         
   


      }
       private void addButton(JPanel panel, String s, double x)
      {
         JButton button = new JButton(s);
         button.addActionListener(new Listener(x));
         panel.add(button);
           
      }
       private class Listener implements ActionListener
       {
         private double x;
          public Listener(double x)
         {
            this.x=x;
         }
          public void actionPerformed(ActionEvent e)
         {
            total += x;
            DecimalFormat d = new DecimalFormat("0.00");
            label.setText("$" + d.format(total));
         }
      }
      private class ResetButton implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {         
            total=0; 
            DecimalFormat d = new DecimalFormat("0.00");
            label.setText("$" + d.format(total));
         }
      }

   }