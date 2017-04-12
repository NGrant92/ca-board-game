package models;

import java.util.ArrayList;

/**
 * Created by Kevin on 06/04/2017.
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.03
 */
public class LettuceSquare extends Square{

    /**
     * Constructor for the CarrotSquare Object
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public LettuceSquare(String name, int position) {
        super(name, position);
    }

    /**
     *
     * @param currentPlayer Player object that is passed in to get play information
     */
    public void applyRule(ArrayList<Player> players, Player currentPlayer) {
        // Removes a lettuce from the currentPlayer on the lettuce square
        // No check is done here because player should not be able to move to lettuce square unless they at least 1 lettuce,
        // which is done by the canMoveHere() method
        currentPlayer.removeLettuce();

        // Adds 10 * racePosition to the currentPlayer
        currentPlayer.addCarrots(getRacePosition(players) * 10);
    }

    /**
     * Overrides the superclass CanMoveHere method with inclusion of check for more than one lettuce and previous player
     * position
     * @param player Player object to be passed in to check is square available for player
     * @return Boolean value of the availability of the square
     */
    @Override
    public boolean canMoveHere(Player player) {
        // Player can only move here is there are no players on the square and
        if(players.size() == 0 && player.getNoOfLettuce() > 0 && player.getPreviousPosition() != player.getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that returns whether the player can stay on the current square
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
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     */
    private int getRacePosition(ArrayList<Player> p) {
        // local variable to store the players current position - not really need
        int currentPlayerPositionOnBoard = players.get(0).getPosition();
        // Local temporary store for playerPositionInRace - Player begins as in 1st position
        int racePosition = 1;

        // Compares the currentPlayerPositionOnBoard to each playerPosition in the players array. If currentPlayerPositionOnBoard
        // is less than playerPosition, the playerPositionInRace is incremented by 1
        for (int i = 0; i < p.size(); i++) {
            if (currentPlayerPositionOnBoard < p.get(i).getPosition()) {
                racePosition++;
            }
        }
        return racePosition;
    }

    /**
     * Returns a string of the number of lettuce the player has left and the number of carrots the player has
     */
    public String toString() {
        return "You now have " + players.get(0).getNoOfLettuce() + "Lettuce and " + players.get(0).getNoOfCarrots() + " carrots";
    }
}
