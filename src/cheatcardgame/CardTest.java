package cheatcardgame;

import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author 6277497
 */
public class CardTest {
    public static void main(String[] args) {
        System.out.println("CARD CLASS - TESTING");
        System.out.println("--------------------");
        System.out.println("twoOfHearts, threeOfHearts and fiveOfHearts created");
        Card twoOfHearts = new Card(Card.Rank.TWO, Card.Suit.HEARTS);
        Card threeOfHearts = new Card(Card.Rank.THREE, Card.Suit.HEARTS);
        Card queenOfHearts = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);
        System.out.print("\nPrinting twoOfHearts: ");
        System.out.println(twoOfHearts);
        System.out.print("twoOfHearts.getRank().getNext(): ");
        System.out.println(twoOfHearts.getRank().getNext());
        System.out.print("\ntwoOfHearts.compareTo(threeOfHearts): ");
        System.out.println(twoOfHearts.compareTo(threeOfHearts));
        System.out.print("\nCard.difference(twoOfHearts, threeOfHearts): ");
        System.out.println(Card.difference(twoOfHearts, threeOfHearts));
        System.out.print("\ntwoOfHearts.getSuit(): ");
        System.out.println(twoOfHearts.getSuit());
        System.out.print("\ndifference(twoOfHearts, queenOfHearts: ");
        System.out.println(Card.difference(twoOfHearts, queenOfHearts));
        System.out.print("\ndifferenceValue(twoOfHearts, queenOfHearts): ");
        System.out.println(Card.differenceValue(twoOfHearts, queenOfHearts));
        }
}