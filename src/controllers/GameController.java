package controllers;
import models.*;
import java.util.ArrayList;
import board.*;

import static utils.ScannerInput.*;

/**
 * This class
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.28
 */
public class GameController {
    ArrayList<Player> players;
    HareDeck hareDeck = new HareDeck();
    
    ArrayList<Square> board;
    
    int currentTurn = 0;
    
    public GameController(){
        players = new ArrayList<>();
        startNewGame();
    }
    
    public void startNewGame () {
        createBoard();
    
        new BoardDisplay(board);
        System.out.println("Welcome to The Hare and Tortoise");
        
        int numPlayers = validNextInt("Enter the number of players you want to play:");
        
        while (numPlayers < 2 || numPlayers > 6) {
            numPlayers = validNextInt("Please choose a number between 2 and 6:");
        }
        
        for (int i = 0; i < numPlayers; i++) {
            String name = retrieveText("Enter player " + (i + 1) + " name");
            addPlayer(name);
        }
        
        for (int i = 0 ; i < players.size(); i++) {
            board.get(0).setPlayer(players.get(i));
        }
        runMenu();
    }
    
    public void createBoard() {
        board = new ArrayList<>();
        //TODO Confirm we need to input a position and name
        board.add(new StartSquare("Start", 0));
        board.add(new CarrotSquare("Carrots", 1));
        board.add(new CarrotSquare("Carrots", 2));
        board.add(new CarrotSquare("Carrots", 3));
        board.add(new TortoiseSquare("Tortoise", 4));
        board.add(new CarrotSquare("Carrots", 5));
        board.add(new CarrotSquare("Carrots", 6));
        board.add(new CarrotSquare("Carrots", 7));
        board.add(new CarrotSquare("Carrots", 8));
        board.add(new CarrotSquare("Carrots", 9));
        board.add(new CarrotSquare("Carrots", 10));
        board.add(new TortoiseSquare("Tortoise", 11));
        board.add(new CarrotSquare("Carrots", 12));
        board.add(new CarrotSquare("Carrots", 13));
        board.add(new CarrotSquare("Carrots", 14));
        board.add(new CarrotSquare("Carrots", 15));
        board.add(new CarrotSquare("Carrots", 16));
        board.add(new TortoiseSquare("Tortoise", 17));
        board.add(new CarrotSquare("Carrots", 18));
        board.add(new CarrotSquare("Carrots", 19));
        board.add(new CarrotSquare("Carrots", 20));
        board.add(new CarrotSquare("Carrots", 21));
        board.add(new CarrotSquare("Carrots", 22));
        board.add(new CarrotSquare("Carrots", 23));
        board.add(new TortoiseSquare("Tortoise", 24));
        board.add(new CarrotSquare("Carrots", 25));
        board.add(new CarrotSquare("Carrots", 26));
        board.add(new CarrotSquare("Carrots", 27));
        board.add(new CarrotSquare("Carrots", 28));
        board.add(new TortoiseSquare("Tortoise", 29));
        board.add(new CarrotSquare("Carrots", 30));
        board.add(new CarrotSquare("Carrots", 31));
        board.add(new CarrotSquare("Carrots", 32));
        board.add(new CarrotSquare("Carrots", 33));
        board.add(new CarrotSquare("Carrots", 34));
        board.add(new CarrotSquare("Carrots", 35));
        board.add(new TortoiseSquare("Tortoise", 36));
        board.add(new CarrotSquare("Carrots", 37));
        board.add(new CarrotSquare("Carrots", 38));
        board.add(new CarrotSquare("Carrots", 39));
        board.add(new CarrotSquare("Carrots", 40));
        board.add(new TortoiseSquare("Tortoise", 41));
        board.add(new CarrotSquare("Carrots", 42));
        board.add(new CarrotSquare("Carrots", 43));
        board.add(new CarrotSquare("Carrots", 44));
        board.add(new CarrotSquare("Carrots", 45));
        board.add(new CarrotSquare("Carrots", 46));
        board.add(new CarrotSquare("Carrots", 47));
        board.add(new TortoiseSquare("Tortoise", 48));
        board.add(new CarrotSquare("Carrots", 49));
        board.add(new CarrotSquare("Carrots", 50));
        board.add(new CarrotSquare("Carrots", 51));
        board.add(new CarrotSquare("Carrots", 52));
        board.add(new TortoiseSquare("Tortoise", 53));
        board.add(new CarrotSquare("Carrots", 54));
        board.add(new CarrotSquare("Carrots", 55));
        board.add(new CarrotSquare("Carrots", 56));
        board.add(new CarrotSquare("Carrots", 57));
        board.add(new TortoiseSquare("Tortoise", 58));
        board.add(new CarrotSquare("Carrots", 59));
        board.add(new CarrotSquare("Carrots", 60));
        board.add(new CarrotSquare("Carrots", 61));
        board.add(new CarrotSquare("Carrots", 62));
        board.add(new TortoiseSquare("Tortoise", 63));
        board.add(new CarrotSquare("Carrots", 64));
    }
    
    public void addPlayer (String name) {
        players.add(new Player(name));
    }
    
    public void listPlayers () {
        for (int i = 0 ; i < players.size() ; i++) {
            System.out.println(players.get(i).toString());
        }
    }
    
    private void runMenu(){
        while (!isFinished()) {
            takeTurn();


            new BoardDisplay(board);
    
            listPlayers();
            //TODO crashes when all players are finished
            nextTurn();
        }
        System.out.println("The game is finished, here is the final standings:");
    }

