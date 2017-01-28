package cheatcardgame;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class to represent a Deck of cards
 * @author 6277497
 */
public class Deck{

    
    private final ArrayList<Card> deckOfCards;
    
    /**
     * 
     */
    public Deck(){
        deckOfCards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()){
               Card tempCard =  new Card(rank, suit);
               deckOfCards.add(tempCard);
            }
        }
    }    
    
    /**
     * A method to return the size of the deck
     * @return an integer representing the size of the deck
     */
    public int deckSize(){
        return deckOfCards.size();
    }
    
    /**
     *
     */
    public void deckShuffle(){
        for (int i = 0; i < deckSize(); i++) {
            Random rand = new Random();
            int randNum = rand.nextInt(52);
            Card tempCard = deckOfCards.get(randNum);
            deckOfCards.set(randNum, deckOfCards.get(i));
            deckOfCards.set(i, tempCard);       
            }
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Card> getDeck(){
        return this.deckOfCards;
    }
    
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for (Card cardInDeck : deckOfCards) {
            returnString.append(cardInDeck);
        }
        returnString.append("Deck Size: ");
        returnString.append(deckSize());
        return returnString.toString();
    }
}
