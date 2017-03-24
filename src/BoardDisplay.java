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
	 * which is used to select the index of the array
	 */
	public String toString(int i)
	{
		/*
		 * if statement checks if "i" is below 10 if i < 10
		 * it will add a 0 to the number,
		 * eg: 1 will become 01.
		 */
		String index = "";
		
		if(i <= 9)
		{
			index = "0" + i;
		}
		else
		{
			index = ""+ i;
		}
		
		/*
		 * The left and right sides of the box are separated by a number of spaces.
		 * The length of the line that has the tile number and type will vary 
		 * due to different words having different lengths.
		 * 
		 * I have coded it so the length of the text is measured against a specific number(13)
		 * and that difference will truncate a string full of 13 spaces down to the
		 * required length
		 */
		String spaces = "              "; //a string containing 13 spaces which will be truncated later
		String textLine = index + ": "+ tiles[i];//the total length of this string will help
												 //decide the required spaces to be added

		//the text line and the required spaces are added to the return statement
		return ("+--------------+\n"
				//spaces.substring(0, length difference)
				+ "| "+ textLine + spaces.substring(0, ((spaces.length() - textLine.length()) - 1)) + "|\n"  
				+ "|" + spaces + "|\n" 			  
				+ "|" + spaces + "|\n"
				+ "+--------------+");
	}
	
	/*
	 * @return returns the string in a specified index in the tiles array
	 */
	public String getTile(int i)
	{
		return tiles[i];
	}
}
