package question2;

/**
 *
 * @author 6277497
 */
public class BasicStrategy implements Strategy{

    @Override
    public boolean cheat(Bid b, Hand h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean callCheat(Hand h, Bid b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
