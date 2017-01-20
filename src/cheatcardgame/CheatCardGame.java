package cheatcardgame;
/**
 *
 * @author 6277497
 */
public class CheatCardGame {

    public static void main(String[] args) {
    Card twoOfHearts = new Card(Card.Rank.TWO, Card.Suit.CLUB);
    System.out.println(twoOfHearts.toString());
    System.out.println(Card.Rank.ACE.getNext());
    }
    
}
