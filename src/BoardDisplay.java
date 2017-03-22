import java.util.ArrayList;

public class BoardDisplay 
{
	
	public static void main(String[] args)
	{
		new BoardDisplay();
	}
	
	public BoardDisplay()
	{
		String tiles[] = {"Start", "Hare", "Carrots", "Hare", "3", "Carrots", "Hare", "156", "2", "4", "Lettuce", "Tortoise", "3", 
				"Carrots", "Hare", "Tortoise", "156", "2", "4", "Tortoise", "3", "Carrots", "Lettuce", "2", "Tortoise", "Hare", 
				"Carrots", "4", "3", "2", "Tortoise", "Hare", "156", "Carrots", "Hare", "2", "3", "Tortoise", "Carrots", "Hare", 
				"Carrots", "2", "Lettuce", "Tortoise", "3", "4", "Hare", "2", "156", "Carrots", "Tortoise", "Hare", "3", "2", "4", 
				"Carrots", "Tortoise", "Lettuce", "Hare", "Carrots", "156", "Carrots", "Hare", "Carrots", "Finish"};
		
		for(int i = 0 ; i < tiles.length ; i++)
		{
			System.out.println("" + i + ": " + tiles[i]);
		}
	}
	
}
