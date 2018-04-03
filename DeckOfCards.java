import java.security.SecureRandom;
import java.util.ArrayList;
/**
 * @author Shai Gotlieb
 */
public class DeckOfCards {
    private ArrayList<Card> myDeck; // ArrayList of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private SecureRandom randomNumbers = new SecureRandom(); // random number generator
    
    // constructor fills deck of Cards
    public DeckOfCards()
    {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        
        myDeck = new ArrayList<Card>(); // create arrayList of Card objects
        currentCard = 0; // set currentCard to 0
        //add cards to the deck - necessarily the card will be between 0-12 and every card number get exactly 4 different shapes
        for(int count = 0; count < NUMBER_OF_CARDS; count++)
        {
            myDeck.add(new Card(faces[count%13], suits[count/13]));
        }
    }
    
    // shuffle deck of Cards with one-pass algorithm
    public void shuffle()
    {
        currentCard = 0; // reinitialize currentCard
        
        // for each Card, pick another random Card and swap them
        for ( int first = 0; first < myDeck.size(); first++ )
        {
            // select a random number between 0 and 51
            int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card in ArrayList
            Card temp = myDeck.get(first);
            myDeck.set(first, myDeck.get(second));
            myDeck.set(second, temp);      
        }
    }
    
    // deal one Card
    public Card dealCard()
    {
        // determine whether Cards remain to be dealt
        if ( currentCard < myDeck.size() )
            return myDeck.get(currentCard++); // return current Card in array
        else
            return null; // return null to indicate that all Cards were dealt
    } 
    
    //return the deck of the cards in a current game
    public ArrayList<Card> getGameDeck()
    {
        return myDeck;
    }
    
}//end of ckas DeckOfCards
