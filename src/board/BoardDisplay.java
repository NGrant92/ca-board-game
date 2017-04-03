package board;

/*
 * board.Board Display class used to make a graphical display of the board so the Players can use it as a reference
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
		//calls the board.BoardDisplay method when class is run
		new BoardDisplay();
	}
	
	/*
	 * Prints the board to be displayed to the user.
	 * 
	 * For the board to be printed in rows of 10 I used a nested loop.
	 * There are 28 rows total, 10 tiles per row & every 4th row it is repeated.
	 * Because of this I used 3 counters(i, rowIndex & row)
	 * 
	 * @param row This runs through each row.
	 * @param rowLoop Each time 'row' loops, a nested loop adds a specific element 10 times.
	 * @param rowIndex Decides what specific element is added. Each time rowIndex hits 4, it resets.
	 * @param printRow The nested loop adds the specific element 10 times into one long string which is printed outside of the loop
	 * 					The printRow string is reset after it prints out the information.
	 */
	public BoardDisplay()
	{
		int tileIndex = 0;
		int rowIndex = 0;
		int rowRepeat = 11;
		String printRow = "";

		//First loop which runs through the 28 Rows
		for(int row = 0 ; row < 30 ; row++){

			//rowRepeat is set to 10, meaning the loop will repeat 10 times.
			//The final set of tiles they only need to be repeated 5 times.
			//The final tiles begin on row 24
			if(row == 25){
				rowRepeat = 10;
			}

			for(int rowLoop = 0 ; rowLoop < rowRepeat ; rowLoop++){

				//If rowIndex = (0, 2 or 3) it will add the toString method together
				if(rowIndex == 0 || rowIndex == 2 || rowIndex == 4){
					printRow += toString(tileIndex, rowIndex);
				}
				//If rowIndex = 1 it will increment tileIndex.
				//This is so tileIndex increments ONLY when it is printed
				else if(rowIndex == 1){
					printRow += toString(tileIndex, rowIndex);

					if (tileIndex < 64){
						tileIndex++;
					}
				}

				//If rowIndex = 3 it will check if player position = true
				//if true it will print out the player name
				else if(rowIndex == 3){
					printRow += toString(tileIndex, rowIndex);
				}

				//If rowIndex = 4 it will reset rowIndex to 0
				else{
					rowIndex = 0;
					printRow += toString(tileIndex, rowIndex);
				}
			}
			//the printRow from the loop is printed out
			System.out.println(printRow);
			//printRow is reset
			printRow = "";
			//rowIndex is incremented, letting the next loop know to print out the next line 10 times
			rowIndex++;
		}
	}
		
	/*
	 * Requires two integer arguments for the method to be called
	 * which is used for the tiles array and the tilesRow array
	 */
	public String toString(int i, int rowIndex)
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
		String[] tileRows = new String[5];
		//a string containing 13 spaces which will be truncated later
		String spaces = "              ";
		//the total length of this string will help decide the required spaces to be added
		String tileType = index + ": "+ tiles[i];
		
		//the rows of the tile is stored in an array making it easier to call by the board.BoardDisplay()
		//because it uses incremented integers in it's loops 
		tileRows[0] = "+--------------+";
		tileRows[1] = "| "+ tileType + spaces.substring(0, ((spaces.length() - tileType.length()) - 1)) + "|";
		tileRows[2] = "|" + spaces + "|";
		tileRows[3] = "|" + spaces + "|";
		tileRows[4] = "+--------------+";
		
		//returns the specific rowIndex requested
		return tileRows[rowIndex];
	}
	
	/*
	 * @return returns the string in a specified index in the tiles array
	 */
	public String getTile(int i)
	{
		return tiles[i];
	}
}
