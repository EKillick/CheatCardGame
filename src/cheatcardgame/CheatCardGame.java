package cheatcardgame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author 6277497
 */
public class CheatCardGame {

    public static void main(String[] args) {
    Card twoOfHearts = new Card(Card.Rank.TWO, Card.Suit.HEARTS);
    Card otherCard = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);
//    System.out.println(twoOfHearts.toString());
//    System.out.println(twoOfHearts.compareTo(otherCard));
//    System.out.println(Card.difference(twoOfHearts, otherCard));
//    System.out.println(Card.differenceValue(twoOfHearts, otherCard));
    Deck testDeck = new Deck();
    System.out.println(testDeck + "\n\n");
//    testDeck.deckShuffle();
//    System.out.println(testDeck + "\n\n");
//    Collections.sort(testDeck.getDeck(), new Card.CompareDescending());
//    System.out.println(testDeck + "\n\n");
//    testDeck.deal();
//    System.out.println(testDeck + "\n\n");
    
    Iterator<Card> deckItr = testDeck.getOddEvenIterator();
    while(deckItr.hasNext()){
        System.out.print(deckItr.next());
    }
    
//    System.out.println(testDeck);
    
    //SERIALIZABLE TEST
//    testDeck.saveDeck();
//    try{
//        testDeck.readObject();
//    }
//    catch(Exception e){
//        e.printStackTrace();
//    }
//    System.out.println(testDeck);
    
    Hand testHand = new Hand(testDeck.getDeck());
    System.out.println(testHand.handValue());
   
    
    }
}
