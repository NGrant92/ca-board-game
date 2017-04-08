package models;

/**
 * Created by keela on 06/04/2017.
 */
public class TortoiseSquare extends Square {
    
    public TortoiseSquare(String name, int position) {
        super(name, position);
    }
    
    @Override
    public boolean isAvailable() {
        if (players.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
