package models;

/**
 * Created by kevin on 06/04/2017.
 * A class used to store the methods that represent the cards from the hare deck
 *
 */
public class HareSquare extends Square {

    public HareSquare(String name, int position) {
        super(name, position);
    }

    //====================
    //SHOW US YOUR CARROTS
    //====================
    //A simple enough method to return the players number of carrots
    //TODO how will they be printed to screen?
    public int showCarrots(Player player){

        return player.getNoOfCarrots();
    }

    //======================
    //10 CARROTS PER LETTUCE
    //======================
    //If this card it pulled the player recieves 10 Carrots per Lettuce. If player has no lettuce they skip a turn.
    public void tenCarrotsPerLettuce(Player player){

        //player.getNoOfLettuce() is used twice to it's given a variable name
        int lettuceNum = player.getNoOfLettuce();

        //Checks if player has at least 1 lettuce
        if(lettuceNum > 0){
            //inputs addCarrots into the player pendingBlance
            player.setPendingBalance(lettuceNum * 10);
        }
        //if the player has 0 lettuce it will raise the flag for setSkipTurn()
        else{
            player.setSkipTurn(true);
        }
    }



    //==================
    //BACK TO 65 CARROTS
    //==================
    //A simple enough method to return the player to 65 carrots
    //TODO display to screen that their carrots were reset
    public void resetCarrots(Player player){

        player.setNoOfCarrots(65);
    }

    //=================
    //HALF YOUR CARROTS
    //=================
    //This will be the method called by the Execute Rule class. Which will pass in the required player class
    public void halfCarrots(Player player){

        //this method sets the pending balance to the amount of carrots
        //it calls setHalfCarrots() and passing in the players current number of carrots
        //before the sucker loses half his supply
        //TODO Check if a minus number needs to be input
        player.setPendingBalance(setHalfCarrots(player.getNoOfCarrots()));
    }

    public int setHalfCarrots(int carrots){

        //simple arguement to have the inputted carrots
        int halfCarrots = carrots / 2;

        //Checks if when the player's carrots are halved if there is a remainder
        //if there is a remainder it will round up the answer
        if(halfCarrots % 2 != 0) {
            //the below method adds 1 to halfCarrots() because it is rounded down if halfCarrots() = x.5
            //the rules specify if halving an odd number you should round up
            return (halfCarrots + 1);
        }
        //returns halfCarrots() without any changes
        else{
            return halfCarrots;
        }
    }

}
