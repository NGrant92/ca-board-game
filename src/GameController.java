import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class c
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.28
 */
public class GameController {
    Scanner input;
    ArrayList<Player> players;
    
    public GameController(){
        players = new ArrayList<>();
        input = new Scanner(System.in);
        new BoardDisplay();
        startGame();
        runMenu();
    }
    
    public void addPlayer (String name) {
        players.add(new Player(name));
    }
    
    public void startGame () {
        System.out.println("Welcome to The Hare and Tortoise");
        System.out.println("Enter the number of players you want to play:");
        int j = input.nextInt();
        input.next();
        for (int i = 0; i < j; i++) {
            System.out.println("Enter player " + (i + 1) + " name");
            String str = input.next();
            addPlayer(str);
        }
        runMenu();
    }
    
    public void listPlayers () {
        for (int i = 0 ; i < players.size() ; i++) {
            System.out.println(players.get(i).toString());
        }
    }
    
    private void runMenu(){
        System.out.println("Enter the number of players you want to play");
        int j = input.nextInt();
        input.next();
        for (int i = 0; i < j; i++) {
            System.out.println("Enter player " + (i + 1) + " name");
            String str = input.next();
            addPlayer(str);
        }
        listPlayers();
        for (int i = 0 ; i < 3 ; i++) {
            for (int k = 0 ; k < players.size() ; k++) {
                System.out.println("Enter the number of tiles you wish to move " + players.get(k).getPlayerName());
                movePlayer(players.get(k), input.nextInt());
            }
            listPlayers();
        }
        input.next();
    }
    
    public void movePlayer (Player player, int moves) {
        player.setPosition(player.getPosition() + moves);
        player.removeCarrots(carrotsRequired(moves));
    }
    
    /*
	 * Calculates the carrots required to move a distance
	 *
	 * The number of carrots required is calculated using a triangular number sequence
	 * formula. The alternative was to use a for loop to add every number
	 * up to the distance required. This has been commented out.
	 *
	 * @param distance The distance that the user wishes to move
	 * @return The number of carrots required to move the inputted distance
	 */
    public int carrotsRequired(int distance) {
		/* int carrots = 0;
		*  for (int index = 1; index <= distance; index++)
		*  {
		*   	carrots = carrots + index;
		*  }
		*  return carrots;
		*/
        return distance*(distance + 1)/2;
    }
    
    /**
     * Calculates what would be the input to the triangular number sequence
     * equation from the number of carrots available. The method then rounds
     * down to find the maximum number of moves.
     *
     * @param carrots The players balance of carrots
     * @return the maximum number of moves a player can make
     */
    public double calculateMaxMoves(int carrots) {
        //Find the natural number (input)
        double test = (Math.sqrt((8 * carrots) + 1) - 1)/2;
        //Round down to the whole number
        int i = (int) Math.floor(test);
        return i;
    }
}
