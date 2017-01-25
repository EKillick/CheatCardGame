# CheatCardGame
A Java implementation of the card game Cheat

<h3>Card Class:</h3>  
1. Make the class Serializable with serialisation ID 100.  <b>DONE</b>
2. Use two enum types for Rank and Suit. The Rank enum should store the
value of each card. The Rank enum should also have a method getNext,
which returns the next enum value. So, for example, if the method is called on
FOUR, FIVE should be returned. If the method is called on ACE, TWO should be
returned.  <b>DONE</b>
3. The Card class should contain two variables called rank and suit of type
Rank and Suit. It should have a single constructor with the Rank and
Suit passed as arguments.  <b>DONE</b>
4. Make this class Comparable so that compareTo can be used to sort the cards
into ascending order (*see footnote). You should make proper use of generics for
this. <b>DONE</b>
5. Implement accessor methods getRank()and getSuit() that simply return
the rank and suit.  <b>DONE</b>
6. Add a toString()method that informatively displays a card.  <b>ROOM FOR IMPROVEMENT</b>
7. Add a static method called difference that returns the difference in ranks
between two cards (so the difference between TEN and QUEEN is 2).  <b>DONE</b>
8. Add a static method called differenceValue that returns the difference in
values between two cards (so the difference between TEN and QUEEN is 0).  <b>DONE</b>
9. Add two Comparator nested classes. One, called CompareDescending,
should be used to sort the cards into descending order by rank (*see footnote), the
other, CompareSuit, should be used to sort into ascending order of suit, i.e. all
the clubs sorted by rank, then all the diamonds, then the hearts and finally the
spades.  
10. Write a main method that demonstrates your code is correct by calling all the
methods you have implemented with informative output to the console.  

*Comparing Cards:
Note that you sort first by rank, then by suit. So a List
10 Diamonds, 10 Spades, 2 Clubs, 6 Hearts
sorts to ascending order as
2 Clubs, 6 Hearts, 10 Diamonds, 10 Spades
and into descending order as
10 Diamonds, 10 Spades, 6 Hearts, 2 Clubs
i.e. for the descending sort the rank order is reversed, but the suit order is maintained.

<h3>Deck Class:</h3>  
1. Deck should contain a list of Cards.  
2. The Deck constructor should create the list and initialise all the cards in the deck.  
A Deck should start with all possible 52 cards. <b>DONE</b>
3. Write a method to shuffle the deck that randomises the cards. To gain full
marks for this section you should write your own method to shuffle rather than
use the built in Collections method.  
4. Implement a method deal that removes the top card from the deck and returns
it.  
5. Add methods size (returns number of cards remaining in the deck) and a final
method newDeck (which reinitialises the deck)  
6. Add a nested Iterator class called OddEvenIterator that traverses the
Cards by first going through all the cards in odd positions, then the ones in even
positions. So a deck 10 Diamonds, 10 Spades, 2 Clubs, 6 Hearts
would iterate in the order 10 Diamonds, 2 Clubs, 10 Spades, 6 Hearts (this part of exercise
is just to show you understand iterators, it does not require you to clone the deck).  
7. Make the class Iterable, so that by default it traverses in the order they will
be dealt.  
8. Make the class Serializable with serialisation ID 101. Make it so that the
deck is saved with the cards in OddEvenIterator order (this may seem a
strange thing to do, but it is an exercise to demonstrate you understand
Serialization).  
9. Write a main method that demonstrates your code is correct by calling all the
methods you have implemented with informative output to the console.  

<h3>Hand Class:</h3>  
1. A Hand contains a collection of Cards. The class should provide a default
constructor (creates an empty hand), a constructor that takes an array of cards and
adds them to the hand and a constructor that takes a different hand and copies all
the cards to this hand.  
2. Hand should be Serializable with serialisation ID 102.  
3. A Hand should store a count of the number of each rank and suit that is currently
in the hand. These counts should be stored in an array (representing a histogram)
and modified when cards are added or removed from the hand.  
4. A Hand should store the total value(s) of the cards in the hand, with ACES
counted high. So a Hand <10 Diamonds, 10 Spades, 2 Clubs> has total value
22, a Hand <10 Diamonds, 10 Spades, Ace Clubs> has total value of 31 and a
Hand <10 Diamonds, Ace Spades, Ace Clubs> has total value 32.  
5. Hand should have three add methods: add a single Card, add a Collection
typed to Card and add a Hand  
6. Hand should have three remove methods: remove a single Card (if present),
remove all cards from another hand passed as an argument (if present) and
remove a card at a specific position in the hand. The first two methods should
return a boolean (true if all cards passed were successfully removed), the last
should return the removed card.  
7. Hand should be Iterable. The Iterator should traverse the cards in order
they were added. Note this should still be possible even if the sort routines (part 8
and 9 below) have been called.  
Hand should also have the following methods  
8. sortAscending to sort a Hand into ascending (using Card compareTo),  
9. sortDescending descending order (using CompareDescending).  
10. countSuit that takes a suit as an argument and returns the number of cards of
that suit.  
11. countRank that takes a rank as an argument and returns the number of cards of
that rank  
12. handValue that returns the total rank values of the cards in the hand (Jack,
Queen and Kings count for 10, Aces count 11).  
13. toString displays the hand.  
14. isFlush that returns true if all the cards in the hand are the same suit.  
15. isStraight that returns true if all the cards are in consecutive order (with no
duplicates). Thus 10 Diamonds, 10 Spades, 8 Clubs, 9 Hearts is not a straight but 10
Spades, 8 Clubs, 9 Hearts is.  
16. Write a main method that demonstrates your code is correct by calling all the
methods you have implemented with informative output to the console.  
