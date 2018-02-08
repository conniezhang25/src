import java.util.*;
public class Hand
{

    private ArrayList <Card> hand;
	
	/*Pre-condition: none
	 *Post-condition: ArrayList hand is set to null, so it is empty.
	*/
	public Hand()
	{
      hand = new ArrayList<Card>();
	}
	
	/*Pre-condition: an object of type Card is passed as a parameter to the non-default constructor
	 *Post-condition: Card is added to the ArrayList hand
	*/
	public Hand(Card c)
	{
      hand = new ArrayList<Card>();
      hand.add(c);
	}
	
	/*Pre-condition: none
	 *Post-condition: The number of cards in Hand is returned
	*/
	public int numberOfCards()
	{
     return hand.size();
	}
	
	/*Pre-condition: the index of the card you want to get is >= 0
	 *and is < hand.size()
	 *Post-condition: the card specified by the index that meets the pre-condition
	 *is returned
	*/
	public Card getCard(int c)
	{
		return hand.get(c);
	}
	
	/*Pre-condition: the index of the card you want to remove from the hand
	 *is >= 0 and is < hand.size()
	 *Post-condition: the card of the index that meets the pre-condition is
	 *removed from the hand
	*/
	public void removeCard(int c)
	{
	   hand.remove(hand.get(c));
	}
	
	/*Pre-condition: the value passed into the method is >= 0 && <= 12
	 *Post-condition: true is returned if the hand contains one or more
	 *cards of the same value
	*/
	public boolean ifSameValue(int value)
	{
      for(int i=0; i<hand.size(); i++)
      {
         if(hand.get(i).getValue()== value)
         {
            return true; 
         }
      }
      return false; 
	}	
	
	/*Pre-condition: the suit value passed into the method is >= 0 && <= 3
	 *Post-condition: true is returned if the hand contains one or more
	 *cards of the same suit
	*/
	public boolean ifSameSuit(int suit)
	{
      for(int i=0; i<hand.size(); i++)
            {
               if(hand.get(i).getSuit()==suit)
               {
                  return true; 
               }
            }
            return false;
	}
	
	/*Pre-condition: none
	 *Post-condition: prints information about the Cards in the hand
	*/
	public String toString()
	{
      String s="";
         for(int i =0; i<hand.size(); i++)
         {
            s+=hand.get(i)+ "\n";
         }
         return "\n" + numberOfCards()+
                "\n" + s;

	}
	
		/*Pre-condition: v >= 0 && v <= 12 and a >= 0 && a <= 3 
		 *Post-condition: A new card will be added to the ArrayList hand if the card is
		 *not already present in the hand, but if there is already a similar card in the
		 *hand, nothing will happen.
		*/
   public void addCard(int v, int s)
   {
      Card c = new Card(v,s);
      if(!ifSameValue(v) && !ifSameSuit(s))
      {
         hand.add(c);
      }
      
   }	

			   
} // class