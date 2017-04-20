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
    
    public void setGameState(ArrayList<Player> players, int currentPlayer){
        this.players = new ArrayList<>();
        this.players.addAll(players);
        this.currentTurn = currentPlayer;
    }
    
    public ArrayList<Player> getPlayers () {
        return players;
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
}
