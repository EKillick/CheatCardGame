package cheatcardgame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    
    private ArrayList<Card> deckOfCards;
    
    /**
     * A constructor to create an empty arrayList
     * Calls createDeck() to populate the list
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
     * Shuffles the deck using the Fisher-Yates algorithm
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
     * Returns the deck in the form of an ArrayList
     * @return ArrayList<Card> a deck in the form of an ArrayList of cards
     */
    public ArrayList<Card> getDeck(){
        return this.deckOfCards;
    }
    
    /**
     * A method to remove and return a card from the top of the deck
     * @return Card removed from the deck
     */
    public Card deal(){
        return deckOfCards.remove(deckOfCards.size() - 1);
    }
    
    /**
     * A method to reinitialise a deck
     */
    public final void newDeck(){
        deckOfCards.clear();
        createDeck();
        
    }

    /**
     * A writeObject method to be used when the deck is saved
     * @param out
     * @throws IOException 
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
        
        ArrayList<Card> oddEvenList = new ArrayList<>();
        Iterator<Card> deckItr = new OddEvenIterator();
        while(deckItr.hasNext()){
            oddEvenList.add(deckItr.next());
        }
        out.writeObject(oddEvenList);
    }

    /**
     * A method that calls writeObject to save the deck
     */
    public void saveDeck(){
        String filename = "oddEvenDeck.ser";
        try(FileOutputStream fos = new FileOutputStream(filename); 
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            writeObject(oos);
        }
        catch(IOException ex){
            System.err.println(ex);
        } 
    }
    
    /**
     * A method to read the serialised Deck object
     * @throws IOException 
     */
    public void readObject() throws IOException{
        String filename = "oddEvenDeck.ser";
        try{
            FileInputStream fos = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fos);
            deckOfCards = (ArrayList<Card>) ois.readObject(); 
            }
        catch(IOException | ClassNotFoundException ex){
            System.err.println(ex);
        }     
    }
    
    /**
     * Returns the custom oddEven Iterator
     * @return Iterator - oddEvenIterator
     */
    public Iterator<Card> getOddEvenIterator(){
        return new OddEvenIterator();
    }
    
    /**
     * Returns the default iterator
     * @return Iterator - default iterator
     */
    @Override
    public Iterator<Card> iterator() {
        return deckOfCards.iterator();
    }
    
    /**
     * An iterator that first goes through cards in even positions, then odd
     */
    private class OddEvenIterator implements Iterator<Card>{
        
        private int deckPos = 0; //start of even numbers
        
        /**
         * An iterator method that returns whether there's a next card
         * @return Boolean, true if there's a card, false otherwise
         */
        @Override
        public boolean hasNext() {
            if (deckPos %2 == 0){
                return true;
            }
            if (deckPos %2 != 0 && deckPos < deckOfCards.size()){
                return true;
            }
            else{
                return false;
            }
        }
        
        /**
         * An iterator method to get the next card in the deck if there is one
         * @return Card - the next card in the deck
         */
        @Override
        public Card next() {
            Card returnCard = null;
            if (deckPos < deckOfCards.size()){
                returnCard = deckOfCards.get(deckPos);
                deckPos+=2;
            }
            else if(deckPos %2 == 0 && deckPos >= deckOfCards.size()){
                deckPos = 1; // start of odd numbers
                returnCard = deckOfCards.get(deckPos);
                deckPos+=2;
            }
            return returnCard;
        }
        
    }    
    
    /**
     * A toString method to print out a deck of cards
     * @return String representation of a Deck
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
