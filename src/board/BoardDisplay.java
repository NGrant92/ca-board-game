package board;
import models.*;
import java.util.ArrayList;
/**
 * Board Display class used to make a graphical display of the board so the Players can use it as a reference
 * when deciding on their next move.
 * 
 * @author Kevin Fan
 * @author Niall Grant
 * @author Bernadette Murphy
 * @author Keelan Murphy
 * @version 12/04/2017
 */
public class BoardDisplay 
{
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
	public BoardDisplay(ArrayList<Square> board)
	{
		//A counter that increments and will be used to check if any players are in a Tile
		int playerIndex = 0;
		//A counter that increments and will be used to pull from the above array list and as a number for the tile
		int tileIndex = 0;
		//A counter that will decide what will be printed on each row
		int rowIndex = 0;
		//The loop will pass the content into this string and will be printed at the end of the nested loop
		String printRow = "";
		//If player position == playerIndex then it will pass in the player's name for it to be printed
		String playerName = "";

		//First loop which runs through the 25 Rows
		for(int row = 0 ; row < 25 ; row++){

			//Second loop will add the necessary information to a string which will be printed on that row
			for(int rowLoop = 0 ; rowLoop < 13 ; rowLoop++){

				//If rowIndex = (0, 2 or 4) it will add the toString method together
				if(rowIndex == 0 || rowIndex == 2 || rowIndex == 4){
					printRow += toString(board, tileIndex, rowIndex, playerName);
				}
				//If rowIndex = 1 it will increment tileIndex.
				//This is so tileIndex increments ONLY when it is printed
				else if(rowIndex == 1){
					printRow += toString(board, tileIndex, rowIndex, playerName);

					if (tileIndex < 64){
						tileIndex++;
					}
				}

				//If rowIndex = 3 it will check if player position = true
				//if true it will print out the player name
				else if(rowIndex == 3){

					ArrayList<Player> players = new ArrayList<>(board.get(playerIndex).getPlayers());
					if (players.size() > 0 ) {
					    playerName = "player here";
                    }
     
					//Adds the string to printRow variable
					printRow += toString(board, tileIndex, rowIndex, playerName);
					//increments player index so it matches the respective tile number
					if (playerIndex < 64){
						playerIndex++;
					}

					playerName = "";
				}

				//If rowIndex = 4 it will reset rowIndex to 0
				else{
					rowIndex = 0;
					printRow += toString(board, tileIndex, rowIndex, playerName);
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
	public String toString(ArrayList<Square> board, int i, int rowIndex, String playerName)
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
		String tileType = index + ": "+ board.get(i).getName();

		//String player = index + ": "+ playerName;
		
		//the rows of the tile is stored in an array making it easier to call by the board.BoardDisplay()
		//because it uses incremented integers in it's loops
		tileRows[0] = "+--------------+";
		tileRows[1] = "| "+ tileType + spaces.substring(0, ((spaces.length() - tileType.length()) - 1)) + "|";
		tileRows[2] = "|" + spaces + "|";
		tileRows[3] = "| "+ playerName + spaces.substring(0, ((spaces.length() - playerName.length()) - 1)) + "|";
		tileRows[4] = "+--------------+";
		
		//returns the specific rowIndex requested
		return tileRows[rowIndex];
	}
	
	
}
