package game;


import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;
/**
 * @author everyone in the group
 * holds all methods that contain a print statement. Methods within print dice,
 *  requests for the players' name, prompts to choose a catagory, and other stuff.
 */
public class UI {

	private static Scanner in = new Scanner(System.in);

	
	public static String getPlayerName(int playerNumber) {

		System.out.println("Enter Player "+playerNumber+" 's name"); 
		return in.nextLine();

	}
	/**
	 * Prompt the player to choose a catagory
	 * @return an int relating to the index in the catagories array
	 * for example, 0 means ones
	 * 7 means three pair or whatever
	 */
	public static int promptToChooseCatagories(){
		System.out.println("Enter the number of the desired catagory");
		try {
			return Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			System.out.println("That isn't a valid catagory ya fuul");
			return promptToChooseCatagories();
		}
		
	}
	/**
	 * Prints out the outcome of an initial roll
	 * @param dice The dice that the player just rolled
	 */
	public static void printRoll(int[] dice){
		System.out.println("\n");
		System.out.println("You rolled and got:");
		System.out.println(" A   B   C   D   E ");
		System.out.println(printDice(dice));
	}

	/**
	 * Prints out the outcome of a reroll
	 * @param dice the new dice
	 */
	public static void printReRoll(int[] dice){
		System.out.println("You Re-Rolled and got: ");
		System.out.println(" A   B   C   D   E ");
		System.out.println(printDice(dice));
	}

	/**
	 * Prompts the user to choose which dice he wants to reroll
	 * If the user wants to reroll a certain die, set that die's value in the array to 0
	 * @return the modified array
	 * 
	 */
	public static int[] promptForReRoll(int[] dice){

		String input="";
		ArrayList<Integer> indecies = new ArrayList<Integer>();
		indecies.add(0);indecies.add(0);indecies.add(0);indecies.add(0);indecies.add(0);
		
			System.out.println("\n");
			System.out.println("Enter the letters of the dice that you want to keep, or type all");

			input = in.nextLine();
			
			if(input.equalsIgnoreCase("all"))
				return dice;

			if(input.indexOf("a") >= 0 || input.indexOf("A") >= 0) {
				indecies.set(0, dice[0]);
			}
			if(input.indexOf("b") >= 0 || input.indexOf("B") >= 0) {
				indecies.set(1, dice[1]);
			}
			if(input.indexOf("c") >= 0 || input.indexOf("C") >= 0) {
				indecies.set(2, dice[2]);
			}
			if(input.indexOf("d") >= 0 || input.indexOf("D") >= 0) {
				indecies.set(3, dice[3]);
			}
			if(input.indexOf("e") >= 0 || input.indexOf("E") >= 0) {
				indecies.set(4, dice[4]);
			}

			
				for(int i=0;i<dice.length;i++) 
					dice[i] = indecies.get(i);

				
		return dice;
	}
	/**
	 * prints the player's hand of dice
	 * @param dice the hand of dice
	 * @return a nicely formatted string representing the dice.
	 */
	
	private static String printDice(int[] dice){
		StringBuilder builder = new StringBuilder();
		for (int i : dice) {
			if(i == 0)
				builder.append("(X) ");
			else
				builder.append("("+i+") ");
		}
		return builder.toString();
	}



	/**
	 * Displays the possible catagoryes in a nice table
	 * @param possibleCatagories the catagories to display
	 * @param completedCatagories the catagories that have already been filled
	 */
	public static void displayCatagories(int[] possibleCatagories, boolean[] completedCatagories) {
		String[] catagoryNames = {"Ones","Twos","Threes","Fours","Fives","Sixes","Three-Of-A-Kind","Four-Of-A-Kind","Full House","Small Straight","Large Straight","Yahtzee","Chance"};
		System.out.println("Here are the catagories that you can choose from:");
		for (int i = 0; i < possibleCatagories.length; i++) {
			if(!completedCatagories[i])
				System.out.println("[ " + i + " ]: " + catagoryNames[i] + " yields " + possibleCatagories[i] + " points.");
		}
	}
	/**
	 * prints the player's table
	 * @param scores
	 * @param completedCatagories
	 */
	public static void playerCatagory(int[] scores, boolean[] completedCatagories) {
		String[] catagoryNames = {"Ones","Twos","Threes","Fours","Fives","Sixes","Three-Of-A-Kind","Four-Of-A-Kind","Full House","Small Straight","Large Straight","Yahtzee","Chance"};
		System.out.println("Here are the scores you already have:");
		for (int i = 0; i < scores.length; i++) {
			String catagoryLine = "[ " + i + " ]: " + catagoryNames[i] + ": " + scores[i] + " points.";
			if(!completedCatagories[i])
				catagoryLine += " (incomplete)";
			System.out.println(catagoryLine);
		}
	}
	/**
	 * Alert the player that they have chose a catagory that has already been chosen before
	 */
	public static void invalidCatagoryChoice(){
		errorDialogue("You have already chosen this catagory before, did you forget?");
	}

	/**
	 * Warn the player that they tried to choose a catagory that they have already chosen before
	 * @param error the error to display
	 */
	public static void errorDialogue(String error) {
		System.out.println("Error: " + error);

	}
	
	public static void announcePlayerTurn(Player p) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < p.name.length(); i++) {
			builder.append("=");
		}

		for (int i = 0; i < String.valueOf(p.getNumericScore()).length() ; i++) {
			builder.append("=");
		}

		System.out.println("================================" + builder);
		System.out.println("== It's " + p.name +"'s turn, with "+ p.getNumericScore() +" points ==");
		System.out.println("================================" + builder);
	}
	
	public static void invalidChoice() {
		errorDialogue("Stop trying to cheat you 3lite h4xz0r");

	}
	
	public static boolean promptForRePlay() {
		System.out.println("Would you like to replay? (yes or no you fool)");
		String answer = in.nextLine();
		return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1");
	}
	public static void displayFinalScore(Player p) {
		System.out.println("Player "+p.name+" got "+p.getNumericScore()+" point(s)!");
	}
	public static void displayWinner(Player p){

		System.out.println("Player "+p.name+" won!");
	}
	public static void jokerDialouge(int dieNum) {
		System.out.println("You got Yathzee, but you have a zero in that slot! JOKER!!!");
		System.out.println("Changed your "+dieNum+"'s score because JOKER!");
		
		
	}
	public static void jokerChooseLower() {
		System.out.println("JOKER: You have already scored in your Yathzee box \n AND you have the corrosponding upper box filled, \n Choose a bonus again!");
		
	}
	
}
