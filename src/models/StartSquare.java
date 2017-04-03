package models;

/**
 * Created by keela on 01/04/2017.
 */
public class StartSquare extends Square {
    
    public StartSquare(String name, int position) {
        super(name, position);
    }
    
    @Override
    public boolean isAvailable() {
        return true;
    }
}
