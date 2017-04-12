package utils;
/*This class will enable the player to see the rules at any stage while the game is in play by pressing a certain button and return to the game/menu
 * 
 */
/**
 * Constructor for Objects of the List of Rules
 * @param List of rules for the User
 */
public class ShowRules {

<<<<<<< HEAD
public static String viewRules()
{
return "Rules Display: +Rules Display "
		+ ".\nList of Rules in the Game:\n"
		+"Rule No ONE You can move forward to any unoccupied square if you have enough carrots,\n"
		+"Number Squares : On your next turn,check if the number you are on is the same as your position in the race . If it is , then multiply your position in the race by 10 and draw that many Carrot cards, Move on same turn.\n"
		+"Carrot Squares:Stay as long as you like, each turn you miss ,collect or pay 10 Carrot cards if you want to get rid of some.\n"
		+"Lettuce Squares :You must hold a Lettuce card to land on this square .Immediately turn your runner upside down.Next turn,discard 1X Lettuce card and then multiply your position in the race by 10 and draw that many carrot cards .Move on the next turn, and turn runner right side up .\n"
		+"Tortoise Square :You can only move  backwards to the nearest Tortoise square if empty, Immediately collect 10 carrots for each square have moved back.Next turn move on or backwards again-same rules apply.\n"
		+"Hare squares Draw the top hare card and follow instructions.\n";
		
		

}
public static String viewCost ()
{return "Cost of Moving +Cost of Moving"
		+ ".nList of Cost in Carrots:\n "
	+"1=1     carrot \n"
	+"2=3     carrots \n"
	+"3=6     carrots\n"
	+"4=10    carrots\n"
	+"5=15    carrots\n"
	+"6=21    carrots\n"
	+"7=28    carrots\n"
	+"8=36   carrots\n"
	+"9=45   carrots\n"
    +"10=55  carrots\n"
	+"11=66   carrots\n"
	+"12=78     carrots\n"
	+"13=91     carrots\n"
    + "14=105   carrots\n"
	+"15=120    carrots\n"
    +"16=136     carrots\n"
   + "17=153    carrots\n"
    +"18=171    carrots\n"
   +"19=190     carrots\n"
    +"20=210    carrots\n"
   +"21 =231    carrots\n"
    +"22=253    carrots\n"
   +"23=276     carrots\n"
    +"24=300    carrots\n"
   +"25 =325    carrots\n"
    +"26 =351   carrots\n"
   +"27=378     carrots\n" 
  +"28=406      carrots\n"
  +"29=435      carrots\n"
  +"30=465      carrots\n"
  + "31=496     carrots\n"
  +"32=528      carrots\n"
  +"33=561      carrots\n"
  +"34=595       carrots\n"
  +"35=630       carrots\n"
  +"36=666        carrots\n"
  +"37=703         carrots\n"
  +"38=741          carrots\n"
  +"39=780            carrots\n"
  + "40=820            carrots\n";
}
=======




	public String viewRules()
	{
		return "RULES:\n"
				+ "\nList of Rules in the Game:\n"
				+"You can move forward to any unoccupied square if you have enough carrots.\n"
				+"NUMBER SQUARE: On your next turn, check if the number you are on is the same as your position in the race. If it is, then multiply your position in the race by 10 and draw that many Carrots, move on same turn.\n"
				+"CARROT SQUARE: Stay as long as you like, each turn you miss, collect or pay 10 Carrots if you want to get rid of some.\n"
				+"LETTUCE SQUARE: You must hold a Lettuce card to land on this square. Next turn, discard 1 Lettuce card, then multiply your position in the race by 10 and draw that many carrot cards. Move on the next turn.\n"
				+"TORTOISE SQUARE: You can only move backwards to the nearest Tortoise square if empty. Immediately collect 10 carrots for each square have moved back. Next turn move on or backwards again, same rules apply.\n"
				+"HARE SQUARE: Draw the top hare card and follow instructions.\n";



	}
	public String viewCost ()
	{
		return "+----------------------------------------------------------------------------------------+\n"
				+ "|                                     COST OF MOVING                                     |\n"
				+ "+----------------------------------------------------------------------------------------+\n"
				+ "+-------------------+  +-------------------+  +-------------------+  +-------------------+\n"
				+ "| Squares | Cost in |  | Squares | Cost in |  | Squares | Cost in |  | Squares | Cost in |\n"
				+ "|  Moved  | Carrots |  |  Moved  | Carrots |  |  Moved  | Carrots |  |  Moved  | Carrots |\n"
				+ "+-------------------+  +-------------------+  +-------------------+  +-------------------+\n"
				+ "|    01   |    01   |  |    11   |    66   |  |    21   |   231   |  |    31   |   496   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    02   |    03   |  |    12   |    78   |  |    22   |   253   |  |    32   |   528   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    03   |    06   |  |    13   |    91   |  |    23   |   276   |  |    33   |   561   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    04   |    10   |  |    14   |   105   |  |    24   |   300   |  |    34   |   595   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    05   |    15   |  |    15   |   120   |  |    25   |   325   |  |    35   |   630   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    06   |    21   |  |    16   |   136   |  |    26   |   351   |  |    36   |   666   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    07   |    28   |  |    17   |   153   |  |    27   |   378   |  |    37   |   703   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    08   |    36   |  |    18   |   171   |  |    28   |   406   |  |    38   |   741   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    09   |    45   |  |    19   |   190   |  |    29   |   435   |  |    39   |   780   |\n"
				+ "|-------------------|  |-------------------|  |-------------------|  |-------------------|\n"
				+ "|    10   |    55   |  |    20   |   210   |  |    30   |   465   |  |    40   |   820   |\n"
				+ "+-------------------+  +-------------------+  +-------------------+  +-------------------+\n"
	}
>>>>>>> 9b19280d40e32677a5e775784db6cb82cd0c6d98
}
  
    




