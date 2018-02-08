import javax.swing.*;

public class Capitalize2 {

    public static void main(String[] args) {
        //.. Input a word
        String inputWord = JOptionPane.showInputDialog(null, "Enter a word");

        //.. Process - Separate word into parts, change case, put together.
        String firstLetter = inputWord.substring(0,1);  // Get first letter
        String remainder   = inputWord.substring(1);    // Get remainder of word.
        String capitalized = firstLetter.toUpperCase() + remainder.toLowerCase();

        //.. Output the result.
        JOptionPane.showMessageDialog(null, capitalized);
    }
}