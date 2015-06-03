package game;

import java.util.Scanner;

public class UI {
	
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Prompts the user to choose an action
	 * @return 1 for roll, 2 for reroll, 3 to choose bonus
	 * @TODO
	 */
	public static int promptForAction(){
		return 0;
	}
	
	/**
	 * Prompt the player to choose a bonus
	 * @return an int relating to the index in the bonuses array
	 * for example, 0 means ones
	 * 7 means three pair or whatever
	 * @todo
	 */
	public static int promptToChooseBonus(){
		return 0;
	}
	/**
	 * Prints out the outcome of an initial roll
	 * @param dice The dice that the player just rolled
	 * @TODO
	 */
	public static void printRoll(int[] dice){
		
	}
	
	/**
	 * Prints out the outcome of a reroll
	 * @param dice
	 * @TODO
	 */
	public static void printReRoll(int[] dice){
		
	}
	
	/**
	 * Prompts the user to choose which dice he wants to reroll
	 * If the user wants to reroll a certain die, set that die's value in the array to 0
	 * @return the modified array
	 * @TODO
	 */
	public static int[] promptForReRoll(int[] dice){
		return null;
	}
	
	/**
	 * Alerts the user that they've used up all of their rerolls
	 * @TODO 
	 */
	public static void tooManyReRolls(){
		
	}
	
	/**
	 * Displays the possible bonuses in a nice table
	 * @param possibleBonuses the bonuses to display
	 * @param completedBonuses the bonuses that have already been filled
	 * @todo
	 */
	public static void displayBonuses(int[] possibleBonuses, boolean[] completedBonuses) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Alert the player that they have chose a bonus that has already been chosen before
	 */
	public static void invalidBonusChoice(){
		errorDialouge("You have already chosen this bonus before");
	}
	
	/**
	 * Warn the player that they tried to choose a bonus that they have already chosen before
	 * @param error the error to display
	 * @todo
	 */
	public static void errorDialouge(String error) {
		// TODO Auto-generated method stub
		
	}
}
