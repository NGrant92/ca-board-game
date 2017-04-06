package models;
import board.*;
import controllers.*;

import java.util.ArrayList;

/**
 * Created by Niall on 03/04/2017.
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.03
 *
 * A position tile has a certain number(between 1 - 6) associated with it. If a player lands on that tile
 * and starts their next turn in the same position in the race as the specific number then they are rewarded
 * with (position x 10) carrots.
 * Example: If the player landed a tile with the number 4 they must start their next turn as 4th in the race
 *          and will recieve 40 carrots.
 */
public class PostionSquare extends Square {

    int recievedCarrots = 0;

    public PostionSquare(String name, int position) {
        super(name, position);
    }

    //When they start their turn on a positionTile this method will check if they will recieve the carrots or not
    //checkPoisiton is called from the Gamecontroller who inputs Player arrayList, currentPlayer
    public int checkPosition(ArrayList<Player> players, Player currentPlayer){
        //Square name is converted into an integer
        int tileNum = Integer.parseInt(name);
        int playerPosition = getPlayerPositionInRace(players, currentPlayer);

        //One particular tile allows you be 1st, 5th or 6th
        if(tileNum == 156){
            if(playerPosition == 1 || playerPosition == 5 || playerPosition == 6){
                //Seeing as the amount of potential carrots depends on the player's position in the race
                //we use the player's position to calculate the amount of carrots
                recievedCarrots = playerPosition * 10;
            }
            return recievedCarrots;
        }
        else {
            //Testing if the player's position in race matches the required position
            //returns the appropriate carrots
            if (tileNum == playerPosition) {
                recievedCarrots = tileNum * 10;
            }
            return recievedCarrots;
        }
    }

    /**
     * @author Kevin
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     */
    public int getPlayerPositionInRace(ArrayList<Player> players, Player player) {

        // local variable to store the players current position - not really need
        int currentPlayerPositionOnBoard = player.getPosition();
        // Local temporary store for playerPositionInRace
        int playerPositionInRace = 1;

        // Check each player position in players array, and increment playerPosition by 1 if the player position
        // is less than currentPlayerPositionInRace
        for (int i = 0; i < players.size(); i++) {
            if (currentPlayerPositionOnBoard < players.get(i).getPosition()) {
                playerPositionInRace++;
            }
        }
        return playerPositionInRace;
    }

    //This will print to display how much carrots they have recieved, if any.
    public String toString(){
        return "You have recieved " + recievedCarrots + " Carrots";
    }

}
