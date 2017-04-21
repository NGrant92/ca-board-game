package models;

import java.util.ArrayList;

/**
 * This class extends the Square class, and models a Start Square. A Tortoise
 * Square can only be moved back to. The player receives carrots for moving back
 * to the square.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.08
 */
public class TortoiseSquare extends Square {
    
    /**
     * Constructor for a tortoise square
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public TortoiseSquare(String name, int position) {
        super(name, position);
    }
    
    /**
     * Returns if a player can move to the square based on if it is occupied
     * and whether the players position is greater than that of the square.
     * @param player The player looking to move to the square
     * @return if the player can move here
     */
    @Override
    public boolean canMoveHere(Player player) {
        if (player.getPosition() > position) {
            if (players.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * Gifts the player the appropriate amount of carrots
     * @param allPlayers the array of players in the game
     * @return a string explaining the rule that was applied
     */
    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
        Player player = players.get(0);
        
        int squaresMoved = player.getPreviousPosition() - position;
        int carrots = squaresMoved * 10;
        player.addCarrots(carrots);
        
        return "You moved back " + squaresMoved + " squares, you gained " + carrots + " carrots!";
    }
}
