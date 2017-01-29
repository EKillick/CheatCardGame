package cheatcardgame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 6277497
 */
public class Hand implements Serializable{
    static final long serialVersionUID = 102;
    
    private final ArrayList<Card> handOfCards;
    
    int numberOfRanks = Card.Rank.values().length;
    int[] rankCount = new int[numberOfRanks];
    
    int numberOfSuits = Card.Suit.values().length;
    int[] suitCount = new int[numberOfSuits];
    
    public Hand(){
        handOfCards = new ArrayList<>();
    }
    
   /**
    * A method to increment the number of each rank and suit in a hand
    * @param card 
    */
    private void incrementCounts(Card card){
        rankCount[card.getRank().ordinal()]++;
        suitCount[card.getSuit().ordinal()]++;

        
    };
    
    /**
     * A method to decrement the number of each rank and suit in a hand
     * @param card 
     */
    private void decrementCounts(Card card){
        rankCount[card.getRank().ordinal()]--;
        suitCount[card.getSuit().ordinal()]--;
    };
    
    
}
