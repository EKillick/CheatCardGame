package cheatcardgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 6277497
 */
public class Hand implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 102;
    
    private final ArrayList<Card> handOfCards;
    
    int numberOfRanks = Card.Rank.values().length;
    int[] rankCount = new int[numberOfRanks];
    
    int numberOfSuits = Card.Suit.values().length;
    int[] suitCount = new int[numberOfSuits];
    
    /**
     * Default constructor to create a Hand object
     */
    public Hand(){
        handOfCards = new ArrayList<>();
    }
    
    /**
     * Constructor that takes an array of cards and adds them to a hand
     * @param inputList
     */
//    public Hand(ArrayList<Card> inputList){
//        
//    }
    
    /**
     * 
     * @param otherHand 
     */
//    public Hand(Hand otherHand){
//        
//    }
    
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

    @Override
    public Iterator<Card> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
