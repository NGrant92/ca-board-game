package models;

/**
 * This class extends the Square class, and models a Start Square. Only
 * the start square and finish square can accept multiple players.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.20
 */
public class StartSquare extends Square {
    
    /**
     * Constructor for a start square
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public StartSquare(String name, int position) {
        super(name, position);
    }
    
    /**
     * Override the superclass method. The start square is always available to a player but the
     * player can only be moved back when conditions are met in GameController
     * @param player The player looking to move to the square
     * @return that the start square is always available
     */
    @Override
    public boolean canMoveHere(Player player) {
        return true;
    }
}
