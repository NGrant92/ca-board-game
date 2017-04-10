package models;

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
     * @param player Player object that is passed in to get play information
     */
    public void applyRule(Player player) {
        player.removeLettuce();
        player.addCarrots(getPlayerPositionInRace(player) * 10);
    }

    /**
     * Overrider the superclass isAvailable method with inclusion of check for more than one lettuce and previous player
     * position
     * @param player Player object to be passed in to check is square available for player
     * @return Boolean value of the availability of the square
     */
    //@Override
    // TODO: Doesn't override the superclass method, because this method takes in a player object for checks
    public boolean isAvailable(Player player) {
        if(players.size() == 0 && player.getNoOfLettuce() > 0 && player.getPreviousPosition() != player.getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that returns whether the player can stay on the current square
     * @param player Player object that is passed in to get player information
     * @return Boolean value for whether the player can stay
     */
    public boolean canStay(Player player) {
        if (player.getPreviousPosition() != player.getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     */
    private int getPlayerPositionInRace(Player player) {
        // local variable to store the players current position - not really need
        int currentPlayerPositionOnBoard = player.getPosition();
        // Local temporary store for playerPositionInRace - Player begins as in 1st position
        int playerPositionInRace = 1;

        // Compares the currentPlayerPositionOnBoard to each playerPosition in the players array. If currentPlayerPositionOnBoard
        // is less than playerPosition, the playerPositionInRace is incremented by 1
        // TODO: Method is checking the players array on the square, not the tile, so shouldn't work correctly
        for (int i = 0; i < players.size(); i++) {
            if (currentPlayerPositionOnBoard < players.get(i).getPosition()) {
                playerPositionInRace++;
            }
        }
        return playerPositionInRace;
    }
}
