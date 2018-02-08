import javax.swing.*;  // Package containing JOptionPane

public class KmToMiles {
    //==================================================================== constants
    static final double MILES_PER_KILOMETER = 0.621;                       //Note 1

    //========================================================================= main
    public static void main(String[] args) {
        //... Input
        String kmStr = JOptionPane.showInputDialog(null, "Enter number of kilometers.");
        double kilometers = Double.parseDouble(kmStr);                     //Note 2

        //... Computation
        double miles = kilometers * MILES_PER_KILOMETER;

        //... Output
        JOptionPane.showMessageDialog(null, kilometers + " kilometers is "
                                    + miles + " miles.");
    }
}