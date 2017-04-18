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
    private int turnCounter;
    /**
     * Constructor for the LettuceSquare Object
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public LettuceSquare(String name, int position) {
        super(name, position);
    }

    /**
     * Overrides the superclass method with rules that is applied to the player on the lettuce square before
     * they take their turn
     *
     * @param allPlayers ArrayList of players in the game
     */
    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
        String ruleMessage = "";

        // Increment turnCounter by 1 each time the applyRule method is called - which will determine the method output
        turnCounter++;

        // Local store of how many carrots the player will gain for removing a lettuce
        int carrotGain = getRacePosition(allPlayers) * 10;

        switch (turnCounter) {
            // Player must chew a lettuce this turn
            case 1:
                ruleMessage = "\nNOM NOM NOM\nYou just ate a lettuce and have gained " + carrotGain + " carrots. You need time to digest. " +
                        "\nYou can only stay on this lettuce square for this turn.\n";
                chewLettuce(carrotGain);
                break;
            // Player has already eaten lettuce and must must to another square (logic is done by the canStay() method)
            case 2:
                ruleMessage = "\nYou have already stayed on this lettuce square. You must move to another square this turn\n";
        }
        return ruleMessage;
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
        if(players.size() == 0 && player.getNoOfLettuce() > 0) {
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
    private int getRacePosition(ArrayList<Player> allPlayers) {
        // Assume player racePosition is in 1st place;
        int racePosition = 1;

        // For each loop comparing the player's current position
        for (Player player : allPlayers) {
            // If square position (which should be the same as the position of the current player on the square) is less
            // than another player's position (i.e. the player is further along in the race), then racePosition is incremented
            // by 1
            if (position < player.getPosition()) {
                racePosition++;
            }
        }
        return racePosition;
    }

    /**
     * This method would decrement the player's lettuce count by 1 and give the player carrots 10 * racePosition of the player.
     * This method would be used when a player stay's a lettuce square
     */
    private void chewLettuce(int carrotGain) {
        // Remove 1 lettuce from the player
        players.get(0).removeLettuce();

        // Adds 10 * racePosition to the currentPlayer
        players.get(0).addCarrots(carrotGain);

    }

    /**
     * Override the superclass method. This method has an addition of resetting the turnCounter field back to 0 when removing the player
     * from the square
     * @param player Player object passed in
     */
    public void removePlayer(Player player) {
        turnCounter = 0;
        players.remove(player);
    }
}
