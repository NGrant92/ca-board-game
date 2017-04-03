package models;

import java.util.ArrayList;

/**
 * A square is a space on the board which a player can land on
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.29
 */
public abstract class Square {
    public ArrayList<Player> players;
    public String name;
    
    int position;
    
    public Square(String name, int position) {
        players = new ArrayList<>();
        this.position = position;
        this.name = name;
    }
    
    public void setPlayer(Player player) {
        players.add(player);
        player.setPosition(position);
    }
    
    public void removePlayer(Player player) {
        players.remove(player);
    }
    
    public boolean isAvailable() {
        if (players.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
