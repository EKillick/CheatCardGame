package cheatcardgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.io.Serializable;

/**
 * A class to represent a Deck of cards
 * @author 6277497
 */
public class Deck implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 101;
    
    private final ArrayList<Card> deckOfCards;
    
    /**
     * 
     */
    public Deck(){
        deckOfCards = new ArrayList<>();
        createDeck();
    }
        
    /**
     * A method to create a Deck from an ArrayList of Cards
     */    
    public final void createDeck(){
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()){
               Card tempCard =  new Card(rank, suit);
               deckOfCards.add(tempCard);
            }
        }
    }
    
    /**
     * A method to return the size of the deck
     * @return an integer representing the size of the deck
     */
    public int size(){
        return deckOfCards.size();
    }
    
    /**
     *
     */
    public void deckShuffle(){
        for (int i = 0; i < size(); i++) {
            Random rand = new Random();
            int randNum = rand.nextInt(deckOfCards.size());
            Card tempCard = deckOfCards.get(randNum);
            deckOfCards.set(randNum, deckOfCards.get(i));
            deckOfCards.set(i, tempCard);       
            }
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Card> getDeck(){
        return this.deckOfCards;
    }
    
    /**
     * A method to remove and return a card from the top of the deck
     * @return Card removed from the deck
     */
    public Card deal(){
        Card returnCard = deckOfCards.remove(deckOfCards.size() - 1);
        return returnCard;
    }
    
    /**
     * A method to reinitialise a deck
     */
    public final void newDeck(){
        deckOfCards.clear();
        createDeck();
        
    }

    /**
     * 
     * @return 
     */
    @Override
    public Iterator<Card> iterator() {
        Iterator deckIterator = new Iterator<Card>(){

            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Card next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return deckIterator;
    }
    
    /**
     * 
     */
    public class OddEvenIterator implements Iterator<Card>{
        
        /**
         * 
         * @return 
         */
        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        /**
         * 
         * @return 
         */
        @Override
        public Card next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }    
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for (Card cardInDeck : deckOfCards) {
            returnString.append(cardInDeck);
        }
        returnString.append("Deck Size: ");
        returnString.append(size());
        return returnString.toString();
    }
}
