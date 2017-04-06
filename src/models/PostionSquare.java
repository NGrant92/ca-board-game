package models;
import board.*;
import controllers.*;

import java.util.ArrayList;

/**
 * Created by Niall on 03/04/2017.
 * @Author Niall G
 *
 * A position tile has a certain number(between 1 - 6) associated with it. If a player lands on that tile
 * and starts their next turn in the same position in the race as the specific number then they are rewarded
 * with (position x 10) carrots.
 * Example: If the player landed a tile with the number 4 they must start their next turn as 4th in the race
 *          and will recieve 40 carrots.
 */
public class PostionSquare extends Square {

    int recievedCarrots = 0;
    int playerIndex = 0;
    int tilePosition = 0;

    public PostionSquare(String name, int position) {
        super(name, position);
    }

    //When they start their turn on a positionTile this method will check if
    //they will recieve the carrots or not
    public int checkPosition(ArrayList<Player> players, Player currentPlayer){
            if(GameController.getPlayerPositionInRace() == tilePosition) {
                recievedCarrots = tilePosition * 10;
            }
        return recievedCarrots;
    }

    //This will print to display how much carrots they have recieved, if any.
    public String toString(){
        return "You have recieved " + recievedCarrots + " Carrots";
    }

}
