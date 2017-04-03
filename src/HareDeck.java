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
   * TODO Populate the cards correctly only testing them at this stage
   */
  public HareDeck()
  {
    deck = new ArrayList<>();
    deck.add(new Card("LOSE HALF YOUR CARROTS!", "If an odd number, keep the odd one."));
    deck.add(new Card("LOSE HALF YOUR CARROTS!", "If an odd number, keep the odd one."));
    deck.add(new Card("GIVE 10 CARROTS TO EACH PLAYER LYING BEHIND YOU IN THE RACE (IF ANY).", "If you haven't enough carrots give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'."));
    deck.add(new Card("GIVE 10 CARROTS TO EACH PLAYER LYING BEHIND YOU IN THE RACE (IF ANY).", "If you haven't enough carrots give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'."));
    deck.add(new Card("SHOW US YOUR CARROTS!", "Count your carrot cards face up to the table so that everyone will know how many you have left."));
    deck.add(new Card("SHOW US YOUR CARROTS!", "Count your carrot cards face up to the table so that everyone will know how many you have left."));
    deck.add(new Card("DRAW 10 CARROTS FOR EACH LETTUCE YOU STILL HOLD.", "If you have none left, miss a turn."));
    deck.add(new Card("DRAW 10 CARROTS FOR EACH LETTUCE YOU STILL HOLD.", "If you have none left, miss a turn."));
    deck.add(new Card("FREE RIDE!", "Your last turn costs nothing; retrieve the carrots you paid to reach this square."));
    deck.add(new Card("FREE RIDE!", "Your last turn costs nothing; retrieve the carrots you paid to reach this square."));
    deck.add(new Card("RESTORE YOUR CARROT HOLDING TO EXACTLY 65.", "If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch."));
    deck.add(new Card("RESTORE YOUR CARROT HOLDING TO EXACTLY 65.", "If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch."));
    deck.add(new Card("IF THERE ARE MORE PLAYERS BEHIND YOU THAN IN FRONT OF YOU, MISS A TURN. IF NOT, PLAY AGAIN.", "If equal, of course play again."));
    deck.add(new Card("IF THERE ARE MORE PLAYERS BEHIND YOU THAN IN FRONT OF YOU, MISS A TURN. IF NOT, PLAY AGAIN.", "If equal, of course play again."));
    deck.add(new Card("SHUFFLE THE HARE CARDS AND RECEIVE FROM EACH PLAYER 1 CARROT FOR DOING SO.", "Do not replace this card at the bottom of the pack but include it in the shuffle."));
    
    shuffle();
  }
  
  /**
   * TODO For testing purposes, remove when tested
   */
  public void printDeck() {
    for (int i = 0; i < deck.size(); i++) {
      System.out.println(deck.get(i).getTitle());
    }
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
   */
  public void shuffle() {
    Collections.shuffle(deck, new Random());
    currentCard = 0;
  }
}