package cheatcardgame;
/**
 *
 * @author EKillick
 */
public class HandTest {
    public static void main(String[] args) {
        System.out.println("HAND CLASS - TESTING");
        System.out.println("--------------------");
        System.out.println("twoOfHearts, threeOfHearts and fiveOfHearts created");
        Card twoOfHearts = new Card(Card.Rank.TWO, Card.Suit.HEARTS);
        Card threeOfHearts = new Card(Card.Rank.THREE, Card.Suit.HEARTS);
        Card queenOfHearts = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);
        System.out.println("\nCreating empty hand and adding cards to it");
        Hand emptyHand = new Hand();
        emptyHand.add(twoOfHearts);
        emptyHand.add(threeOfHearts);
        emptyHand.add(queenOfHearts);
        System.out.print("\nPrinting value of the hand: ");
        System.out.println(emptyHand.handValue());
    //    Create full Hand
//        Hand testHand = new Hand(testDeck.getDeck());
//        System.out.println(testHand.handValue());

 
//
//        System.out.println(emptyHand.isFlush(emptyHand));
//        System.out.println(emptyHand.isStraight(emptyHand));
        }
}
