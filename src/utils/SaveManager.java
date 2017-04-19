package utils;

import models.Player;
import models.Square;

import java.util.ArrayList;

/**
 * Created by keela on 19/04/2017.
 */
public class SaveManager {
    private ArrayList<Player> players;
    
    public void setPlayers(ArrayList<Player> players){
        this.players = new ArrayList<>();
        this.players.addAll(players);
    }
    
    public ArrayList<Player> getPlayers () {
        return players;
    }
    
}
