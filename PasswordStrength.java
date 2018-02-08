/********************************************************************
Name:Connie Zhang
Period:2
Due date: 1/6/17                        Date submitted: 1/6/17
What I learned:
I learned to use a nested forloop so the compiler wouldnt go through the string trying to match up each char with the alphabet
I also learned to not include the if statement inside the for loop as it would continue to increase and always be true

How I feel about this lab:
At first I was very confused about how to check if the entire string had a number or contained all letters but then i realized you need a nested for loop
What I am wondering:
I was wondering if how different the program would be if you included capital letters
******************************************************************/

import java.util.Scanner;
public class PasswordStrength
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      System.out.print ("Do you want the program to generate a password for you or not?  \n1 for YES" +
                               "\n2 for NO\n ");
      int automode = console.nextInt();
      String password ;
              
      // start checking the password
      int  strengthValue = 0;
      while (strengthValue < 1 || strengthValue >4)
      {
         displayPasswordRule();
         password = getPassword (automode); 
         System.out.println("The password " + password);     
         strengthValue = checkStrength (password);
      } // while
      
      // inform the user if the password's strength
      displayStrength(strengthValue);
   } // main
   
   // pre:none
   // post:generate a random password length 1-10 from letters, numbers, and special chars
   public static String generateRandomPassword()
   {
      String  charList = "0123456789abcdefghijklmnopqrstuvwxyz@#$%&*?!";
      
      // size is from 1 to 10
      int randomPasswordSize = (int)(Math.random() * 10 + 1);
   
      String  password = "";
      for (int  k = 0; k < randomPasswordSize; k++)
         password +=  charList.charAt ((int)(Math.random() * charList.length()));
   
      return password;
   } // generateRandomPassword
   
   
   // pre:none
   // post:displays password rules   
   public static void displayPasswordRule()
   {
      System.out.println("1. A very weak password contains only numbers and is fewer than eight characters");
      System.out.println("2. A weak password contains only numbers and is fewer than eight characters");
      System.out.println("3. A strong password contains letters and at least one number and is at least eight characters");
      System.out.println("4. A very strong password contains letters, numbers, and special characters and is at least eight characters");

   }  // displayPasswordRule
  
   // pre:none
   // post: gets the password either from user or the random generator 
   public static String getPassword(int automode)
   {
      Scanner console = new Scanner (System.in);
      String password = "";
      if (automode == 1)
         password = generateRandomPassword();
      else
      {
         System.out.print ("Enter your password: ");
         password = console.next();
      }
      return password;
   }
   // pre:String password
   // post: checks the password length and strength and returns a number
   public static int checkStrength (String password)
   {
      int length = password.length();
      if(length<8)
      {
         if(onlyNums(password))
         {
            return 1;
         }
         else if(onlyLetters(password))
         {
            return 2;
         }
         else
         {
            return 0;
         }
         
      
      }
      if(length>=8)
      {
         if(hasLetterNumAndSpecialChar(password))
         {
            return 4;
         }
         
         else if(hasAtLeastOneNum(password))
         {
            return 3;
         }  
      
      }   
      return 0;
      
      
   } // checkStrength
   
   //Pre: none
   //Post: checks if the password only contains letters
   public static boolean onlyLetters(String password)
   { 
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      int letterCount =0;
      for(int i=0; i<password.length(); i++)
      {
         for(int j =0; j<26; j++)
         {
            if(password.substring(i,i+1).equals(alphabet.substring(j,j+1)))
            {
               letterCount++;  
            }
                       
             
         }
         if(letterCount==password.length())
          {
             return true;
          } 
                   
         
      }
           return false;
         
   }  // onlyLetters
 

   //Pre:none
   //Post:checks if password is only numbers
   public static boolean onlyNums(String password)
   {
      String numbers = "0123456789";
      int numCount =0;
      for(int i=0; i<password.length(); i++)
      {
         for(int k =0; k<10; k++)
         {
            if(password.substring(i,i+1).equals(numbers.substring(k, k+1)))
            {
              numCount++;
            }          
         
         }
         if(numCount==password.length())
             {
                return true;
             }
         
                  
      }
          
      return false;
   }  // onlyNums

   // pre:none
   // post:checks if password contains atleast one number
   public static boolean hasAtLeastOneNum(String password)
   {
      String numbers = "0123456789";
      int numCount=0;
      for(int i=0; i<=password.length()-1; i++)
      {
         for (int k = 0; k<10;k++)
         {
            if(password.substring(i,i+1).equals(numbers.substring(k,k+1)))
            {
               numCount++;
            }
         }
         if(numCount!= password.length()&&numCount>=1)
            {
               return true;
            }      
      }
      
      return false;
   }  // hasAtLeastOneNum


   // pre:none
   // post:checks if password has letter, numbers, and special characters
   public static boolean hasLetterNumAndSpecialChar(String password)
   {
      String numbers = "0123456789";
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      String special = "!@#$%^&*";
      int numCount=0;
      int letterCount=0;
      int specialCount=0;
      
        for(int i=0; i<password.length(); i++)
        {
            for(int j =0; j<26; j++)
            {
               if(password.substring(i,i+1).equals(alphabet.substring(j,j+1)))
               {
                  letterCount++;  
               }
             }
            for(int k =0; k<10; k++)
            {
               if(password.substring(i,i+1).equals(numbers.substring(k, k+1)))
               {
                 numCount++;
               }          
            
            }
            for(int k =0; k<8; k++)
            {
               if(password.substring(i,i+1).equals(special.substring(k, k+1)))
               {
                 specialCount++;
               }          
            
            }

            if(specialCount>0 && numCount>0&& letterCount>0)
            {
               return true;
            }
            
         }
   
      return false;
   }  // hasLetterNumAndSpecialChar
   //Pre:int strengthvalue
   //Post:returns if the password is very weak,weak, strong, or very strong
   public static void  displayStrength(int strengthValue)
   {
      if(strengthValue==1)
      {
         System.out.print(" is a very weak password");
      }
      else if(strengthValue==2)
      {
         System.out.print(" is a weak password");
      }
      else if(strengthValue==3)
      {
         System.out.print(" is a strong password");
      }
      else if(strengthValue==4)
      {
         System.out.print(" is a very strong password");
      }
         
   
   
   }
} // PasswordStrength
/*
Program Output:
 
The password 4567 is a very weak password
The password dach1 is a weak password
The password $#%$354657 is a strong password
The password 839hguireg is a strong password
The password @o0uh5vbz$ is a very strong password




*/