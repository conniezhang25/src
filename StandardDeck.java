 /*
 Name:Connie Zhang
 Date:1/30/17
 Period:2
 Lab:Card Lab
 What I learned:
 1.I learned to remove the random card first then add it to the deck, otherwise it just kept adding a random card to the deck
 2.in the default constructor of the hand class, i had to set it to an empty array otherwise there was a null pointer exception
 3.To add a card, i had to add a break statement to prevent it from adding that card multiple times 
 */
  import java.util.*;

   public class StandardDeck
   {
   
      ArrayList<Card> deck = new ArrayList<Card>(52);
   
   	/*Pre-condition: none
   	 *Post-condition: An ArrayList of objects of type Card will be created
   	*/
      public StandardDeck()
      {
         buildDeck();
      }
   
   	/*Pre-condition: none
   	 *Post-condition: A new ArrayList of cards will be created with 52 cards.  
   	 *There will be 4 suits with 13 cards each.
   	*/
      public void buildDeck()
      {
         for(int i=0; i<=12; i++)
         {
            for(int k=0; k<= 3; k++)
            {
               Card c = new Card(i,k);
               deck.add(c);
            }
         }
         
         
      }
   	
   	/*Pre-condition: none
   	 *Post-condition: The first card in the ArrayList of cards will be removed and
   	 *it will also actually be returned
   	*/
      public Card removeFirstCard()
      {
         deck.remove(deck.get(0));
         return deck.get(0);
      }
   	
   	
   	/*Pre-condition: None.
   	 *Post-condition: The ArrayList of cards will be randomly shuffled.
   	*/ 
      public void shuffleDeck()
      {
          //get random number from deck
         for(int i=0; i<deck.size(); i++)
         {
            int random = (int)(Math.random()*52);
            Card r = deck.get(random);
            deck.remove(r);
            deck.add(0, r);// sets random card to first card
            
         }
        
      }
   
   	/*Pre-condition: none
   	 *Post-condition: The number of cards in the ArrayList deck will be returned.
   	*/
      public int numberOfCards()
      {
         return deck.size();
      }
   
   	/*Pre-condition: v >= 0 && v <= 12 AND s >= 0 && s<=3
   	 *Post-condition: A new card will be added to the ArrayList deck if the card is
   	 *not already present in the deck, but if there is already a similar card in the
   	 *deck, nothing will happen.
   	*/
      public void addCard(int v, int s)
      {
         boolean present = false;
         Card u = new Card(v, s);
         for(int i=0; i<deck.size(); i++)
         { 
            if(v == deck.get(i).getValue() && s == deck.get(i).getSuit())
            {
               present = true;
            }
            else
            {
               present = false;
            }
         
         if(present == false)
         {  
            
            deck.add(u);
            break;
         } 
        }        
      }	
   
   	/*Pre-condition: none
   	 *Post-condition: The number of cards will be printed on the screen, as well as
   	 *the details of each card(including its value and suit).
   	*/
      public String toString()
      {
         String s="";
         for(int i =0; i<deck.size(); i++)
         {
            s+=deck.get(i)+ "\n";
         }
         return "\n" + numberOfCards()+
                "\n" + s; 
                         
      }
   
   	/*Pre-condition: none
   	 *Post-condition: The ArrayList of cards will be reset so that there is one card of each
   	 *suit and value. This new ArrayList will also be shuffled.
   	*/
      public void reset()
      {
         for(int i =deck.size()-1; i>=0; i--)
         {
            deck.remove(i);
         }
          for(int i=0; i<=12; i++)
         {
            for(int k=0; k<= 3; k++)
            {
               Card c = new Card(i,k);
               deck.add(c);
            }
         }
         

         
      }
   	
   	
      public static void main(String [] args)
      {
      
         StandardDeck s = new StandardDeck();
         
      
         System.out.println ("Num of cards: " + s.numberOfCards());
      
         System.out.println("******** First card is: " + s.removeFirstCard()); 
         
      	
         System.out.println ("After removing the first card. Num of cards: " + s.numberOfCards());
         s.addCard(0, 0); 
         System.out.println ("After adding new Card (0,0). Size of deck: " + s.numberOfCards());
         
       
		 System.out.println ("**************************************************************");
        s.shuffleDeck(); 
         System.out.println("After shuffling.  Num of cards: " +  s.numberOfCards()); 
		 System.out.println("The shuffled deck:  =======================>");
		  System.out.println(s); 
      	
         s.reset(); 
	     System.out.println("The reset deck:  =======================>");
         System.out.println(s); 
         System.out.println("Number of cards AFTER reset: " + s.numberOfCards()); 	
      	
         Card c = new Card(12, 0);
         Hand h =new Hand();  
         Hand h2 = new Hand(c); 
         h.addCard(12, 3); // adding a card to h
         System.out.println(h.numberOfCards()); // should return 1
         System.out.println(h.getCard(0) + "\n" + h2.getCard(0)); // should return Ace of Spades and Ace of Clubs
         System.out.println(h.ifSameValue(12) + "\n" + h.ifSameSuit(3)); // true true
         System.out.println(h2.ifSameValue(3) + "\n" + h2.ifSameSuit(3)); // false false
         h.removeCard(0); // removes card
         System.out.println(h2); // tests toString method
         

      
      } // end of main
   	
   } // class
   /*
         Program output:
          Num of cards: 52
 ******** First card is: 2 of Diamonds
 After removing the first card. Num of cards: 51
 After adding new Card (0,0). Size of deck: 52
 **************************************************************
 After shuffling.  Num of cards: 52
 The shuffled deck:  =======================>
 
 52
 Queen of Spades
 3 of Clubs
 Queen of Diamonds
 2 of Diamonds
 7 of Hearts
 Ace of Clubs
 10 of Diamonds
 King of Hearts
 9 of Hearts
 7 of Clubs
 2 of Hearts
 2 of Clubs
 Ace of Spades
 Jack of Hearts
 Ace of Diamonds
 King of Diamonds
 10 of Clubs
 10 of Hearts
 Ace of Hearts
 5 of Clubs
 9 of Diamonds
 3 of Diamonds
 6 of Hearts
 6 of Diamonds
 8 of Clubs
 10 of Spades
 8 of Hearts
 3 of Spades
 6 of Spades
 2 of Spades
 3 of Hearts
 4 of Clubs
 4 of Diamonds
 4 of Hearts
 4 of Spades
 5 of Diamonds
 5 of Hearts
 5 of Spades
 6 of Clubs
 7 of Diamonds
 7 of Spades
 8 of Diamonds
 8 of Spades
 9 of Clubs
 9 of Spades
 Jack of Clubs
 Jack of Diamonds
 Jack of Spades
 Queen of Clubs
 Queen of Hearts
 King of Clubs
 King of Spades
 
 The reset deck:  =======================>
 
 52
 2 of Clubs
 2 of Diamonds
 2 of Hearts
 2 of Spades
 3 of Clubs
 3 of Diamonds
 3 of Hearts
 3 of Spades
 4 of Clubs
 4 of Diamonds
 4 of Hearts
 4 of Spades
 5 of Clubs
 5 of Diamonds
 5 of Hearts
 5 of Spades
 6 of Clubs
 6 of Diamonds
 6 of Hearts
 6 of Spades
 7 of Clubs
 7 of Diamonds
 7 of Hearts
 7 of Spades
 8 of Clubs
 8 of Diamonds
 8 of Hearts
 8 of Spades
 9 of Clubs
 9 of Diamonds
 9 of Hearts
 9 of Spades
 10 of Clubs
 10 of Diamonds
 10 of Hearts
 10 of Spades
 Jack of Clubs
 Jack of Diamonds
 Jack of Hearts
 Jack of Spades
 Queen of Clubs
 Queen of Diamonds
 Queen of Hearts
 Queen of Spades
 King of Clubs
 King of Diamonds
 King of Hearts
 King of Spades
 Ace of Clubs
 Ace of Diamonds
 Ace of Hearts
 Ace of Spades
 
 Number of cards AFTER reset: 52
 1
 Ace of Spades
 Ace of Clubs
 true
 true
 false
 false
 
 1
 Ace of Clubs

   */
   