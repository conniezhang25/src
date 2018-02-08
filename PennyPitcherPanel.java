import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PennyPitcherPanel extends JPanel
{
   private Square [][] numPennies;
   private JButton[][] pennies;
   private JTextField text;
   private JButton throwButton, reset;
   private int row, col;
   private int penny, total;
   private int count=0;
  // private boolean flag;
   
   public PennyPitcherPanel()
   {
      setLayout(new BorderLayout());
      
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(5,10));
      add(center, BorderLayout.CENTER);
      pennies = new JButton[5][5];
      numPennies = new Square[5][5];
  
      for(int r = 0; r <=4; r++)
      {
         for(int c = 0; c <=4; c++)
         {
            if(r==0||c==0||r==4||c==4)
            {
               numPennies[r][c]=new Square(1, true);
               pennies[r][c]=new JButton("1");
               center.add(pennies[r][c]);    

            }
            else if(r==1||r==3||c==1||c==3)
            {
               numPennies[r][c]=new Square(2, true);
               pennies[r][c]=new JButton("2");
               center.add(pennies[r][c]);    
            }
            else
            {
               numPennies[r][c]=new Square(3, true);
               pennies[r][c]=new JButton("3");
               center.add(pennies[r][c]);    

            }     
           pennies[r][c].setBackground(Color.YELLOW);                 
        
         }
              
    }
       
      
      JPanel south = new JPanel();
      add(south, BorderLayout.SOUTH);
      total =0; 
      text = new JTextField("" + total );
      south.add(text);
      
    
      throwButton = new JButton("THROW");
      south.add(throwButton);
      throwButton.addActionListener(new Listener1());
      
      reset = new JButton("Reset");
      reset.setEnabled(true);    
      south.add(reset);
      reset.addActionListener(new ResetButton());
      


   }

    private class Listener1 implements ActionListener
      {
         public void actionPerformed (ActionEvent e)
         {
               
               row = (int)(Math.random()*5);
               col = (int)(Math.random()*5);
                 
               while(numPennies[row][col].hasPenny())
               { 
                  penny = numPennies[row][col].getNum();
                  pennies[row][col].setText("P");
                  pennies[row][col].setBackground(Color.RED); 
                  count++;
                  total +=penny;
                  text.setText(""+total);
                  //boolean flag=numPennies[row][col].hasPenny();
                  //flag=false; 
                  numPennies[row][col]=new Square(0, false);
 
                  
                  if(count==5) 
                  {
                     throwButton.setEnabled(false);
                  }

                  
               }
         }
      }
      private class ResetButton implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {         
            total=0; 
            text.setText(""+ total);
            
            for(int r=0; r<5; r++)
            {
               for(int c=0; c<5; c++)
               {
                  pennies[r][c].setBackground(Color.YELLOW);
                     if(r==0||c==0||r==4||c==4)
                     {
                        numPennies[r][c]= new Square(1, true);
                        pennies[r][c].setText("1"); 
                        //add(pennies[r][c]);         
                     }
                     else if(r==1||r==3||c==1||c==3)
                     {
                        numPennies[r][c]=new Square(2, true);
                        pennies[r][c].setText("2"); 
                        //add(pennies[r][c]);   
                     }
                     else 
                     {
                        numPennies[r][c]=new Square(3, true);
                        pennies[r][c].setText("3");
                        //add(pennies[r][c]);
         
         
                     }
                     
               }
            } 
            count=0;
            throwButton.setEnabled(true);  

              
         }  
   
   
   }
 }

