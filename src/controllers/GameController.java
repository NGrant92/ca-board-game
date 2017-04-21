package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import board.*;
import utils.SaveManager;

import static utils.ScannerInput.*;
import static utils.GameHelperMethods.carrotsRequired;

/**
 * This class handles the game. The MenuController will specify whether the GameController
 * should create a new game or load a game by way of a boolean param in the constructor.
 * Once a game is started/loaded a while loop runs until the game is finished.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.28
 */
public class GameController {
    private ArrayList<Player> players;
    private HareDeck hareDeck = new HareDeck();

    private ArrayList<Square> board;
    private SaveManager saveManager = new SaveManager();

    private int currentTurn = 0;
    
    /**
     * The default constructor for a game which calls upon the startNewGame method if the
     * the user has specified it should be a new game in the MenuController. Otherwise a
     * game is loaded.
     * @param newGame a boolean representing if the game should be a new game or loaded
     */
    public GameController(boolean newGame) {
        players = new ArrayList<>();
        if (newGame) {
            startNewGame();
        } else {
            try {
                loadGame();
                runGame();
            } catch (Exception e) {
                System.out.print(e.toString());
                
            }
        }
    }
    
    /**
     * Sets up a new game by calling the create board method. The method then
     * asks for details of players to be entered. Once players are entered
     * runMenu method is called
     */
    private void startNewGame() {
        createBoard();

        insertLines();

        System.out.println("Welcome to The Hare and Tortoise");

        int numPlayers = validNextInt("Enter the number of players you want to play:");

        while (numPlayers < 2 || numPlayers > 6) {
            numPlayers = validNextInt("Please choose a number between 2 and 6:");
        }

        for (int i = 0; i < numPlayers; i++) {
            String name = retrieveText("Enter player " + (i + 1) + " name");
            addPlayer(name);
        }

        for (int i = 0; i < players.size(); i++) {
            board.get(0).setPlayer(players.get(i));
        }

        runGame();
    }
    
    /**
     * The loop which the game is played within is held within this function.
     * The game will continuously loop through turns until all players are finished.
     */
    private void runGame() {
        while (!isFinished()) {
            insertLines();
            
            new BoardDisplay(board);
            
            takeTurn();
            
            //Allows reading time before the player's next turn
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            
            if (!isFinished()) {
                nextTurn();
            }
            
            try {
                saveGame();
            }
            catch (Exception e) {
                System.out.print(e.toString());
            }
        }
        System.out.println("Congratulations the game is finished!");
    }
    
    
    /**
     * Populates the board array
     */
    private void createBoard() {
        board = new ArrayList<>();

        List<Integer> hareSquares = Arrays.asList(1, 3, 6, 14, 25, 31, 34, 39, 46, 51, 58, 62);
        List<Integer> carrotSquares = Arrays.asList(2, 5, 13, 21, 26, 33, 38, 40, 48, 55, 59, 61, 63);
        List<Integer> threeSquares = Arrays.asList(4, 12, 20, 28, 36, 44, 52);
        List<Integer> oneFiveSixSquares = Arrays.asList(7, 16, 32, 49, 60);
        List<Integer> twoSquares = Arrays.asList(8, 17, 23, 29, 35, 41, 47, 53);
        List<Integer> fourSquares = Arrays.asList(9, 18, 27, 45, 54);
        List<Integer> lettuceSquares = Arrays.asList(10, 22, 42, 57);
        List<Integer> tortoiseSquares = Arrays.asList(11, 15, 19, 24, 30, 37, 43, 50, 56);

        for (int i = 0; i < 65; i++) {
            if (i == 0) {
                board.add(new StartSquare("Start", i));
            }
            if (hareSquares.contains(i)) {
                board.add(new HareSquare("Hare", i, hareDeck));
            }
            if (carrotSquares.contains(i)) {
                board.add(new CarrotSquare("Carrots", i));
            }
            if (threeSquares.contains(i)) {
                board.add(new PostionSquare("3", i));
            }
            if (oneFiveSixSquares.contains(i)) {
                board.add(new PostionSquare("156", i));
            }
            if (twoSquares.contains(i)) {
                board.add(new PostionSquare("2", i));
            }
            if (fourSquares.contains(i)) {
                board.add(new PostionSquare("4", i));
            }
            if (lettuceSquares.contains(i)) {
                board.add(new LettuceSquare("Lettuce", i));
            }
            if (tortoiseSquares.contains(i)) {
                board.add(new TortoiseSquare("Tortoise", i));
            }
            if (i == 64) {
                board.add(new FinishSquare("Finish", i));
            }
        }
    }

    /**
     * Adds a player to the game
     *
     * @param name the players name
     */
    private void addPlayer(String name) {
        players.add(new Player(name));
    }
    
