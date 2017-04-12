package models;

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
        if (player.getPosition() < position) {
            if (players.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
