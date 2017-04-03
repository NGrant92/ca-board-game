import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class c
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.29
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

        // is run menu needed here, already called in startGame() method ?

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

        for (int i = 0 ; i < 3 ; i++) {
            for (int k = 0 ; k < players.size() ; k++) {
                // Print out to screen the player position in race
                System.out.println(players.get(k).getPlayerName() + " you are currently " + getPlayerPositionInRace(players.get(k)));

                System.out.println("Enter the number of tiles you wish to move " + players.get(k).getPlayerName());
                movePlayer(players.get(k), input.nextInt());
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
    private double calculateMaxDistance(int carrots) {

    public double calculateMaxMoves(int carrots){ // public int since it's returning a int ?
                //Find the natural number (input)
                double distance = (Math.sqrt((8 * carrots) + 1) - 1) / 2;
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

    //===================
    //Random Methods
    //===================

    /**
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     */
    public int getPlayerPositionInRace(Player player) {
        // local variable to store the players current position - not really need
        int currentPlayerPositionOnBoard = player.getPosition();
        // Local temporary store for playerPositionInRace
        int playerPositionInRace = 1;

        // Check each player position in players array, and increment playerPosition by 1 if the player position
        // is less than currentPlayerPositionInRace
        for (int i = 0; i < players.size(); i++) {
            if (currentPlayerPositionOnBoard < players.get(i).getPosition()) {
                playerPositionInRace++;
            }
        }
        return playerPositionInRace;
    }

    /**
     * Method to remove lettuce from player and add carrots according to player position in race
     * Checks does Player have at least 1 lettuce
     */
    public void chewLuttuce(Player player) {
        if (player.getNoOfLettuce() > 0) {
            player.removeLettuce();
            player.addCarrots(getPlayerPositionInRace(player) * 10);
        }
    }

    /**
     * Move back tortoise square calculation
     * No check is done to check for is square a tortoise square or is the tortoise square the nearest one
     * @param player
     * @param move
     */
    public void moveBackToTortoise(Player player, int move) {
        int oldPosition = player.getPosition();
        if(notValidMove(player, move) == false) {
            player.setPosition(player.getPosition() - move);
            player.addCarrots(oldPosition - player.getPosition());
        }
    }

    /**
     * Check is a move for a player is invalid. Checks if player have enough carrots for move and is the position
     * already occupied another player
     * @param player
     * @param move
     * @return
     */
    public boolean notValidMove(Player player, int move) {
        // If statement to check is player has enough carrots for move
        if (carrotsRequired(move) > player.getNoOfCarrots()) {
            return true;
        }

        //Check is square already occupied by another player by checking for each player position in players array
        //Problem: Assuming finish is a tile - players can't move to finish after first player
        for (int i = 0; i < players.size(); i++) {
            // If the new position is a current position of another player
            if ((player.getPosition() + move) == players.get(i).getPosition()) {
                return true;
            }
        }
        return false;
    }

}