    /**
     * Method to give players option to move backwards, stay on current tile, or move forward, with checks for these option.
     * Also contains the condition of where the player must move back to start square when there is no available moves for the player
     */
    public void takeTurn() {
        
        if (getCurrentPlayer().getPendingBalance() > 0) {
            String option = retrieveText("You have a pending balance, what do you want to do? (accept/reject)").toLowerCase();
            while (option.equals("accept") || option.equals("reject")) {
                if (option.equals("accept")) {
                    getCurrentPlayer().addCarrots(getCurrentPlayer().getPendingBalance());
                    System.out.println(getCurrentPlayer().getPendingBalance() + " carrots added");
                    getCurrentPlayer().setPendingBalance(0);
                }
            }
        
        }
        // If player can't move backwards, stay, and forward, set player position to start and no of carrots to 65
        if (!canMoveBackward() && !canStay() && !canMoveForward()) {
            System.out.println("Sorry, there were no available moves, you have been reset to the beginning");
            movePlayer(getCurrentPlayer(),0);
            getCurrentPlayer().setNoOfCarrots(65);
        }

        // Boolean value to loop until the current player has taken a valid turn
        boolean turnTaken = false;
        while(!turnTaken) {
            String moveType = retrieveText("What do you want to do " + getCurrentPlayer().getPlayerName() + " (back / stay / move)");
            // If player chooses to move back and the canMoveBackward condition is true
            if (moveType.equalsIgnoreCase("back") && canMoveBackward()) {
                // Moves player to the nearest previous tortoise
                movePlayer(getCurrentPlayer(), findPreviousTortoise());
                turnTaken = true;
            }
            // If player chooses to stay and the canStay condition is true
            else if (moveType.equalsIgnoreCase("stay") && canStay()) {
                turnTaken = true;
            }
            // If player chooses to move and the canMoveForward condition is true
            else if (moveType.equalsIgnoreCase("move") && canMoveForward()) {
                int distance = validNextInt("Enter the number of squares you wish to move " + getCurrentPlayer().getPlayerName());
                int newSquareIndex = getCurrentPlayer().getPosition() + distance;
                // Checks if the newSquareIndex the player wants to move to is on the board
                if (newSquareIndex < board.size()) {
                    // Loop for if the newSquarePosition is already occupied or if player doesn't have enough carrots to pay for move
                    while (!board.get(newSquareIndex).canMoveHere(getCurrentPlayer()) || calculateMaxDistance(getCurrentPlayer().getNoOfCarrots()) < distance) {
                        distance = validNextInt("Invalid option entered " + getCurrentPlayer().getPlayerName());
                        // Update distance to new option entered
                        newSquareIndex = getCurrentPlayer().getPosition() + distance;
                    }
                    // Move player to new position and remove carrots for the move
                    movePlayer(getCurrentPlayer(), newSquareIndex);
                    getCurrentPlayer().removeCarrots(carrotsRequired(distance));
                    turnTaken = true;
                } else {
                    System.out.println("Square does not exist");
                }
            }
            else {
                System.out.println("This option is not available");
            }
        }
    }
    
    public int findPreviousTortoise() {
        int i = getCurrentPlayer().getPosition();
        if (i != 0) {
            i -= 1;
            while (i > 0 && !board.get(i).getName().equals("Tortoise")) {
                i--;
            }
        }
        return i;
    }
    
    public boolean canMoveBackward() {
        int prevTortoise = findPreviousTortoise();
        if (prevTortoise == 0 || !board.get(prevTortoise).canMoveHere(getCurrentPlayer())){
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean canStay() {
        return board.get(getCurrentPlayer().getPosition()).canStay();
    }
    
    public boolean canMoveForward() {
        for (int i = getCurrentPlayer().getPosition() ; i < board.size() ; i++) {
            if (board.get(i).canMoveHere(getCurrentPlayer())) {
                return true;
            }
        }
        return false;
    }
    
    public void movePlayer (Player player, int position) {
        board.get(player.getPosition()).removePlayer(player);
        board.get(position).setPlayer(player);
    }
    
    //TODO Implement Nialls board display instead
    public void printBoard() {
        String str = "";
        String playerName = "";
        for (int i = 0 ; i < board.size(); i++) {
        
            for (int j = 0 ; j < board.get(i).players.size() ; j++) {
                playerName += board.get(i).players.get(j).getPlayerName() + ", ";
            }
           
            str = str + i + ": " + board.get(i).name + " " + playerName + ": "+ "\n";
            playerName = "";
        }
        System.out.print(str);
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
		/* Alternative way to find the carrots required
		* int carrots = 0;
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
        
        //Skip if players flag is set to skip turn or if player is finished
        if (getCurrentPlayer().getSkipTurn() || isPlayerFinished(getCurrentPlayer())) {
            getCurrentPlayer().setSkipTurn(false);
            nextTurn();
        }
    }
    
    
    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }
    
    /**
     * Returns whether the passed player is on the final square
     * @param player the player that is checked to see if they are finished
     * @return a boolean representing if the player is on the final square
     */
    public boolean isPlayerFinished (Player player) {
        if (player.getPosition() != board.size() - 1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * Returns whether the game is finished for the while loop, returns false if any user is on any
     * square but the last one.
     * @return a boolean representing whether all players are on the final square
     */
    private boolean isFinished () {
        for ( int i = 0 ; i < players.size() ; i++ ) {
            if (!isPlayerFinished(players.get(i))){
                return false;
            }
        }
        return true;
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