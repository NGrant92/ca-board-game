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
    private ArrayList<Player> allPlayers;

    public PostionSquare(String name, int position) {
        super(name, position);
        this.allPlayers = allPlayers;
    }

    @Override
    public String applyRule(ArrayList<Player> allPlayers){
        //This is pulling the Player that is currently on this square and putting it into a variable
        Player currentPlayer = players.get(0);
        //If I use a method more than once, it's being given a variable name
        int checkPosition = checkPosition(allPlayers, currentPlayer);

        //This checks if there are any carrots to give to the player
        //If there are 0 carrots to give then the method will not be called
        if(checkPosition > 0){
            currentPlayer.setPendingBalance(checkPosition);
        }

        return "You have received " + checkPosition + " carrots!";
    }

    //When they start their turn on a positionTile this method will check if they will recieve the carrots or not
    //checkPoisiton is called from the Gamecontroller who inputs Player arrayList, currentPlayer
    public int checkPosition(ArrayList<Player> allPlayers, Player currentPlayer){
        //Square name is converted into an integer
        int tileNum = Integer.parseInt(name);
        int playerPosition = getRacePosition(allPlayers, currentPlayer);

        //One particular tile allows you be 1st, 5th or 6th
        if(tileNum == 156){
            if(playerPosition == 1 || playerPosition == 5 || playerPosition == 6){
                //Seeing as the amount of potential carrots depends on the player's position in the race
                //we use the player's position to calculate the amount of carrots to be received
                recievedCarrots = playerPosition * 10;
            }
            //If player's race position doesn't match the required number then recievedCarrots will not change from 0
            return recievedCarrots;
        }
        else {
            //Testing if the player's position in race matches the required position returns the appropriate carrots
            if (tileNum == playerPosition) {
                //Here we use the tileNum to calculate the amount of carrots to be received
                //No particular reason to use tileNum over playerPosition, just because I can
                recievedCarrots = tileNum * 10;
            }
            //If player's race position doesn't match the required number then recievedCarrots will not change from 0
            return recievedCarrots;
        }
    }


    /**
     * @author Kevin
     * Method to return the player position in race. Possibly can be used in number square or lettuce square
     * calculation.
     */
    public int getRacePosition(ArrayList<Player> allPlayers, Player currentPlayer) {

        // Local temporary store for playerPositionInRace
        int racePosition = 1;

        // Check each player position in players array, and increment playerPosition by 1 if the player position
        // is less than currentPlayerPositionInRace
        for (int i = 0; i < allPlayers.size(); i++) {
            if (currentPlayer.getPosition() < allPlayers.get(i).getPosition()) {
                racePosition++;
            }
        }
        return racePosition;
    }

    //This will print to display how much carrots they have recieved, if any.
    public String toString(){
        return "You have recieved " + recievedCarrots + " Carrots";
    }

}
