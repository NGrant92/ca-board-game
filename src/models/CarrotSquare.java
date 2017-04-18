package models;

import java.util.ArrayList;

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

    /**
     * Returns whether the square allows the player to stay for more than one turn.
     * Carrot squares allows the player to stay indefinitely in exchange for not moving and adding/removing 10 carrots
     * @return Boolean value on whether the player can stay on the square - always return true for a carrot square
     */
    @Override
    public boolean canStay() {
        return true;
    }

    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
//        String str = "";
//        if(check(players.get(0))) {
//            str = "If you choose to stay on carrot square, you can choose to gain or remove 10 carrots!";
//        }
        return "If you choose to stay on carrot square, you can choose to gain or remove 10 carrots!";
    }
}
