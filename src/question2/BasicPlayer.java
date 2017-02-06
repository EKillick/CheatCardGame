package question2;

/**
 * A BasicPlayer class that implements the Player interface
 * @author 6277497
 */
public class BasicPlayer implements Player{

    Strategy strategy;
    CardGame cardGame;
    Hand playerHand;
    
    /**
     * Constructor to create a BasicPlayer object
     * @param strategy - Strategy to be used
     * @param cheat - CardGame to be played
     */
    public BasicPlayer(Strategy strategy, CardGame cardGame){
        this.strategy = strategy;
        this.cardGame = cardGame;
        playerHand = new Hand();
    }
    
    /**
     * Adds a card to the player's hand
     * @param c - Card to be added
     */
    @Override
    public void addCard(Card c) {
        playerHand.add(c);
    }

    /**
     * Adds all the cards in h to the player's hand
     * @param h - Hand to be added
     */
    @Override
    public void addHand(Hand h) {
        playerHand.add(h);
    }

    /**
     * Number of cards left in the player's hand
     * @return int - cards in the player's hand
     */
    @Override
    public int cardsLeft() {
        return playerHand.size();
    }

    /**
     * A method to set the cardGame
     * @param g - CardGame to be set
     */
    @Override
    public void setGame(CardGame g) {
        cardGame = g;
    }

    /**
     * A method to set the strategy
     * @param s - Strategy to be set
     */
    @Override
    public void setStrategy(Strategy s) {
        strategy = s;
    }

    /**
     * Constructs a new Bid
     * @param b - The last accepted bid
     * @return - the player's bid
     */
    @Override
    public Bid playHand(Bid b) {
        return strategy.chooseBid(b, playerHand, strategy.cheat(b, playerHand));
    }

    
    /**
     * Returns true if calling the last player a cheat
     * @param b - The last accepted bid
     * @return - true if calling the last player a cheat
     */
    @Override
    public boolean callCheat(Bid b) {
        return strategy.callCheat(playerHand, b);
    }
    
}
