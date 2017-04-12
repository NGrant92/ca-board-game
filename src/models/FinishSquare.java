/*This class is a subclass of square and it allows the player to land on the finish square
 * in my CanmoveHere method I have overwrote the rules of this method 
 */
package models;

import java.util.ArrayList;

public class FinishSquare extends Square {


	public FinishSquare(String name, int position) {
		super(name, position);
		// TODO Auto-generated constructor stub
	}

	/*   This method will allow the players to see who finished first second and so on depending 
	 * on how many players are playing .
	 * It will pass the ArrayList and who ever is first in the Player ArrayList will be first and so on 
	 */
	public void printStandings(){
		for (int i=0; i<players.size();i++){
		}
	}
	
/*
 * For a player to  be able to finish the game they need to have gotten rid off all 
 * their lettuce cards and  They can only have a certain amount of carrots depending on what place they are in the game.
 * dependent on their place in the game they are only allowed have a certain number of carrots to finish 
 */
	@Override
	public boolean canMoveHere(Player player){	
		int maxCarrots = players.size() * 10 + (10);
		if(player.getNoOfLettuce() == 0 && player.getNoOfCarrots() <= maxCarrots){   
			  return true;
		}
		else{				
			return false;
		}
	}
}
	

	




