package question2;
import java.util.Random;

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
    Random rand = new Random();
    Hand discardHand = new Hand();
    

    /**
     * A method to decide when to cheat or not
     * @param b - current bid
     * @param h - player hand
     * @return - whether to cheat or not
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        boolean toCheat = false;
        //If the player can win by cheating, do so
        if (h.size() == 1){
            toCheat = true;
        }
        for (Card c : h){
            //If the player has the card, no need to cheat
            if (c.getRank().equals(b.getRank()) 
                    || c.getRank().equals(b.getRank().getNext())){
                toCheat = false;
            }
        }
       return toCheat;
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Random rand = new Random();
        Card.Rank r = b.getRank();
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
        //Keeps track of the cards the player played    
        discardHand.add(bidHand);
        }
        
        
        else{
            r = calculateWorst(b, h);
            for (Card card : h){
                if (card.getRank().equals(r)){
                    bidHand.add(card);
                }
            }
            if (rand.nextBoolean()){
                r = b.getRank();
            }
            else{
                r = b.getRank().getNext();
            }
            bidHand.remove(h);
        }   
        return new Bid(bidHand, r);
    }
    
    /**
     * Calculates the rank furthest away from the current card
     * @param bid
     * @param playerHand 
     */
    private Card.Rank calculateWorst(Bid bid, Hand playerHand){
        int maxDifference = 0;
        int temp;
        Card returnCard = null;
        for (Card card : playerHand){
            returnCard = card;
            temp = ((card.getRank().ordinal() - bid.getRank().ordinal()) + 13) % 13;
            if (temp > maxDifference){
                maxDifference = temp;
                returnCard = card;
            }  
        }
    return (returnCard.getRank());
    }

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

    @Override
    public void resetDiscardHand(){
        discardHand.clearHand();
    }
    
}
