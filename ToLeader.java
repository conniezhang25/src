import javax.swing.*;

public class ToLeader {

    public static void main(String[] args) {
        String name;               // A local variable to hold the name.

        name = JOptionPane.showInputDialog(null, "What's your name, Earthling");

        JOptionPane.showMessageDialog(null, "Take me to your leader, " + name);
    }
}