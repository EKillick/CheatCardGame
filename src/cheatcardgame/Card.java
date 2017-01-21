package cheatcardgame;

import java.io.Serializable;

/**
 *
 * @author 6277497
 */
public class Card implements Serializable, Comparable {
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
        
        /*
        An array of all ranks to be used in the getNext method
        */
        private static final Rank[] rankValues = values(); 
        
        /*
        A function that returns the next enum value to the one given
        */
        public Rank getNext(){
            return rankValues[(this.ordinal()+1) % rankValues.length];
        }
    }

    /**
     * An enum representing all the suits a card can have
     */
    protected enum Suit{
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }
    
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    /*
    An accessor method to return the rank of a given card
    */
    public Rank getRank(){
        return this.rank;
    }
    
    /*
    An accessor method to return the suit of a given card
    */
    public Suit getSuit(){
        return this.suit;
    }
    
    //Prints out the value and suit of a given card
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Card Value: ");
        returnString.append(rank);
        returnString.append("\nCard Suit: ");
        returnString.append(suit);
        
        //Appends Unicode characters for each suit
        switch (this.getSuit()){
            case CLUBS:
                returnString.append(" ").append((char)'\u2663');
                break;
            case DIAMONDS:
                returnString.append(" ").append((char)'\u2666');
                break;
            case HEARTS:
                returnString.append(" ").append((char)'\u2665');
                break;
            case SPADES:
                returnString.append(" ").append((char)'\u2660');
        }
        
        return returnString.toString();
    }
    
    //To be implemented
    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
