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
 * @version 2017.03.22
 *
 * TODO Add a addCarrots and removeCarrots method
 * TODO Remove main method
 * TODO Add a remove lettuce method
 */
public class Player
{
	private String playerName;
	private int position;
	private int noOfCarrots;
	private int noOfLettuce;
	private boolean skipTurn;

	/**
	 * Constructor for objects of class Player. With this constructor the position instance field is set to 1 (Start),
	 * the noOfCarrots instance field is set to 65, the noOfLettuce instance field is set to 3, and the skipTurn boolean is
	 * automatically set to false.
	 *
	 * @ param playerName The Name of the player (No validation is done - so can be of any length)
	 */
	public Player(String playerName)
	{
		this.playerName = playerName;
		position = 0; // Assuming start is at position 0
		noOfCarrots = 65; // All players begin with 64 carrots
		noOfLettuce = 3; // All players begin with 3 carrots
	}

	//================================
	// Getters for the Player Class
	//=================================

	/**
	 *Returns the name of the player
	 *
	 * @return The name of the player
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * Return the position of the player
	 *
	 * @return The position of the player
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * Return the number of carrots the player has
	 *
	 * @return The number of carrots the player has
	 */
	public int getNoOfCarrots()
	{
		return noOfCarrots;
	}

	/**
	 * Return the number of Lettuce the player has
	 *
	 * @return The number of Lettuce the player has
	 */
	public int getNoOfLettuce()
	{
		return noOfLettuce;
	}

	/**
	 * Returns the state of the skipTurn flag
	 *
	 * @return The state of the skipTurn flag
	 */
	public boolean getSkipTurn()
	{
		return skipTurn;
	}

	//================================
	// Setters for the Player Class
	//=================================

	/**
	 * Updates the playerName field
	 *
	 * @param playerName No validation is performed on the playerName field
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * Updates the position field
	 *
	 * @param position No validation is performed on the position field yet
	 */
	public void setPosition(int position)
	{
		this.position = position;
	}

	/**
	 * Updates the noOfCarrots field
	 *
	 * @param noOfCarrots No validation is performed on the noOfCarrots field
	 */
	public void setNoOfCarrots(int noOfCarrots)
	{
		this.noOfCarrots = noOfCarrots;
	}

	/**
	 * Updates the noOfLettuce field
	 *
	 * @param noOfLettuce No validation is performed on the noOfLettuce field
	 */
	public void setNoOfLettuce(int noOfLettuce)
	{
		this.noOfLettuce = noOfLettuce;
	}

	/**
	 * Updates the skipTurn flag field
	 *
	 * @param skipTurn No validation is performed on the skipTurn field
	 */
	public void setSkipTurn(boolean skipTurn)
	{
		this.skipTurn = skipTurn;
	}

	/**#
	 * Returns a human readable String interpretation of the player object state
	 *
	 * @return A string version of the Player object. The string returned is similar to the structure:
	 *
	 *			 Player: John 		Position: 1		No of Carrot: 65 		No of Lettuce: 3	Skip Turn: false
	 *
	 */
	public String toString()
	{
		return "Player: " + playerName + "\tPosition: " + getPosition() + "\tNo of Carrots: " + getNoOfCarrots()
				+ "\tNo of Lettuce: " + getNoOfLettuce() + "\tSkip Turn: " + getSkipTurn();

	}

	/**
	 * Method to add carrots. Used for when carrots are obtained from say number square or carrot patch
	 *
	 * @param amount Amount of carrots to add
	 */
	public void addCarrots(int amount)
	{
		noOfCarrots += amount;
	}


	/**
	 * Method to remove carrots. Used for when carrots are removed for say when player moves
	 *
	 * @param amount Amount of carrots to remove
	 */
	public void removeCarrots(int amount)
	{
		noOfCarrots -= amount;
	}

	/**
	 * Method to remove lettuce. Lettuce is only decremented by 1. Used for when player lands on lettuce square
	 */
	public void removeLettuce()
	{
		noOfLettuce--;
	}
}
