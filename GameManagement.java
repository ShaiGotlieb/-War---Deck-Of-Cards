import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
* @author Shai Gotlieb
* Question 2 , Maman 11 , 29/03/2018
*/
public class GameManagement {
    //start of main
    public static void main(String[] args) {
        //creating a new game
        DeckOfCards newGame = new DeckOfCards();
        newGame.shuffle();
        //each player get his own cards created with ArrayList
        ArrayList<Card> player1 = new ArrayList();
        ArrayList<Card> player2 = new ArrayList();
        Card tempCard = new Card(null,null);
        //indicates where to look at the card inside the deck
        int index = 0;
        //indicates weather both players had the same cards
        boolean warFlag = false;
        
//split the deack of cards to 2 players
for(int i=0; i< newGame.getGameDeck().size(); i+=2)
{
    player1.add(newGame.getGameDeck().get(i));
    player2.add(newGame.getGameDeck().get(i+1));
}
//play the game while players stil have cards in their deck
while(!player1.isEmpty() && !player2.isEmpty())
{
    //if players amount of cards is bigger than current index - keep playing
    if(index < player1.size() && index < player2.size())
    {
        JOptionPane.showMessageDialog(null, "Player1 Card is: " + player1.get(index) + '\n' + "Player2 Card is: " + player2.get(index));
        //check weather player1 card value is bigger than player2 value
        if(tempCard.convertCardFaceToInt(player1.get(index)) > tempCard.convertCardFaceToInt(player2.get(index)))
        {
            
            JOptionPane.showMessageDialog(null,"Player 1 Win This Round!");
            //add the card of player2 and his own card to his deck
            player1.add(player2.get(index));
            player1.add(player1.get(index));
            //remove card from player2 and remove card from player1 (it was already added to his deck)
            player2.remove(index);
            player1.remove(index);
            //reset index (index might change if 'war' is happening)
            index = 0;
            //if they had a 'war' and still have 3 ormore cards in his deck - add in addition 2 more cards of the losing player
            if(warFlag && player2.size() >= 3)
            {
                player1.add(player2.get(index));
                player2.remove(index);
                player1.add(player2.get(index));
                player2.remove(index);
                //set flag to false so it won't repeat
                warFlag = false;
            }
        }
        else if(tempCard.convertCardFaceToInt(player1.get(index)) < tempCard.convertCardFaceToInt(player2.get(index)))
        {
            JOptionPane.showMessageDialog(null,"Player 2 Win This Round!");
            player2.add(player1.get(index));
            player2.add(player2.get(index));
            player1.remove(index);
            player2.remove(index);
            index = 0;
            if(warFlag && player1.size() >= 3)
            {
                player2.add(player1.get(index));
                player1.remove(index);
                player2.add(player1.get(index));
                player1.remove(index);
                warFlag = false;
            }
        }
        //they are equal
        else{
            int j = 0;
            warFlag = true;
            //play 'war' - deal 3 cards
            while(j<3)
            {
                //player1 loose - less than 3 cards to play
                if(player1.size() < 3)
                {
                    JOptionPane.showMessageDialog(null,"Player2, You Are The WINNER of The Game!" +'\n'+ "(player1 is out of cards)");
                    return;
                }
                //player2 loose - less than 3 cards to play
                if(player2.size() < 3)
                {
                    JOptionPane.showMessageDialog(null,"Player1, You Are The WINNER of The Game!" +'\n'+ "(player2 is out of cards)");
                    return;
                }
                //play with next card in the deck: index + j
                j++;
                JOptionPane.showMessageDialog(null,"It's Time For WAR!" +'\n'+ "Player1 Card is: " + player1.get(index+j) + '\n' + "Player2 Card is: " + player2.get(index+j));
                
            }
            //change index in order to add the last 3 cards of losing player to the other (at the begining of the loop)
            index += j;
        }
    }
    else index = 0;
    
}
//player1 loose - html code was added in order to see the message in Green
if(player1.isEmpty())
    JOptionPane.showMessageDialog(null,"<html><span style='color:green'>Player2, You Are The WINNER of The Game!</span> </html>");
// player2 loose - html code was added in order to see the message in Green
else JOptionPane.showMessageDialog(null,"<html><span style='color:green'>Player1, You Are The WINNER of The Game!</span> </html>");
    }
}//end of class GameManagement
