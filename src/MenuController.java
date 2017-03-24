import java.util.Scanner;

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

	
  public static void main(String[] args)
  {
    new MenuController();
  }
  
  public MenuController(){
    Scanner input = new Scanner(System.in);
    runMenu();
  }
  
  /**
    * mainMenu() - This method displays the menu for the application,
    * reads the menu option that the user entered and returns it.
    *
    * @return     the users menu choice
    */
  private int mainMenu() {
    System.out.println("       _  .----.            //");
    System.out.println("      (_|/______|_,        (_)___ ");
    System.out.println("       'uu----uu~'          _/--_)o");
    System.out.println("          THE HARE AND TORTOISE");
 
    System.out.println("/fGame Instructions");
    System.out.println("---------");
    System.out.println(" 1) Play the Game");
    System.out.println(" 2) Show Rules");
    System.out.println(" 3) Load Game" );
    System.out.println(" 4) ");
    System.out.println("---------");
    System.out.println(" 5) View Game details");
    System.out.println(" 6) View Hare card");
    System.out.println(" 0) Exit ");
    System.out.print("==>>");
    int option = input.nextInt();
    return option;
  }

//This is the method that controls the loop
  private void runMenu(){
    int option=mainMenu();
    while(option!=0){
      switch(option){
        case 1:
          new BoardDisplay();
        break;
        case 2:    System.out.println();
          break;
        case 3:    System.out.println();
          break;
        case 4:    System.out.println();
          break;
        case 5:    System.out.println();
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
  }
