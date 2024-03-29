package question2;

import java.util.Random;

/**
 * A strategy that never cheats unless it has to
 * It always plays the lowest rank possible
 * It only calls cheat when it's certain a player is cheating
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
        Hand bidHand = new Hand();
        if (!cheat){
            for (int i = 0; i < h.size(); i++){
                if (h.get(i).getRank().equals(b.getRank())){
                    r = b.getRank();
                    bidHand.add(h.remove(i));
                }
            }
            if (bidHand.size() == 0){
                for (int j = 0; j < h.size(); j++){
                    if (h.get(j).getRank().equals(b.getRank().getNext())){
                        r = b.getRank().getNext();
                        bidHand.add(h.remove(j));
                    }
                }
            }        
        }
        else{
            if (rand.nextBoolean()){
                r = b.getRank();
                bidHand.add(h.remove(rand.nextInt(h.size())));
            }
            else{
                r = b.getRank().getNext();
                bidHand.add(h.remove(rand.nextInt(h.size())));
            }
        }
        System.out.println("Bid Hand " + bidHand);
        return new Bid(bidHand, r);
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

    /**
     * Resets the player's discard hand
     */
    @Override
    public void resetDiscardHand(){}
    
}
