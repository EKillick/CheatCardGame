package cheatcardgame;
/**
 *
 * @author 6277497
 */
public class CheatCardGame {

    public static void main(String[] args) {
    Card twoOfHearts = new Card(Card.Rank.TEN, Card.Suit.HEARTS);
    Card otherCard = new Card(Card.Rank.QUEEN, Card.Suit.SPADES);
    System.out.println(twoOfHearts.toString());
    System.out.println(Card.difference(twoOfHearts, otherCard));
    System.out.println(Card.differenceValue(twoOfHearts, otherCard));
    }
    
}
