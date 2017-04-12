package models;

/**
 * Created by keela on 01/04/2017.
 * Edited by Kevin on 06/04/2017.
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.03
 */
public class CarrotSquare extends Square {

    /**
     * Constructor for the CarrotSquare Object. A player on a carrot square can receive or remove 10 carrots in exchange
     * for not moving for the turn.
     * @param name The name of the square
     * @param position The number of the square on the board
     */
    public CarrotSquare(String name, int position) {
        super(name, position);
    }

//    /**
//     * Set the pending balance for the player to 10. Game controller would will allow the player to accept the 10
//     * carrots or remove the 10 carrots to their balance.
//     * @param player Player object that is passed in to set the pendingBalance field for the player
//     */
//    public void setPendingBalance(Player player) {
//        player.setPendingBalance(10);
//    }

    /**
     * Returns whether the square allows the player to stay for more than one turn.
     * Carrot squares allows the player to stay indefinitely in exchange for not moving and adding/removing 10 carrots
     * @return Boolean value on whether the player can stay on the square - always return true for a carrot square
     */
    public boolean canStay() {
        return true;
    }

    /** Check to see is player stayed on the carrot square for the turn
     *
     * @param player Player object passed in to get player information
     */
    public boolean check(Player player) {
        if (player.getPreviousPosition() == player.getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Apply rule method that is run each time the before the player moves to another tile, choose to stay or move backwards
     * in the game controller
     */

    public String applyRule() {
        String str = "";
        if(check(players.get(0))) {
            str = "Would you like to stay on carrot square? (Y/N)";
        }
        return str;
    }

    /**
     * Returns a string of player's carrot balance
     * @return String of player's carrot balance
     */
    public String toString() {
        return "You now have " + players.get(0).getNoOfCarrots() + "carrots";
    }
}
