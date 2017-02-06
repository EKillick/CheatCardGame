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
            for (int i = 0; i < h.size()-1; i++){
                if (h.get(i).getRank().equals(b.getRank())){
                    h.remove(i);
                    r = b.getRank();
                }
                else{
                    r = b.getRank().getNext();
                    h.remove(i+1);
                }
            }
        }
        else{
            if (rand.nextBoolean()){
                r = b.getRank();
                h.remove(rand.nextInt(h.size()));
            }
            else{
                r = b.getRank().getNext();
                h.remove(rand.nextInt(h.size()));
            }
        }
        return new Bid(h, r);
    }

    /**
     * Decides whether or not to call cheat based on the player's hand
     * @param h - the player's hand
     * @param b - the current bid
     * @return - true if calling cheat, false otherwise
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        int suitNum = b.getHand().size();
            for (Card c : h){
                if (c.getRank() == b.getRank()){
                    suitNum++;
                }
            }
        return (suitNum > 4);
    
    }
    
}
