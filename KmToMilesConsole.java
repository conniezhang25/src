import java.util.*;  // Package containing Scanner

public class KmToMilesConsole {
    //==================================================================== constants
    static final double MILES_PER_KILOMETER = 0.621;                       //Note 1

    //========================================================================= main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);                               //Note 2

        //... Input
        System.out.print("Enter number of kilometers: ");
        double kilometers = in.nextDouble();

        //... Computation
        double miles = kilometers * MILES_PER_KILOMETER;

        //... Output
        System.out.println(kilometers + " kilometers is " + miles + " miles.");
    }
}