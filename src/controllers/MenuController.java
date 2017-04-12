package controllers;

import java.util.Scanner;

// import com.thoughtworks.xstream.XStream;
// import com.thoughtworks.xstream.io.xml.DomDriver;
import models.HareDeck;

import static utils.ScannerInput.validNextInt;

/**
 * This class is the initial menu the user sees. The menu is displayed as below:
 *
 *        _  .----.             //
 *       (_\/______\_,        (_)___
 *        'uu----uu~'          _/--_)o
 *
 *           THE TORTOISE AND HARE
 *
 *  Select an option:
 *  1) Start Game
 *  2) View Rules
 *  3) Load Game
 *  0) Exit
 *  ==>>
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.21
 */

public class MenuController
{
  Scanner input;
  
  //TODO Remove - for testing purposes only
  HareDeck hareDeck = new HareDeck();
	
  public static void main(String[] args)
  {
    new MenuController();
  }
  
  public MenuController(){
    input = new Scanner(System.in);
    runMenu();
  }
  
  /**
    * mainMenu() - This method displays the menu for the application,
    * reads the menu option that the user entered and returns it.
    *
    * @return     the users menu choice
    */
  private int mainMenu() {
  
    System.out.println("");
    System.out.println("       _  .----.            //");
    System.out.println("      (_|/______|_,        (_)___ ");
    System.out.println("       'uu----uu~'          _/--_)o");
    System.out.println("          THE HARE AND TORTOISE");
    System.out.println("");
 
    System.out.println("Game Instructions");
    System.out.println("---------");
    System.out.println(" 1) Play the Game");
    System.out.println(" 2) Show Rules");
    System.out.println(" 3) Load Game" );
    System.out.println("---------");
    System.out.println("Testing Functions");
    System.out.println("---------");
    System.out.println(" 4) Print Deck");
    System.out.println(" 5) Shuffle Deck");
    System.out.println(" 6) Draw a single card and print");
    System.out.println(" 0) Exit ");
    int option = validNextInt("==>>");
    return option;
  }
  
//This is the method that controls the loop
  private void runMenu(){
    int option=mainMenu();
    while(option!=0){
      switch(option){
        case 1:
          new GameController();
        break;
        case 2:    System.out.println();
          break;
        case 3:    System.out.println();
          break;
          //TODO Remove cases 4 upwards, used for testing
        case 4:
          hareDeck.printDeck();
          break;
        case 5:
          hareDeck.shuffle();
          break;
        case 6:
          System.out.println(hareDeck.dealCard().getTitle());
          break;
        default:    System.out.println("Invalid option entered: " + option);
          break;
      }
      //pause the program so that the user can read what we just printed to the terminal window
      System.out.println("\nPress any key to continue...");
      input.nextLine();
      input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
      //display the main menu again
      option = mainMenu();
    }
    //the user chose option 0, so exit the program
    System.out.println("Exiting... bye");
    System.exit(0);
  }

/*  
public void save ()  throws Exception{
	  XStream xstream=new XStream(new DomDriver());
	  ObjectOutputStream out=xstream.createObjectOutputStream
			  (new FileWriter("game.xml"));
	  out.writeObject(players);
	  out.close();
}

@SuppressWarnings ("unchecked")
public void load () throws Exception{
	  XStream xstream = new XStream(new DomDriver()));
	  ObjectInputStream is = xstream.createObjectInputStream
	  (new FileReader ("game.xml"));
	  players = (ArrayList<models.Player>is.readObject();
	  is.close();
}
*/
}
		
  