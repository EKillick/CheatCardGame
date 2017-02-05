package question2;

import java.util.Random;

/**
 *
 * @author 6277497
 */
public class BasicStrategy implements Strategy{

    /**
     * Decides whether to cheat or not
     * @param b the last bid
     * @param h the player's hand
     * @return true if the player will cheat, false otherwise
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        boolean toCheat = true;
        for (Card c : h){
            if (c.getRank().equals(b.getRank()) 
                    || c.getRank().equals(b.getRank().getNext())){
                toCheat = false;
            }
        }
       return toCheat;
    }

    /**
     * Constructs a Bid based on whether or not the player will be cheating
     * @param b - the previous Bid
     * @param h - the player's hand
     * @param cheat - whether or not the player is cheating
     * @return - the player's bid
     */
    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Random rand = new Random();
        Card.Rank r = null;
        if (!cheat){
            for (Card c : h){
                if (c.getRank().equals(b.getRank())){
                    r = b.getRank();
                }
                else{
                    r = b.getRank().getNext();
                }
            }
        }
        else{
            if (rand.nextBoolean()){
                r = b.getRank();
            }
            else{
                r = b.getRank().getNext();
            }
        }
        return new Bid(h, r);
    }

    @Override
    public boolean callCheat(Hand h, Bid b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
