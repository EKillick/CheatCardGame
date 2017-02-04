package question2;

import cheatcardgame.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * A class to represent a Hand of Cards
 * @author 6277497
 */
public class Hand implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 102;
    
    private final ArrayList<Card> handOfCards;
    private final ArrayList<Card> sortedHandOfCards;
    
    //A variable keeping track of the value of a Hand
    private static int handValue = 0;
    
    //An array to keep count of each rank in a hand
    //Size is based on the number of values in the Rank enum
    int numberOfRanks = Card.Rank.values().length;
    int[] rankCount = new int[numberOfRanks+1];
    
    //An array to keep count of each suit in a hand
    //Size is based on the number of values in the Suit enum
    int numberOfSuits = Card.Suit.values().length;
    int[] suitCount = new int[numberOfSuits];
    
    
    
    /**
     * Default constructor to create an empty Hand object
     */
    public Hand(){
        handOfCards = new ArrayList<>();
        sortedHandOfCards = new ArrayList<>();
    }
    
    /**
     * Constructor that takes an array of cards and adds them to a hand
     * @param inputList List to be copied
     */
    public Hand(ArrayList<Card> inputList){
        handOfCards = new ArrayList<>();
        sortedHandOfCards = new ArrayList<>();
        for (Card c : inputList){
            handOfCards.add(c);
            sortedHandOfCards.add(c);
            incrementCounts(c);
        }
    }
    
    /**
     * Constructor that takes another Hand object and creates a new Hand from it
     * @param otherHand Hand to be copied
     */
    public Hand(Hand otherHand){
        handOfCards = new ArrayList<>();
        sortedHandOfCards = new ArrayList<>();
        for (Card c : otherHand){
            handOfCards.add(c);
            sortedHandOfCards.add(c);
            incrementCounts(c);
        }
    }
    
    /**
     * A method to return the value of the cards in a hand
     * @return int - the total value of a hand
     */
    public int handValue(){
        return handValue;
    }
    
   /**
    * A method to increment the number of each rank and suit in a hand
    * @param card 
    */
    private void incrementCounts(Card card){
        rankCount[card.getRank().ordinal()]++;
        suitCount[card.getSuit().ordinal()]++;   
        handValue += card.getRank().value;
    };
    
    /**
     * A method to decrement the number of each rank and suit in a hand
     * @param card 
     */
    private void decrementCounts(Card card){
        rankCount[card.getRank().ordinal()]--;
        suitCount[card.getSuit().ordinal()]--;
        handValue -= card.getRank().value;
    };
    
    /**
     * A method to add a given card to a hand
     * @param card - a Card object to be added
     */
    public void add(Card card){
        handOfCards.add(card);
        sortedHandOfCards.add(card);
        incrementCounts(card);
    }
    
    /**
     * A method to add a collection to a hand
     * @param handCollection - a collection typed to hand
     */
    public void add(Collection<Card> handCollection){
        for (Card card: handCollection){
            this.add(card);
        }
    }
      
    /**
     * Adds cards from one hand to another
     * @param hand 
     */
    public void add(Hand hand){
        for (Card card: hand){
            this.add(card);
        }
    }
    
    /**
     * Remove a given card if it's in a hand
     * @param card 
     * @return true if the card was successfully removed, false otherwise
     */
    public boolean remove(Card card){
        for (Card c : handOfCards){
            if (c.compareTo(card) == 0){
                handOfCards.remove(c);
                sortedHandOfCards.remove(c);
                decrementCounts(c);
                return true;
            }
        }
        return false;
    }
       
    /**
     * Removes cards in one hand from the invoking Hand
     * @param hand - hand containing the cards to be removed
     * @return true if all cards were successfully removed, false otherwise
     */
    public boolean remove(Hand hand){
        return handOfCards.removeAll(hand.getHand());
    }
    
    /**
     * Removes a card in a given position from a Hand
     * @param i the position to be removed
     * @return the removed Card object
     */
    public Card remove(int i){
        try{
            sortedHandOfCards.remove(i);
            return handOfCards.remove(i);
        }
        catch(Exception e){
            System.err.println(e);
            return null;
        }
    
    }
    
    /**
     * A method to return the size of the deck
     * @return an integer representing the size of the deck
     */
    public int size(){
        return handOfCards.size();
    }
    
    /**
     * Returns the original hand in the form of an arrayList
     * @return 
     */
    public ArrayList<Card> getHand(){
        return this.handOfCards;
    }
    
    /**
     * Returns the sorted hand in the form of an arrayList
     * @return 
     */
    public ArrayList<Card> getSortedHandOfCards(){
        return this.sortedHandOfCards;
    }
    
    /**
     * A method to return the suitCount array
     * @return int[] suitCount array
     */
    public int[] getSuitCount(){
        return suitCount;
    }
    
    /**
     * A method to return the rankCount array
     * @return int[] rankCount array
     */
    public int[] getRankCount(){
        return rankCount;
    }
    
    /**
     * A method to sort the deck using the Card compareTo method
     */
    public void sortAscending(){
        Collections.sort(sortedHandOfCards);
    }
        
    /**
     * A method to sort the deck in descending order
     */
    public void sortDescending(){
        Collections.sort(getSortedHandOfCards(), new Card.CompareDescending());
    }
    
    /**
     * Returns the number of cards in a given suit in a hand
     * @param suit the suit to be counted
     * @return an integer count of the number of cards with that suit
     */
    public int countSuit(Card.Suit suit){
        return suitCount[suit.ordinal()];
    }
    
    /**
     * Returns the number of cards in a given rank in a hand
     * @param rank the rank to be counted
     * @return an integer count of the number of cards with that rank
     */
    public int countRank(Card.Rank rank){
        return rankCount[rank.ordinal()];
    }
    
    /**
     * Returns the default iterator
     * @return 
     */
    @Override
    public Iterator<Card> iterator() {
        return handOfCards.iterator();
    }   
    
    /**
     * Returns True is all cards are of the same suit, false otherwise
     * @param hand
     * @return True if flush, False otherwise
     */
    public boolean isFlush(Hand hand){
        Card.Suit suitComp = hand.handOfCards.get(0).getSuit();
        for (Card card : hand){
            if (card.getSuit() != suitComp)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param hand
     * @return 
     */
    public boolean isStraight(Hand hand){
        sortAscending();
        for (int i = 0; i < (hand.size() - 1); i++){
            if (Card.differenceValue(sortedHandOfCards.get(i), 
                    sortedHandOfCards.get(i+1)) != 1){
                return false;
            }
        }
        return true;
    }
    
    /**
     * A method to print a sorted Hand for testing purposes
     * @return 
     */
    public String printSorted(){
        StringBuilder returnString = new StringBuilder();
            for (Card cardInHand : sortedHandOfCards) {
            returnString.append(cardInHand);
        }
        return returnString.toString();
        }
    
    /**
     * A toString method to print out a Hand of cards
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
            for (Card cardInHand : handOfCards) {
            returnString.append(cardInHand);
        }
        returnString.append("Hand Size: ");
        returnString.append(size());
        return returnString.toString();
        }
    
    /**
     * Runs the HandTest class
     * @param args 
     */
    public static void main(String[] args) {
        HandTest.main(args);
    }
}