    /**
     * Method to give players option to move backwards, stay on current tile, or move forward, with checks for these option.
     * Also contains the condition of where the player must move back to start square when there is no available moves for the player
     */
    private void takeTurn() {
        //The position square rule needs to be applied at the start of the persons next turn while
        //This checks if the Square.getName contains numbers, as the position square is the only one to have numbers
        if (board.get(getCurrentPlayer().getPosition()).getName().matches("[0-9]+")) {
            System.out.println(board.get(getCurrentPlayer().getPosition()).applyRule(players));
        }

        // Calls the handlePendingBalance method to take care of any pending balance for the player, if any
        handlePendingBalance();
        // If player can't move backwards, stay, and forward, set player position to start and no of carrots to 65
        if (!canMoveBackward() && !canStay() && !canMoveForward()) {
            System.out.println("Sorry, there were no available moves, you have been reset to the beginning");
            movePlayer(getCurrentPlayer(), 0);
            getCurrentPlayer().setNoOfCarrots(65);
        }

        // Boolean value to loop until the current player has taken a valid turn
        boolean turnTaken = false;
        while (!turnTaken) {
            String options = "";
            if (canMoveBackward()) {
                options += "(back) ";
            }
            if (canStay()) {
                options += "(stay) ";
            }
            if (canMoveForward()) {
                options += "(move) ";
            }
            // Added currentPlayer toString to see player details before taking each turn
            System.out.println(getCurrentPlayer().toString());
            String moveType = retrieveText("What do you want to do " + getCurrentPlayer().getPlayerName() + "\tAvailable options: " + options);
            // If player chooses to move back and the canMoveBackward condition is true
            if (moveType.equals("back") && canMoveBackward()) {
                // Moves player to the nearest previous tortoise
                movePlayer(getCurrentPlayer(), findPreviousTortoise());
                turnTaken = true;
                System.out.println(board.get(getCurrentPlayer().getPosition()).applyRule(players));
            }
            // If player chooses to stay and the canStay condition is true
            else if (moveType.equals("stay") && canStay()) {
                // -- Handle carrot square logic here
                System.out.println(board.get(getCurrentPlayer().getPosition()).applyRule(players));
                if (board.get(getCurrentPlayer().getPosition()).getName().equals("Carrots")) {
                    while (!turnTaken) {
                        String option = retrieveText("Choose to gain or remove 10 carrots (gain / remove) :");
                        if (option.equals("gain")) {
                            getCurrentPlayer().addCarrots(10);
                            System.out.println("You have just gained 10 carrots");
                            turnTaken = true;
                        } else if (option.equals("remove")) {
                            getCurrentPlayer().removeCarrots(10);
                            System.out.println("You have just removed 10 carrots");
                            turnTaken = true;
                        } else {
                            System.err.println("Not a valid option. Please re-enter your choice: ");
                        }
                    }
                }
                // Set current player previous position to current position (wasn't updated correctly beforehand because
                // player doesn't move)
                getCurrentPlayer().setPreviousPosition(getCurrentPlayer().getPosition());
                turnTaken = true;
            }
            // If player chooses to move and the canMoveForward condition is true
            else if (moveType.equals("move") && canMoveForward()) {
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
                    System.out.println(board.get(getCurrentPlayer().getPosition()).applyRule(players));
                } else {
                    System.out.println("Square does not exist");
                }
            } else {
                System.err.println("This option is not available. Please re-enter option:");
            }
        }
    }
    
    /**
     * Finds the previous tortoise square relevant to the current players position
     * @return the position of the previous tortoise square
     */
    private int findPreviousTortoise() {
        int i = getCurrentPlayer().getPosition();
        if (i != 0) {
            i -= 1;
            while (i > 0 && !board.get(i).getName().equals("Tortoise")) {
                i--;
            }
        }
        return i;
    }
    
    /**
     * Checks if a player can move backwards
     * @return a boolean stating whether the player can move back to the previous tortoise square
     */
    private boolean canMoveBackward() {
        // If the player is on a lettuce square and has not stayed on the lettuce square once - return false
        if (board.get(getCurrentPlayer().getPosition()).getName().equals("Lettuce") && (getCurrentPlayer().getPreviousPosition() != getCurrentPlayer().getPosition())) {
            return false;
        }

        int prevTortoise = findPreviousTortoise();
        if (prevTortoise == 0 || !board.get(prevTortoise).canMoveHere(getCurrentPlayer())) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Checks if a player can stay in their current position.
     * @return if the player can stay
     */
    private boolean canStay() {
        return board.get(getCurrentPlayer().getPosition()).canStay();
    }

    /**
     * Method that returns a boolean value of whether the player can move forward.
     * A boolean value of false is returned if a player is on a lettuce square and has not stayed on the lettuce square on
     * the turn the player has removed a lettuce.
     * A boolean value of true is returned if any square in front is available for player to occupy
     *
     * @return Boolean value of whether the player can move forward.
     */
    private boolean canMoveForward() {
        // If the player is on a lettuce square and has not stayed on the lettuce square once - return false
        if (board.get(getCurrentPlayer().getPosition()).getName().equals("Lettuce") && (getCurrentPlayer().getPreviousPosition() != getCurrentPlayer().getPosition())) {
            return false;
        }

        // Checks the availability of square's in between the current player's position and (maxDistance + currentPositon)
        // Only executes when currentPlayerPosition + maxDistance is less than the board size - Prevents a chance of
        // ArrayOutOfBounds exception when currentPlayerPosition + maxDistance is greater than the board size
        if ((getCurrentPlayer().getPosition() + calculateMaxDistance(getCurrentPlayer().getNoOfCarrots())) < board.size()) {
            for (int i = getCurrentPlayer().getPosition(); i <= (getCurrentPlayer().getPosition() + calculateMaxDistance(getCurrentPlayer().getNoOfCarrots())); i++) {
                if (board.get(i).canMoveHere(getCurrentPlayer())) {
                    return true;
                }
            }
        }
        // In all other conditions, checks the availability of all squares on the board greater than the player's
        // current position
        else {
            for (int i = getCurrentPlayer().getPosition(); i < board.size(); i++) {
                if (board.get(i).canMoveHere(getCurrentPlayer())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Removes the player from a square and moves them to the new square
     * @param player the player to be moved
     * @param position the position the player wishes to move to
     */
    private void movePlayer(Player player, int position) {
        board.get(player.getPosition()).removePlayer(player);
        board.get(position).setPlayer(player);
    }

    /**
     * Calculates what would be the input to the triangular number sequence
     * equation from the number of carrots available. The method then rounds
     * down to find the maximum number of moves.
     *
     * @param carrots The players balance of carrots
     * @return the maximum number of moves a player can make
     */
    private int calculateMaxDistance(int carrots) {
        //Find the natural number (input)
        double distance = (Math.sqrt((8 * carrots) + 1) - 1) / 2;
        //Round down to the whole number
        int roundedDown = (int) Math.floor(distance);
        return roundedDown;
    }
    
    /**
     * Handles the Current Turn integer by incrementing until the integer would be greater than
     * the number of players. If a player is set to skip their turn the method sets the skip turn
     * boolean to false and calls itself again.
     */
    private void nextTurn() {
        currentTurn++;

        if (currentTurn >= players.size()) {
            currentTurn = 0;
        }

        //Skip if players flag is set to skip turn or if player is finished
        if (getCurrentPlayer().getSkipTurn() || isPlayerFinished(getCurrentPlayer())) {
            getCurrentPlayer().setSkipTurn(false);
            nextTurn();
        }
    }

    /**
     * Finds the current player by using the int representing the current player
     * to retrieve the current player from the array
     *
     * @return the current player
     */
    private Player getCurrentPlayer() {
        return players.get(currentTurn);
    }

    /**
     * Returns whether the passed player is on the final square
     *
     * @param player the player that is checked to see if they are finished
     * @return a boolean representing if the player is on the final square
     */
    private boolean isPlayerFinished(Player player) {
        if (player.getPosition() != board.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns whether the game is finished for the while loop, returns false if any user is on any
     * square but the last one.
     *
     * @return a boolean representing whether all players are on the final square
     */
    private boolean isFinished() {
        for (int i = 0; i < players.size(); i++) {
            if (!isPlayerFinished(players.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Prints out blank lines to stop a player reading the previous turn
     */
    private void insertLines() {
        for (int clear = 0; clear < 15; clear++) {
            System.out.println("\n");
        }
    }

    /**
     * This method would be handle the pending balance the player. This method would be called before the player takes their
     * turn.
     */
    private void handlePendingBalance() {
        while (getCurrentPlayer().getPendingBalance() > 0) {
            String option = retrieveText(getCurrentPlayer().getPlayerName() + ", you have a pending balance of "
                    + getCurrentPlayer().getPendingBalance() + " carrots, what do you want to do? (accept/reject)").toLowerCase();
            if (option.equals("accept")) {
                getCurrentPlayer().addCarrots(getCurrentPlayer().getPendingBalance());
                System.out.println(getCurrentPlayer().getPendingBalance() + " carrots added");
                getCurrentPlayer().resetPendingBalance();
            } else if (option.equals("reject")) {
                System.out.println(getCurrentPlayer().getPendingBalance() + " carrots rejected");
                getCurrentPlayer().resetPendingBalance();
            } else {
                System.err.println("Not a valid option. Please re-enter option: ");
            }
        }
    }
    
    /**
     * Saves the current game state to xml by utilising the SaveManager class
     * @throws Exception
     */
    private void saveGame() throws Exception{
        saveManager.setGameState(players,currentTurn);
        
        XStream xstream=new XStream(new DomDriver());
        ObjectOutputStream out=xstream.createObjectOutputStream
            (new FileWriter("game.xml"));
        out.writeObject(saveManager);
        out.close();
    }
    
    /**
     * Loads the game from a SaveManager object
     * @throws Exception
     */
    @SuppressWarnings ("unchecked")
    private void loadGame () throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
            (new FileReader("game.xml"));
        saveManager = (SaveManager) is.readObject();
        is.close();
        createBoard();
        players = saveManager.getPlayers();
        for (int i = 0 ; i < players.size() ; i++) {
            board.get(players.get(i).getPosition()).setPlayer(players.get(i));
        }
        currentTurn = saveManager.getCurrentTurn();
    }
}