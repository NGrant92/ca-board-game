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
		position = 1; // Assuming start is at position 1
		noOfCarrots = 65; // All players begin with 65 carrots
		noOfLettuce = 3; // All players begin with 3 carrots
	}

	/**
	 * Main Method just to test that all setters and getters work correctly.
	 * Comment out/Remove this method when integrating to other classes
	 * Note: remember to remove import statement of Scanner class also
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		Player player1 = new Player("test"); // Create new Player object with stored player name
		System.out.println(player1.toString()); // Call toString method

		player1.setPlayerName("testSetName"); // Set player1 name to newName
		System.out.println("Player newName is: " + player1.getPlayerName()); // Print out player1's new name - test getPlayerName

		player1.setNoOfCarrots(100); // Set new carrot amount
		System.out.println("New carrot amount is: " + player1.getNoOfCarrots()); // print out new carrot amount - test getNoOfCarrots

		player1.setNoOfLettuce(2); // Set new lettuce amount
		System.out.println("New lettuce amount is: " + player1.getNoOfLettuce()); // print out new lettuce amount - test getNoOfLettuce

		player1.setPosition(10); // Set new position
		System.out.println("New player position is : " + player1.getPosition()); // print out new position - test getPosition

		player1.setSkipTurn(true); // Set new flag state
		System.out.println("New Skipturn state: " + player1.getSkipTurn()); // Print out new flag state - test getSkipTurn

		player1.addCarrots(20); // add 20 carrots using addCarrots Method
		System.out.println("Test addcarrot(20) - count:" + player1.getNoOfCarrots());

		player1.removeCarrots(50); // remove 50 carrots using removeCarrots Method
		System.out.println("Test removecarrot(50) - count: " + player1.getNoOfCarrots());

		player1.removeLettuce(); // Decrements lettuce count by 1
		System.out.println("Test removelettuce - count: " + player1.getNoOfLettuce());

		System.out.println(player1.toString()); // Final Test using toString method
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
