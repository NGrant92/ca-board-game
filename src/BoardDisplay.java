/*
 * Board Display class used to make a graphical display of the board so the Players can use it as a reference
 * when deciding on their next move.
 * 
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 2017.03.22
 */
public class BoardDisplay 
{
	//Array that holds the name of the tiles and in the correct order
	String tiles[] = {"Start", "Hare", "Carrots", "Hare", "3", "Carrots", "Hare", "156", "2", "4", "Lettuce", "Tortoise", "3", 
			"Carrots", "Hare", "Tortoise", "156", "2", "4", "Tortoise", "3", "Carrots", "Lettuce", "2", "Tortoise", "Hare", 
			"Carrots", "4", "3", "2", "Tortoise", "Hare", "156", "Carrots", "Hare", "2", "3", "Tortoise", "Carrots", "Hare", 
			"Carrots", "2", "Lettuce", "Tortoise", "3", "4", "Hare", "2", "156", "Carrots", "Tortoise", "Hare", "3", "2", "4", 
			"Carrots", "Tortoise", "Lettuce", "Hare", "Carrots", "156", "Carrots", "Hare", "Carrots", "Finish"};
	
	public static void main(String[] args)
	{
		//calls the BoardDisplay method when class is run
		new BoardDisplay();
	}
	
	/*
	 * Prints the board to be displayed to the user.
	 * 
	 * A 'box' is printed with the tile name
	 * A loop is used to run through the array
	 * Using the toString method and the for loop avoids verbose coding
	 * and avoids me having to write out 65 boxes
	 */
	public BoardDisplay()
	{
		for(int i = 0 ; i < tiles.length ; i++) //loop stops when i reaches the length of the array
		{
			System.out.println(toString(i));//this prints out the 'box' in the toString method and uses i
											//as to number each tile and pull the string from the array list
		}
	}
	/*
	 * Requires an integer argument for the method to be called
	 * @param if this adds a 0 to the number if i is less than 10
	 * @param return returns the 'box' style with text inside the box
	 * 		  this text is called from the tiles array
	 */
	public String toString(int i)
	{
		String index = "";
		String spaces = "";
		String textLine = "| "+ index + ": "+ tiles[i] +"|\n";
		
		if(i <= 9)
		{
			index = "0" + i;
		}
		else
		{
			index = ""+ i;
		}
		return ("+-----------------------+\n"
				+ "| "+ index + ": "+ tiles[i] +" \t\t|\n"
				+ "|\t\t\t|\n"
				+ "|\t\t\t|\n"
				+ "|\t\t\t|\n"
				+ "+-----------------------+");
	}
	
	/*
	 * @return returns the string in a specified index in the tiles array
	 */
	public String getTile(int i)
	{
		return tiles[i];
	}
}
