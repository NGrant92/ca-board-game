package models;

/**
 * This class will be used to hold and process Player information
 * It will hold the player's Name, Carrots, Lettuce and Token
 *
 * It will also have accessors and mutators for all 4 variables
 * which will be accessible to other classes
 *
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.04.03
 *
 */
public class Player
{
	private String playerName;
	private int position;
	private int previousPosition;
	private int noOfCarrots;
	private int noOfLettuce;
	private int pendingBalance;
	private boolean skipTurn;

	/**
	 * Constructor for objects of class Player. With this constructor the position instance field is set to 1 (Start),
	 * the noOfCarrots instance field is set to 65, the noOfLettuce instance field is set to 3, and the skipTurn boolean is
	 * automatically set to false.
	 *
	 * @ param playerName The Name of the player (No validation is done - so can be of any length)
	 */
	public Player(String playerName) {
		this.playerName = playerName;
		position = 0;
		previousPosition = 0;
		noOfCarrots = 65;
		noOfLettuce = 3;
		pendingBalance = 0;

	}

	//================================
	// Getters for the Player Class
	//=================================

	/**
	 *Returns the name of the player
	 *
	 * @return The name of the player
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Return the position of the player
	 *
	 * @return The position of the player
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Return the number of carrots the player has
	 *
	 * @return The number of carrots the player has
	 */
	public int getNoOfCarrots() {
		return noOfCarrots;
	}

	/**
	 * Return the number of Lettuce the player has
	 *
	 * @return The number of Lettuce the player has
	 */
	public int getNoOfLettuce() {
		return noOfLettuce;
	}

	/**
	 * Returns the state of the skipTurn flag
	 *
	 * @return The state of the skipTurn flag
	 */
	public boolean getSkipTurn() {
		return skipTurn;
	}

    /**
     * Returns the players previous position on board
     * @return The player's previous position on board
     */
	public int getPreviousPosition() {
		return previousPosition;
	}

    /**
     * Returns the pending balance for the player
     *
     * @return The pending balance for the player
     */
	public int getPendingBalance() {
		return pendingBalance;
	}


	//================================
	// Setters for the Player Class
	//=================================

	/**
	 * Updates the playerName field
	 *
	 * @param playerName No validation is performed on the playerName field
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Updates the position field
	 *
	 * @param position No validation is performed on the position field yet
	 */
	public void setPosition(int position) {
		previousPosition = this.position;
		this.position = position;
	}

	/**
	 * Updates the noOfCarrots field
	 *
	 * @param noOfCarrots No validation is performed on the noOfCarrots field
	 */
	public void setNoOfCarrots(int noOfCarrots) {
		this.noOfCarrots = noOfCarrots;
	}

	/**
	 * Updates the noOfLettuce field
	 *
	 * @param noOfLettuce No validation is performed on the noOfLettuce field
	 */
	public void setNoOfLettuce(int noOfLettuce) {
		this.noOfLettuce = noOfLettuce;
	}

	/**
	 * Updates the skipTurn flag field
	 *
	 * @param skipTurn No validation is performed on the skipTurn field
	 */
	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}

	/**#
	 * Returns a human readable String interpretation of the player object state
	 *
	 * @return A string version of the Player object. The string returned is similar to the structure:
	 *
	 *			 Player: John 		Position: 1		No of Carrot: 65 		No of Lettuce: 3
	 *
	 */
	public String toString() {
		return "Player: " + playerName + "\tPosition: " + getPosition() + "\tNo of Carrots: " + getNoOfCarrots()
				+ "\tNo of Lettuce: " + getNoOfLettuce();

	}

	/**
	 * Method to add carrots. Used for when carrots are obtained from say number square or carrot patch
	 *
	 * @param amount Amount of carrots to add
	 */
	public void addCarrots(int amount) {
		noOfCarrots += amount;
	}


	/**
	 * Method to remove carrots. Used for when carrots are removed for say when player moves
	 *
	 * @param amount Amount of carrots to remove
	 */
	public void removeCarrots(int amount) {
		noOfCarrots -= amount;
	}

	/**
	 * Method to remove lettuce. Lettuce is only decremented by 1. Used for when player lands on lettuce square
	 */
	public void removeLettuce() {
		noOfLettuce--;
	}

    /**
     * Sets the previous position of the player
     * @param previousPosition The previous position of the player
     */
	public void setPreviousPosition(int previousPosition) {
		this.previousPosition = previousPosition;
	}

    /**
     * Sets the pending balance field for the player
     * @param pendingBalance The pending balance for the player
     */
	public void setPendingBalance(int pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	/**
	 * Method to add to pendingBalance field
	 * @param amount Amount to add to pendingBalance field
	 */
	public void addPendingBalance (int amount) {
		pendingBalance += amount;
	}

	/**
	 * Method to reset pendingBalance field to 0;
	 */
	public void resetPendingBalance() {
		pendingBalance = 0;
	}
}
