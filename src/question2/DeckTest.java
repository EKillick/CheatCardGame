
package question2;

import cheatcardgame.*;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author EKillick
 */
public class DeckTest {
    public static void main(String[] args) {
        System.out.println("\n\nDECK CLASS - TESTING ");
        System.out.println("--------------------");
        System.out.println("New deck (testDeck) created");
        Deck testDeck = new Deck();
        System.out.println("\nTesting the oddEvenIterator writing to object: ");
        Iterator<Card> deckItr = testDeck.getOddEvenIterator();
        //Iterator Test
        while(deckItr.hasNext()){
            System.out.print(deckItr.next());
        }  
        //Serialization test
        testDeck.saveDeck();
        
        System.out.println("\nShuffling the deck: ");
        testDeck.shuffle();
        System.out.println(testDeck);
        System.out.println("\nDealing a card and sorting the deck: ");
        testDeck.deal();
        Collections.sort(testDeck.getDeck(), new Card.CompareDescending());
        System.out.println(testDeck);
        System.out.println("\nRefreshing the deck: ");
        testDeck.newDeck();
        System.out.println(testDeck);
        System.out.println("\nReloading oddEvenDeck: ");
        try{
            testDeck.readObject();
            System.out.println(testDeck);
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
}
