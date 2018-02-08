/*
Name:Connie Zhang
Period:2
Date:12/16/16
Lab:Sentence information
*/
import java.util.Scanner;
public class SentenceInformation
{ 
   public static void main (String[] args)
   {
      Scanner console = new Scanner(System.in);
      String str = console.nextLine();
      
      int length = str.length();
      
      System.out.println("Length of the sentence: " + str.length());
      System.out.println("Number of words: " + numWords(str));
      System.out.println("Average word length" + averageLength(str));
      
   }
   
   public static int getSpaces(String s)
   {
      int count =0;
      int index = 0;
      for (int i=0; i<=s.length(); i++)
      {
         index = s.indexOf(" ", index);
         if(index !=-1)
         {
            count++;
            index++;
         }
         else 
            break;
      }
      return count;
      
   }
   public static int numWords(String s)
   {
      return getSpaces(s) +1;
   }
   public static int averageLength(String s)
   {
      return (s.length() - getSpaces(s))/(getSpaces(s)+1);
   }
 }
 /*
   Program output:
   Edmund Lau
 Length of the sentence: 10
 Number of words: 2
 Average word length4
 
 Hello I am connie
 Length of the sentence: 17
 Number of words: 4
 Average word length3
 
 


 */