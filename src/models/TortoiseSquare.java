package models;

import java.util.ArrayList;

/**
 *
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.08
 */
public class TortoiseSquare extends Square {
    
    public TortoiseSquare(String name, int position) {
        super(name, position);
    }
    
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
    
    @Override
    public String applyRule(ArrayList<Player> allPlayers) {
        Player player = players.get(0);
        
        int squaresMoved = player.getPreviousPosition() - position;
        int carrots = squaresMoved * 10;
        player.addCarrots(carrots);
        
        return "You moved back " + squaresMoved + " squares, you gained " + carrots + " carrots!";
    }
}
