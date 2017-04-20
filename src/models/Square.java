package models;

import java.util.ArrayList;

/**
 * A square is a space on the board which a player can land on, this is the superclass
 * for all squares
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
    
    /**
     * Constructor for a square object
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public Square(String name, int position) {
        players = new ArrayList<>();
        this.position = position;
        this.name = name;
    }
    
    /**
     * Sets a player to the square
     * @param player The player moving to the square
     */
    public void setPlayer(Player player) {
        players.add(player);
        player.setPosition(position);
    }
    
    /**
     * Returns the name of a square
     * @return The name of the square
     */
    public String getName() {
        return name;
    }
    
    /**
     * A boolean representing if the player can stay on the square
     * @return whether a player can stay
     */
    public boolean canStay() {
        return false;
    }
    
    /**
     * Responsible for removing a player from the square
     * @param player the player to be removed
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }
    
    /**
     * Returns a boolean representing if a given player can move to a square
     * @param player The player looking to move to the square
     * @return if the square is available to the player
     */
    public boolean canMoveHere(Player player) {
        if (players.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets the players on the square
     * @return the players on the square
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    /**
     * Applies the rule that a given square must apply
     * @param allPlayers the array of players in the game
     * @return a string stating what rule has been applied.
     */
    public String applyRule(ArrayList<Player> allPlayers) {
        return "No rule applied";
    }
}
