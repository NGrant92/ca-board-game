package utils;

import models.Player;

import java.util.ArrayList;

/**
 * Manages objects that need to be saved
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.19
 */
public class SaveManager {
    private ArrayList<Player> players;
    private int currentTurn;
    
    /**
     * Sets the players array and current player in the SaveManager object
     * @param players The players from GameController
     * @param currentPlayer The integer representing the current player
     */
    public void setGameState(ArrayList<Player> players, int currentPlayer){
        this.players = new ArrayList<>();
        this.players.addAll(players);
        this.currentTurn = currentPlayer;
    }
    
    /**
     * Returns the list of players that were saved to the xml
     * @return The players ArrayList saved to the xml
     */
    public ArrayList<Player> getPlayers () {
        return players;
    }
    
    /**
     * Returns the integer representing the current players turn
     * @return The integer representing which player from the array is the current player
     */
    public int getCurrentTurn() {
        return currentTurn;
    }
}
