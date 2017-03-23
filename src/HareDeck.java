import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class represents the deck of hare cards. It deals with a user picking up a card
 * and when the deck has to be shuffled.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.21
 */
public class HareDeck {
 
  private ArrayList<Card> deck;
  
  private Card topCard;
  private int  currentCard;
  
  /**
   * Initializes and populates the hare deck. Calls the shuffle method to
   * randomize deck order
   * TODO Populate the cards
   */
  public HareDeck()
  {
    deck = new ArrayList<>();
    
    shuffle();
  }
  
  /**
   * TODO Should we decide to go with persistence we will add a second argument accepting constructor here
   */
  
  /**
   * Deals the top card to the player and then iterates to the next card. Due to the fact that
   * each used card is not discarded and is in fact placed on the bottom of the deck, the index
   * used to retrieve each card is set to 0 when the player has reached the end of the deck.
   *
   * @return The card that the user has picked up
   */
  public Card dealCard() {
    topCard = deck.get(currentCard);
    
    currentCard++;
    if (currentCard == deck.size()) {
      currentCard = 0;
    }
    
    return topCard;
  }
  
  /**
   * Shuffles the deck and then sets the top card to the first in the arraylist
   * TODO Check with Siobhan that it is ok to use a collection shuffle
   */
  public void shuffle() {
    long seed = System.nanoTime();
    Collections.shuffle(deck, new Random(seed));
    currentCard = 0;
  }
}
