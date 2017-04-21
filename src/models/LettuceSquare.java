package models;

import java.util.ArrayList;
import static utils.GameHelperMethods.getRacePosition;
/**
 * This class extends the Square class, and models a Lettuce Square.
 *
 * Created by Kevin on 06/04/2017.
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.20
 */
public class LettuceSquare extends Square {
    private int turnCounter;

    /**
     * Constructor for the LettuceSquare Object
     *
     * @param name     The name of the square
     * @param position The number of the square on the board
     */
    public LettuceSquare(String name, int position) {
        super(name, position);
    }

    /**
     * Overrides the superclass method with rules that is applied to the player on the lettuce square.
     *
     * @param allPlayers ArrayList of players in the game
     * @return Return a String message of the rules applied
     */
    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
        String ruleMessage;

        // Increment turnCounter by 1 each time the applyRule method is called - which will determine the method output
        turnCounter++;

        // Local store of how many carrots the player will gain for removing a lettuce
        int carrotGain = getRacePosition(allPlayers, position) * 10;

        switch (turnCounter) {
            // Player just landed on the lettuce square
            case 1:
                ruleMessage = "You've landed on the lettuce square, you must stay on the lettuce square on your next turn";
                break;
            // Player must chew a lettuce this turn
            case 2:
                ruleMessage = "\nNOM NOM NOM\nYou just ate a lettuce and have gained " + carrotGain + " carrots. You need time to digest. " +
                        "\nYou must have move to another square on your next turn.\n";
                chewLettuce(carrotGain);
                break;
            default:
                ruleMessage = "Something is wrong if this message is displayed :/ ";
                break;
        }
        return ruleMessage;
    }

    /**
     * Overrides the superclass CanMoveHere method with inclusion of check for more than one lettuce and previous player
     * position
     *
     * @param player Player object to be passed in to check is square available for player
     * @return Boolean value of the availability of the square
     */
    @Override
    public boolean canMoveHere(Player player) {
        // Player can only move here is there are no players on the square and has at least one lettuce
        if (players.size() == 0 && player.getNoOfLettuce() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that returns whether the player can stay on the current square
     *
     * @return Boolean value for whether the player can stay
     */
    @Override
    public boolean canStay() {
        // Player can stay only if his previous position is not the same as the current position
        // This wouldn't allow the player to stay on the lettuce square for more than one turn
        if (players.get(0).getPreviousPosition() != players.get(0).getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method would decrement the player's lettuce count by 1 and give the player carrots 10 * racePosition of the player.
     * This method would be used when a player stay's a lettuce square
     *
     * @param carrotGain Amount of carrots player would gain for removing one lettuce
     */
    private void chewLettuce(int carrotGain) {
        // Remove 1 lettuce from the player
        players.get(0).removeLettuce();

        // Adds 10 * racePosition to the currentPlayer (
        players.get(0).addCarrots(carrotGain);
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
