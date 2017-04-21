/*This class is a subclass of square and it allows the player to land on the finish square
 * in my CanmoveHere method I have overwrote the rules of this method 
 */
package models;

import java.util.ArrayList;
import static utils.GameHelperMethods.*;

/*   This class will allow the players to see who finished first second and so on depending
 * on how many players are playing 
 * this will be done through the get players method which is in the super class of this sub class 
 * as this is already done in the superclass it does not need to be written here as well
 */

public class FinishSquare extends Square {


	public FinishSquare(String name, int position) {
		super(name, position);
	}


	/*
	 * For a player to  be able to finish the game they need to have gotten rid off all 
	 * their lettuce cards.
	 * Dependent on their place in the game they are only allowed have 
	 * a certain number of carrots to finish 
	 * the player can only move here if they have ten times their position in the game.
	 * this method also checks how many carrots the need to move to the finish square 
	 * And takes this into account 
	 */

	@Override
	public boolean canMoveHere(Player player){	
		int maxCarrots = players.size() * 10 + (10);
		if(player.getNoOfLettuce() == 0 && player.getNoOfCarrots() -carrotsRequired(position- player.getPosition()) <= maxCarrots){   
			return true;
		}
		else{				
			return false;
		}
	}
}








