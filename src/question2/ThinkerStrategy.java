package question2;
import java.util.Random;
/**
 * A Strategy that makes informed decisions on which cards to play and when
 * to cheat. Adds a level of unpredictability to the player
 * @author 6277497
 */
public class ThinkerStrategy implements Strategy{
    Random rand = new Random();
    Hand discardHand = new Hand();
    private static final double CHEAT_CONFIDENCE = 10;

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
            //If the player has the card, no need to cheat
            if (c.getRank().equals(b.getRank()) 
                    || c.getRank().equals(b.getRank().getNext())){
                toCheat = false;
            }
        }
        //Will cheat if a dice roll rolls a 6
        if (rand.nextInt(6)+1 == 6){
            toCheat = true;
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
        Card.Rank r = null;
        Hand bidHand = new Hand();
        if (!cheat){
            for (int i = 0; i < h.size(); i++){
                if (h.get(i).getRank().equals(b.getRank())){
                    r = b.getRank();
                    if (rand.nextInt(6)+1 != 1 || bidHand.size() == 0){
                            //1 in 6 chance of not playing a card
                            //Always plays a card if the hand is empty
                            bidHand.add(h.remove(i));
                        }              
                }
            }
            if (bidHand.size() == 0){
                for (int j = 0; j < h.size(); j++){
                    if (h.get(j).getRank().equals(b.getRank().getNext())){
                        r = b.getRank().getNext();
                        if (rand.nextInt(6)+1 != 1 || bidHand.size() == 0){
                            //1 in 6 chance of not playing a card
                            //Always plays a card if the hand is empty
                            bidHand.add(h.remove(j));
                        }
                    }
                }
            } 
        //Keeps track of the cards the player played    
        discardHand.add(bidHand);
        }
        else{
            //25% chance to play lower card
            if (rand.nextInt(4)+1 == 1){
                r = b.getRank();
                bidHand.add(h.remove(rand.nextInt(h.size())));
            }
            else{
                r = b.getRank().getNext();
                bidHand.add(h.remove(rand.nextInt(h.size())));
            }
        }
//        System.out.println("Bid Hand " + bidHand);
        return new Bid(bidHand, r);
    }

    /**
     * Decides whether or not to call cheat based on the player's hand
     * Calculates the probability that the player is cheating and uses this to
     * decide whether of not to call cheat
     * @param h - the player's hand
     * @param b - the current bid
     * @return - true if calling cheat, false otherwise
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        int suitNum = b.getHand().size();
        int randomInt = rand.nextInt(100)+1;
//        System.out.println("Init " + suitNum);
            for (Card c : h){
                if (c.getRank().equals(b.getRank())){
                    suitNum++;
                }
            }
//            System.out.println("Added " + discardHand.countRank(b.getRank()));
            suitNum += discardHand.countRank(b.getRank());  
//            System.out.println("Suit Num " + suitNum);
//            System.out.println("CONFIDENCE: " + CHEAT_CONFIDENCE * suitNum);
//            System.out.println("RAND: " + randomInt);
            //Calls cheat if certain
            if (suitNum > 4){
                return true;
            }
        return (CHEAT_CONFIDENCE * suitNum > randomInt);
    
    }
    
    /**
     * A method to clear the discard hand when cheat is called
     */
    @Override
    public void resetDiscardHand(){
        discardHand.clearHand();
    }
    
}   