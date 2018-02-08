import javax.swing.*; 

public class KmToMilesFormat {
    //==================================================================== constants
    static final double MILES_PER_KILOMETER = 0.621;
    
    //========================================================================= main
    public static void main(String[] args) {
        //... Input
        String kmStr = JOptionPane.showInputDialog(null, "Enter number of kilometers.");
        double kilometers = Double.parseDouble(kmStr);
        
        //... Computation
        double miles = kilometers * MILES_PER_KILOMETER;
        
        //... Output
        String outStr = String.format("%.2f kilometers is %.2f miles.", kilometers, miles);
        JOptionPane.showMessageDialog(null, outStr);
    }
}