package board;

import models.CarrotSquare;
import models.Player;
import models.Square;
import models.StartSquare;

import java.util.ArrayList;

public class Board {
    public ArrayList<Square> squares;
    
    //Array that holds the name of the tiles and in the correct order
    String tiles[] = {"Start", "Hare", "Carrots", "Hare", "3", "Carrots", "Hare", "156", "2", "4", "Lettuce", "Tortoise", "3",
        "Carrots", "Hare", "Tortoise", "156", "2", "4", "Tortoise", "3", "Carrots", "Lettuce", "2", "Tortoise", "Hare",
        "Carrots", "4", "3", "2", "Tortoise", "Hare", "156", "Carrots", "Hare", "2", "3", "Tortoise", "Carrots", "Hare",
        "Carrots", "2", "Lettuce", "Tortoise", "3", "4", "Hare", "2", "156", "Carrots", "Tortoise", "Hare", "3", "2", "4",
        "Carrots", "Tortoise", "Lettuce", "Hare", "Carrots", "156", "Carrots", "Hare", "Carrots", "Finish"};
    
    public Board () {
        squares = new ArrayList<>();
    
        squares.add(new StartSquare("Start", 0));
        for (int i = 1 ; i < tiles.length; i++) {
            squares.add(new CarrotSquare("Carrots", i));
        }
    }
    
    public void setPlayerPosition(int squareNumber, Player player) {
        squares.get(player.getPosition()).removePlayer(player);
        squares.get(squareNumber).setPlayer(player);
    }
    
    public String print () {
        String str = "";
        String playerName = "";
        for (int i = 0 ; i < tiles.length; i++) {
    
            for (int j = 0 ; j < squares.get(i).players.size() ; j++) {
                playerName += squares.get(i).players.get(j).getPlayerName() + ", ";
            }
            String bool = "";
            if (squares.get(i).isAvailable()) {
                bool = "true";
            } else {
                bool = "false";
            }
             str = str + i + ": " + squares.get(i).name + " " + playerName + ": " + bool + "\n";
            playerName = "";
        }
        return str;
    }
}
