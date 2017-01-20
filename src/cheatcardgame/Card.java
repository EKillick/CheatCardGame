package cheatcardgame;

import java.io.Serializable;

/**
 *
 * @author 6277497
 */
public class Card implements Serializable {
    static final long serialVersionUID = 100;
    
    private enum Rank{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, 
        QUEEN, KING, ACE
    }
    private enum Suit{
        CLUB, DIAMONDS, HEARTS, SPADES
    }
    
}
