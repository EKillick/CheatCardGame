package cheatcardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a Deck of cards
 * @author 6277497
 */
public class Deck extends ArrayList{

    
    private static final ArrayList<Card> deckOfCards = new ArrayList<>();
    
    /**
     * 
     */
    public Deck(){
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
    public static int deckSize(){
        return deckOfCards.size();
    }
    
    
    public static ArrayList deckShuffle(){
      List<Card> leftDeck = deckOfCards.subList(0, deckOfCards.size() / 2);
      List<Card> rightDeck = deckOfCards.subList(26, deckOfCards.size());
      ArrayList tempDeck = deckOfCards;
      tempDeck.clear();
      
      for (int i = 0; i < 10; i++){
          if (Math.random() < 0.5){
              System.out.println("1");
          }
          else{
              System.out.println("0");
          }
      }
      
//      for (int i = 0; i < 10; i++){
//        if (Math.random() < 0.5){
//            System.out.println(leftDeck.get(0));
////            tempDeck.add(leftDeck.remove(0));
////            leftDeck.remove(0);
//        }
//        else{
////            System.out.println(rightDeck.get(0));
////            tempDeck.add(rightDeck.remove(0));
////            rightDeck.remove(0);
//        }
//      }
//      System.out.println(tempDeck);
////        System.out.println(leftDeck);
////        System.out.println(rightDeck);
        return tempDeck;
    }
    
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for (Card cardInDeck : deckOfCards) {
            returnString.append(cardInDeck);
        }
        returnString.append("Deck Size: ");
        returnString.append(deckSize());
        return returnString.toString();
    }
}
