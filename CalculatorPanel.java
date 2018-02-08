import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorPanel extends JPanel
{
   private JButton[] numButtons;
   private JTextField text;
   private JButton add, subtract,divide, multiply,equals; 
   private int total;
   private JLabel label;
   private int num;
    
   public CalculatorPanel()
   {
      setLayout(new BorderLayout());
      
      JPanel numbers = new JPanel();
      numbers.setLayout(new GridLayout(5,1));
      add(numbers, BorderLayout.CENTER);
      numButtons = new JButton[10];
  
      for(int k=0; k<10; k++)
      {
         numButtons[k] = new JButton("" + k);
         numbers.add(numButtons[k], BorderLayout.CENTER);
         numButtons[k].addActionListener(new Listener1());
      }
      
      JPanel side= new JPanel();
      add(side, BorderLayout.EAST);
      side.setLayout(new GridLayout(4,1));
      JButton add =new JButton("+");
      side.add(add);
      add.addActionListener(new Listener2());
      JButton subtract =new JButton("-");
      side.add(subtract);
      subtract.addActionListener(new Listener2());
      JButton divide =new JButton("/");
      side.add(divide);
      divide.addActionListener(new Listener2());
      JButton multiply =new JButton("x");
      side.add(multiply);
      multiply.addActionListener(new Listener2());
      JButton equals =new JButton("=");
      side.add(equals);
      equals.addActionListener(new Listener3());
      
      text = new JTextField("");
      add(text, BorderLayout.NORTH);
      
      label= new JLabel("");
      add(label, BorderLayout.SOUTH);      
      
    }
    private class Listener1 implements ActionListener//numbers to text
    {
      public void actionPerformed (ActionEvent e)
      {
         for(int i=0; i<10;i++)
         {
            if(e.getSource().equals(numButtons[i]))
            {
               //label.setText("" + text.getText()); 
               text.setText("" + text.getText()+i); 
               label.setText(label.getText() + text.getText()); 
                num=Integer.parseInt(text.getText());
                total +=num;
                
                                        
            } 
        }
       
      }
    }
    private class Listener2 implements ActionListener//add
    {
        public void actionPerformed (ActionEvent e)//find a way to add num to total with out clicking add but not in set num
       {
             
             label.setText(label.getText()+"+");   
             text.setText("");   
                      
       }
    }
    private class Listener3 implements ActionListener//equals
    {
        public void actionPerformed (ActionEvent e)
        {
            text.setText(""+ total);
        
       }
    }
   
    /*
    else if(e.getSource()==subtract)
           {     
               int num2=Integer.parseInt(text.getText());   
               text.setText("" + (num1-num2));
   
           }   
           else if(e.getSource()==multiply)
           { 
               int num2=Integer.parseInt(text.getText());    
               text.setText("" + (num1*num2));
   
           }
           else if(e.getSource()==divide)
           {   
               int num2=Integer.parseInt(text.getText());    
               text.setText("" + (num1/num2));
   
           }
    */
 } 
  

