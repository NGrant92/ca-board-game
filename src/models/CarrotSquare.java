package models;

import java.util.ArrayList;

/**
 * This class extends the Square class, and models a Carrot Square.
 *
 * Created by keela on 01/04/2017.
 * Edited by Kevin on 20/04/2017.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.20
 */
public class CarrotSquare extends Square {
    private int turnCounter;

    /**
     * Constructor for the CarrotSquare Object. A player on a carrot square can receive or remove 10 carrots in exchange
     * for not moving for the turn.
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public CarrotSquare(String name, int position) {
        super(name, position);
    }

    /**
     * Returns whether the square allows the player to stay for more than one turn.
     * Carrot squares allows the player to stay indefinitely in exchange for not moving and adding/removing 10 carrots
     * @return Boolean value on whether the player can stay on the square - always return true for a carrot square
     */
    @Override
    public boolean canStay() {
        return true;
    }

    /**
     * Overrides the superclass method. Returns a string to the player about the rules of a carrot square when they land
     * on a carrot square
     * @param allPlayers ArrayList of players in the game
     * @return Return a String about the rules of the carrot square
     */
    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
        turnCounter++;
        String ruleMessage;
        switch (turnCounter) {
            case 1:
                ruleMessage ="If you choose to stay on carrot square, you can choose to gain or remove 10 carrots!";
                break;
            default:
                ruleMessage = "You choose to stay on the carrot square. You can't move to another square this turn";
                break;
        }

        return ruleMessage;
    }

    /**
     * Override the superclass method. This method has an addition of resetting the turnCounter field back to 0 when removing the player
     * from the square
     *
     * @param player Player object passed in
     */
    @Override
    public void removePlayer(Player player) {
        turnCounter = 0;
        players.remove(player);
    }
}
