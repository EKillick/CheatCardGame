package cheatcardgame;

import java.io.Serializable;

/**
 *
 * @author 6277497
 */
public class Card implements Serializable {
    static final long serialVersionUID = 100;
    
    private enum Rank{
        TWO (2),THREE (3), FOUR (4), FIVE (5), SIX (6), SEVEN (7), EIGHT (8),
        NINE (9), TEN (10), JACK (10), QUEEN (10), KING (10), ACE (11)
//        private static Rank[] valArray = values();
//        public Rank getNext()
//        {
//            return valArray[(this.ordinal()+1) % valArray.length];
//        }
    }
    private enum Suit{
        CLUB, DIAMONDS, HEARTS, SPADES
    }
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
}
