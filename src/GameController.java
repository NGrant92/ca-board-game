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
    HareDeck hareDeck = new HareDeck();
    Board board = new Board();
    
    int currentTurn = 0;
    
    public GameController(){
        players = new ArrayList<>();
        input = new Scanner(System.in);
        startGame();
        System.out.print("" + board.print());
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
        for (int i = 0 ; i < players.size(); i++) {
            board.setPlayerPosition(0, players.get(i));
        }
        runMenu();
    }
    
    public void listPlayers () {
        for (int i = 0 ; i < players.size() ; i++) {
            System.out.println(players.get(i).toString());
        }
    }
    
    private void runMenu(){
        while (!isFinished()) {
            System.out.println("Enter the number of squares you wish to move " + players.get(currentTurn).getPlayerName());
            
            int distance = input.nextInt();
            int newSquareIndex = players.get(currentTurn).getPosition() + distance;
            
            while (!board.squares.get(newSquareIndex).isAvailable() || calculateMaxDistance(players.get(currentTurn).getNoOfCarrots()) < distance ) {
                System.out.println("Invalid option entered " + players.get(currentTurn).getPlayerName());
                distance = input.nextInt();
                newSquareIndex = players.get(currentTurn).getPosition() + distance;
            }
            
            movePlayer(players.get(currentTurn), newSquareIndex);
            players.get(currentTurn).removeCarrots(carrotsRequired(distance));
            
            System.out.print(board.print());
            
            listPlayers();
            nextTurn();
        }
        input.next();
    }
    
    public void movePlayer (Player player, int position) {
        board.setPlayerPosition(position, player);
    }
    
    /**
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
    private double calculateMaxDistance(int carrots) {
        //Find the natural number (input)
        double distance = (Math.sqrt((8 * carrots) + 1) - 1)/2;
        //Round down to the whole number
        int roundedDown = (int) Math.floor(distance);
        return roundedDown;
    }
    
    
    public void nextTurn() {
        currentTurn++;
        
        if(currentTurn >= players.size()){
            currentTurn = 0;
        }
        
        //Skip if players flag is set to skip turn
        if (players.get(currentTurn).getSkipTurn()) {
            players.get(currentTurn).setSkipTurn(false);
            nextTurn();
        }
    }
    
    private boolean isFinished () {
        return false;
    }
}