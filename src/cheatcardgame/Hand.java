package cheatcardgame;

import java.io.Serializable;

/**
 *
 * @author 6277497
 */
public class Hand implements Serializable{
    static final long serialVersionUID = 102;
    
    int numberOfRanks = Card.Rank.values().length;
    int[] rankCount = new int[numberOfRanks];
    
    int numberOfSuits = Card.Suit.values().length;
    int[] suitCount = new int[numberOfSuits];
    
   /**
    * 
    * @param card 
    */
    private void incrementCounts(Card card){
        rankCount[card.getRank().ordinal()]++;
        suitCount[card.getSuit().ordinal()]++;

        
    };
    
    /**
     * 
     * @param card 
     */
    private void decrementCounts(Card card){
        rankCount[card.getRank().ordinal()]--;
        suitCount[card.getSuit().ordinal()]--;
    };
}
