package cheatcardgame;

import java.io.Serializable;
import java.util.Comparator;

/**
 * TO DO:
 * Correct JavaDocs - including returns
 * Enhance toString method
 */

/**
 *
 * @author 6277497
 */
public class Card implements Serializable, Comparable<Card> {
    static final long serialVersionUID = 100;
    
    /**
     * An enum representing all the values a card can have
     */
    protected enum Rank{
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
        final int value;
        Rank(int x){
            value = x;
        }
        
        /**
         * An array of all ranks to be used in the getNext method
         */
        private static final Rank[] rankValues = values(); 
        
        /**
         * A function that returns the next enum value to the one given
         * @return Rank - the next ranked card
         */
        public Rank getNext(){
            //Wraps around the list using the modulus operator
            return rankValues[(this.ordinal()+1) % rankValues.length];
        }
    }

    /**
     * An enum representing all the suits a card can have
     */
    protected enum Suit{
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }
    
    private final Rank rank;
    private final Suit suit;
    
    /**
     * A constructor to create a card object - take two parameters
     * @param rank the rank of the card (eg: TWO or QUEEN)
     * @param suit the suit of the card (eg: SPADES or HEARTS)
     */
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * An accessor method to return the rank of a given card
     * @return Rank - the rank of the invoking card object
     */
    public Rank getRank(){
        return this.rank;
    }
    
    /**
     * An accessor method to return the suit of a given card
     * @return Suit - the suit of the invoking card object
     */
    public Suit getSuit(){
        return this.suit;
    }
    
    //Prints out the value and suit of a given card
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append(rank);
        returnString.append(" of ");
        returnString.append(suit);
        returnString.append("\n");
        
//        //Appends Unicode characters for each suit
//        switch (this.getSuit()){
//            case CLUBS:
//                returnString.append(" ").append((char)'\u2663');
//                break;
//            case DIAMONDS:
//                returnString.append(" ").append((char)'\u2666');
//                break;
//            case HEARTS:
//                returnString.append(" ").append((char)'\u2665');
//                break;
//            case SPADES:
//                returnString.append(" ").append((char)'\u2660');
//        }
//        
        return returnString.toString();
    }
    
    /**
     * A method to return the difference in ranks between two cards
     * Eg. the difference between TEN and QUEEN is 2
     * @param a
     * @param b
     * @return 
     */
    public static int difference(Card a, Card b){
        return Math.abs(a.rank.ordinal() - b.rank.ordinal());
    }
    
    /**
     * A method to return the difference in values between two cards
     * Eg. the difference between TEN and QUEEN is 0
     * @param a Card to be compared
     * @param b Card to be compared
     * @return difference in value between the two cards
     */
    public static int differenceValue(Card a, Card b){
        return Math.abs(a.rank.value - b.rank.value);
    }
    
    /**
     * 
     */
    public static class CompareDescending implements Comparator<Card>{
        public CompareDescending(){};
        @Override
        public int compare(Card t, Card t1) {
            int result = t1.getRank().compareTo(t.getRank());
            if (result == 0){      
                result = t.getSuit().compareTo(t1.getSuit());
            }
            return result;
        }    
}
 
    /**
     * 
     */
    public static class CompareSuit implements Comparator<Card>{
        public CompareSuit(){};
        @Override
        public int compare(Card t, Card t1) {
            int result = t.getSuit().compareTo(t1.getSuit());
            if (result == 0){      
                result = t.getRank().compareTo(t1.getRank());
            }
            return result;
        }        
    }
    
    /**
     * An implementation of the compareTo method
     * @param other card to be compared to the invoking card
     * @return the difference in rank between the two cards
     */
    @Override
    public int compareTo(Card other) {
        int result = this.getRank().compareTo(other.getRank());
        if (result == 0){      
            result = this.getSuit().compareTo(other.getSuit());
        }
        return result;
    }

}
