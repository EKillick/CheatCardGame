package question2;

/**
 *
 * @author EKillick
 */
public class HandTest {
    public static void main(String[] args) {
        System.out.println("HAND CLASS - TESTING");
        System.out.println("--------------------");
        System.out.println("twoOfHearts, threeOfHearts and queenOfHearts created");
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
        System.out.print("\nCounting the number of Hearts: ");
        System.out.println(emptyHand.countSuit(Card.Suit.HEARTS));
        System.out.print("\nCounting the number of Queens: ");
        System.out.println(emptyHand.countRank(Card.Rank.QUEEN));
        System.out.print("\nRunning isFlush on the Hand (should be true): ");
        System.out.println(emptyHand.isFlush(emptyHand));
        System.out.print("\nRunning isStraight on the Hand (should be false): ");
        System.out.println(emptyHand.isStraight(emptyHand));
        System.out.println("\nRunning sortAscending on the deck: ");
        emptyHand.sortAscending();
        System.out.println(emptyHand.printSorted());
        System.out.println("Running sortDescending on the deck: ");
        emptyHand.sortDescending();
        System.out.println(emptyHand.printSorted());
        System.out.print("Removing twoOfHearts and getting new deck value: ");
        emptyHand.remove(twoOfHearts);
        System.out.println(emptyHand.handValue()); 
        
//        System.out.println("...........");
//        Hand dupeHand = new Hand(emptyHand);
//        Hand dupeHand = new Hand();
//        Card kingOfClubs = new Card(Card.Rank.KING, Card.Suit.CLUBS);
//        Card threeOfSpades = new Card(Card.Rank.THREE, Card.Suit.SPADES);
//        dupeHand.add(kingOfClubs);
//        dupeHand.add(threeOfSpades);
//        dupeHand.add(twoOfHearts);
//        System.out.println("\nEMPTY: \n" + emptyHand);
//        System.out.println("\nDUPE: \n" + dupeHand);
//        System.out.println(emptyHand.remove(dupeHand));
//        emptyHand.remove(dupeHand);
//        System.out.println("\nDUPE: \n" + dupeHand);
//        System.out.println(emptyHand);
        
        }
}
