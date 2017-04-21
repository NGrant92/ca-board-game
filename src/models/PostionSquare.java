package models;
import utils.GameHelperMethods;

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

    private int counter;
    private int recievedCarrots = 0;
    private ArrayList<Player> allPlayers;

    /**
     * Constructor for the Position Square Object
     *
     * @param name     The name of the square
     * @param position The number of the square on the board
     */
    public PostionSquare(String name, int position) {
        super(name, position);
    }

    /**
     * Overrides the superclass method with rules that is applied to the player on the position square.
     *
     * @param allPlayers ArrayList of players in the game
     * @return Return a String message of the rules applied
     */
    @Override
    public String applyRule(ArrayList<Player> allPlayers){
        //This is pulling the Player that is currently on this square and putting it into a variable
        Player currentPlayer = players.get(0);

        //When the player lands on a Position Tile the rules will be called, but the rule needs to be applied at the
        //start of their next turn. The counter ensures the rule is applied only on the start of their next turn
        counter++;
        //The message that will be returned to the gamecontroller which will then be printed on screen
        String message = "";

        switch (counter){
            //When currentPlayer lands on the square this is what is returned
            case 1:
                message = "At the start of your next turn your position must match the number on the square\n";
                break;
            //Position is checked at the start of their next turn
            case 2:
                //If I use a method more than once, it's being given a variable name
                int checkPosition = checkPosition(allPlayers, currentPlayer);
                //This checks if there are any carrots to give to the player
                //If there are 0 carrots to give then the method will not be called
                if(checkPosition > 0){
                    currentPlayer.addCarrots(checkPosition);
                }
                message =  "You have received " + checkPosition + " carrots!";
                counter = 0;
                break;
        }
        return message;
    }

    /**
     * When they start their turn on a positionTile this method will check if they will recieve the carrots or not
     * checkPoisiton is called from the Gamecontroller who inputs Player arrayList, currentPlayer
     *
     * @param allPlayers ArrayList of players in the game
     * @param currentPlayer Player currently on the position square
     * @return returns an int that determines how many carrots is given to each player
     */
    public int checkPosition(ArrayList<Player> allPlayers, Player currentPlayer){
        //Square name is converted into an integer
        int tileNum = Integer.parseInt(name);
        int playerPosition = GameHelperMethods.getRacePosition(allPlayers, currentPlayer.getPosition());

        //One particular tile allows you be 1st, 5th or 6th
        if(tileNum == 156){
            if(playerPosition == 1 || playerPosition == 5 || playerPosition == 6){
                //Seeing as the amount of potential carrots depends on the player's position in the race
                //we use the player's position to calculate the amount of carrots to be received
                recievedCarrots = playerPosition * 10;
            }
            else{
                recievedCarrots = 0;
            }
            //If player's race position doesn't match the required number then recievedCarrots will not change from 0
            return recievedCarrots;
        }
        else {
            //Testing if the player's position in race matches the required position returns the appropriate carrots
            if (tileNum == playerPosition) {
                //Here we use the tileNum to calculate the amount of carrots to be received
                //No particular reason to use tileNum over playerPosition, just because I can
                recievedCarrots = playerPosition * 10;
            }
            else{
                recievedCarrots = 0;
            }
            //If player's race position doesn't match the required number then recievedCarrots will not change from 0
            return recievedCarrots;
        }
    }
}
