package question2;

/**
 * MyStrategy should play the game tactically, including when to call cheat
 * and when to cheat
 * The earlier in the game, the less punishing an incorrect cheat call is
 * If a decision to cheat is made, a card furthest from the bid should be played
 * When deciding whether to call cheat, the player should consider which cards 
 * have already been played
 * If the player can win by cheating, it will try to do so
 * Should call cheat on the card that would win another player the game
 * @author 6277497
 */
public class MyStrategy implements Strategy{

    @Override
    public boolean cheat(Bid b, Hand h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean callCheat(Hand h, Bid b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetDiscardHand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
