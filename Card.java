/**
 * @author Shai Gotlieb
 */
public class Card {
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   // two-argument constructor initializes card's face and suit
   public Card( String cardFace, String cardSuit )
   {
      face = cardFace; // initialize face of card
      suit = cardSuit;// initialize suit of card
   } 
//override toString
   public String toString(){
       return face + " of " + suit;
   }
   
   //convert card from his string name to integer - Deuce is smallest and Ace is biggest
   public int convertCardFaceToInt(Card c)
   {
       switch(c.face)
       {
               case "Deuce": return 2;
                   case "Three": return 3;
                       case "Four": return 4;
                           case "Five": return 5;
                               case "Six": return 6;
                                   case "Seven": return 7;
                                       case "Eight": return 8;
                                           case "Nine": return 9;
                                                case "Ten": return 10;
                                                    case "Jack": return 11;
                                                        case "Queen": return 12;
                                                            case "King": return 13;
                                                                 case "Ace": return 14;
       }
       return 0;
   }
} // end class Card
    

