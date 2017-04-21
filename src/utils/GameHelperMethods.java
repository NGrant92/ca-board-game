package utils;

import models.Player;

import java.util.ArrayList;

/**
 * The GameHelperMethods class contains the helper methods, such as calculation methods, that can be used across
 * different classes to reduce code duplication between classes.
 *
 * Created by kevin on 20/04/2017.
 */

public class GameHelperMethods {
    /**
     * Calculates the carrots required to move a distance
     * <p>
     * The number of carrots required is calculated using a triangular number sequence
     * formula. The alternative was to use a for loop to add every number
     * up to the distance required. This has been commented out.
     *
     * @param distance The distance that the user wishes to move
     * @return The number of carrots required to move the inputted distance
     */
    public static int carrotsRequired(int distance) {
        /* Alternative way to find the carrots required
		* int carrots = 0;
		*  for (int index = 1; index <= distance; index++)
		*  {
		*   	carrots = carrots + index;
		*  }
		*  return carrots;
		*/
        return distance * (distance + 1) / 2;
    }


    /**
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     *
     * @param allPlayers ArrayList of all players in the game to calculate the race position for the current player
     * @param position Integer used to compare position of players
     * @return The race position of the player
     */
    public static int getRacePosition(ArrayList<Player> allPlayers, int position) {
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
}
