/**
 * This class models a card from the Hare deck.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.21
 *
 * TODO deal with how a card applies its rules
 */
public class Card {
  
  public String title;
  public String instruction;
  
  public Card(String title, String instruction) {
    this.title = title;
    this.instruction = instruction;
  }
  
  public String getTitle() {
    return title;
  }
}
