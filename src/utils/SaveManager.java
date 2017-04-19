package utils;

import models.Player;

import java.util.ArrayList;

/**
 * Created by keela on 19/04/2017.
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
