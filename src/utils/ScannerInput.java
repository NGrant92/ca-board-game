package utils;

import java.util.Scanner;
/*This class will  retrieve inputs and insure there are no errors in the inputs f
 * for example if the player is asked how many squares it wants to move and enters a letter by mistake 
 * it will return invalid option as it is not an integer 
/
 * 
 */

public class ScannerInput {
	/*
	 * this tells the user to enter a number 
	 * if they enter a number it allows them them to the desired action
	 */

	public static int validNextInt(String prompt) {
		Scanner input = new Scanner(System.in);
		do {
			try {
				System.out.println(prompt);
				return input.nextInt();
			} catch (Exception e) {
				input.nextLine();//swallows the buffer contents
				System.err.println("\tEnter a number please ");
			}
		} while (true);

	}
	/*This method tidies up input text 
	 * converts it to lower case and removes and spacing 
	 *this method is called in the gamecontroller 
	 */

	public static String retrieveText(String prompt) {
		Scanner input = new Scanner(System.in);
		do {
			System.out.println(prompt);
			return input.nextLine().trim().toLowerCase();
		} while (true);
	}

}




















