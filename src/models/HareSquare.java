package models;

import java.lang.Math;
import controllers.GameController;

import java.util.ArrayList;

/**
 * Created by kevin on 06/04/2017.
 * Edited by Niall on 08/04/2017
 * A class used to store the methods that represent the cards from the hare deck
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

    //=========================
    //10 CARROTS TO EACH PLAYER
    //=========================
    //A method used to give each player 10 carrots
    //If the currentPlayer can't afford it then 5 carrots each
    //If they can't afford that then 1 carrot each
    //The players also have to option of discarding the carrots
    public void tenCarrotsPerPlayer(ArrayList<Player> players, Player currentPlayer){
        //players.size() - 1 gets used multiple times so i put it into a variable
        //-1 to exclude the currentPlayer
        int playersSize = players.size() - 1;
        //currentPlayer.getNoOfCarrots() is tested multiple times so it's added into a variable
        int currentPlayerCarrots = currentPlayer.getNoOfCarrots();
        //this will hold the amount of carrots required to be given to each player
        int carrotsToGive = 0;

        //testing to see if currentPlayer has enough carrots to give 10 to each player
        if(currentPlayerCarrots >= playersSize*10){
            carrotsToGive = 10;
        }
        //if they dont have enough for 10 carrots per player then it checks
        //if they have enough for 5 carrots per player
        else if(currentPlayerCarrots >= playersSize*5){
            carrotsToGive = 5;
        }
        //if both fail then they must give 1 carrot to each player
        else{
            carrotsToGive = 1;
        }

        //a for loop to add the carrotsToGive to each players pending balance
        for(int i = 0 ; i < players.size() ; i++){
            //Check to make sure the player doesn't give themself carrots. Only one player can be on one square
            //at a time so if currentPlayer position == players(i) position then it skips that player
            if(players.get(i).getPosition() != currentPlayer.getPosition()){
                players.get(i).addPendingBalance(carrotsToGive);
            }
        }
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

    //=================
    //LAST TURN COSTS 0
    //=================
    //A method to return the players previously expended amount of carrots
    //To do this the player's previous position is deducted from their current position
    //That result is put into a formula that calculates the required carrots for moving that distance
    // which will add the amount to the player's pendingBalance
    public void lastTurnFree(Player player){

        //this subtracts player's previous position from their current position and feeds it into a variable name
        int distance = (player.getPosition() - player.getPreviousPosition());

        //int distance is used to calculate the amount of carrots the players previous move cost them
        //and sends it into their pending balance
        player.setPendingBalance(distance*(distance + 1)/2);
    }

    //=================
    //SHUFFLE CARD DECK
    //=================
    //The player must shuffle the card deck and recieve 1 carrot from each player
    public void shuffleCards(ArrayList<Player> players, Player currentPlayer, HareDeck hareDeck){

        //hareDeck is passed in and shuffled
        hareDeck.shuffle();

        //players Array is passed in and used to determine how many carrots they are given. The -1  is there
        //because the currentPlayer is also in the players array and you only receive carrots from other players
        currentPlayer.setPendingBalance(players.size() - 1);
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
    //This method is for halving the players stash of carrots. setHalfCarrots() returns the required int
    //and halfCarrots() inputs it into the player's setPendingBalance()
    public void halfCarrots(Player player){

        //this method sets the pending balance to the amount of carrots
        //it calls setHalfCarrots() and passing in the players current number of carrots
        //before the sucker loses half his supply
        //TODO Check if a minus number needs to be input
        //change to setNoofcarrots
        player.setPendingBalance(setHalfCarrots(player.getNoOfCarrots()));
    }

    public int setHalfCarrots(int carrots) {

        //a method that divides the player's carrots in half and rounds up the answer if answer results in X.5
        //eg: 65 / 2 = 32.5, this will make it 33
        return ((int) Math.ceil(carrots / 2.0));
    }

}
