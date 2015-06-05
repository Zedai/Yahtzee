package game;

import java.util.Scanner;

public class UI {
	
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Prompts the user to choose an action
	 * @param canChooseBonus if the player can choose a bonus
	 * @param canReRoll if the player can reroll
	 * @param canRoll if the player can roll
	 * @return 1 for roll, 2 for reroll, 3 to choose bonus
	 */
	public static int promptForAction(boolean canRoll, boolean canReRoll, boolean canChooseBonus){
		System.out.println("-------------------------");
		System.out.println("Choose an action");
		
		if(canRoll);
		System.out.println("1. Roll");
		if(canReRoll)
			System.out.println("2. Re-Roll");
		if(canChooseBonus)
			System.out.println("3. Choose Bonus");
		
		return Integer.parseInt(in.nextLine());
	}
	
	/**
	 * Prompt the player to choose a bonus
	 * @return an int relating to the index in the bonuses array
	 * for example, 0 means ones
	 * 7 means three pair or whatever
	 */
	public static int promptToChooseBonus(){
		System.out.println("Enter the number of the desired bonus");
		return Integer.parseInt(in.nextLine());
	}
	/**
	 * Prints out the outcome of an initial roll
	 * @param dice The dice that the player just rolled
	 */
	public static void printRoll(int[] dice){
		System.out.println("You rolled and got:");
		System.out.println(printDice(dice));
	}
	
	/**
	 * Prints out the outcome of a reroll
	 * @param dice the new dice
	 */
	public static void printReRoll(int[] dice){
		System.out.println("You Re-Rolled and got: ");
		System.out.println(printDice(dice));
	}
	
	/**
	 * Prompts the user to choose which dice he wants to reroll
	 * If the user wants to reroll a certain die, set that die's value in the array to 0
	 * @return the modified array
	 * 
	 */
	public static int[] promptForReRoll(int[] dice, int rolls){
		System.out.println(" 1   2   3   4   5   6");
		System.out.println(printDice(dice));
		
		String input;
		int choice = 0;
		do {
			System.out.println("Enter the number of the die that you want to change, or done to quit.");
			input = in.nextLine();
			try {
				choice = Integer.parseInt(input);
				if(choice >= 1 && choice <= 6){
					dice[choice - 1] = 0;
					System.out.println("Marked die "+ choice +" for reroll, here are your dice:");
					System.out.println(printDice(dice));
				}
				else
					errorDialouge("That number is not on the list silly");
			} catch (NumberFormatException e) {
				if(input.equalsIgnoreCase("done"))
					choice = -1;
				else
					errorDialouge("You did not type in a valid choice");
			}
		} while (choice != -1 && rolls < 3);
		if(rolls < 3) {
			System.out.println("Sorry, you ran out of rolls!");
		}
		return dice;
	}
	
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
	 * Alerts the user that they've used up all of their rerolls
	 * @TODO 
	 */
	public static void tooManyReRolls(){
		
	}
	
	/**
	 * Displays the possible bonuses in a nice table
	 * @param possibleBonuses the bonuses to display
	 * @param completedBonuses the bonuses that have already been filled
	 */
	public static void displayBonuses(int[] possibleBonuses, boolean[] completedBonuses) {
		String[] bonusNames = {"Ones","Twos","Threes","Fours","Fives","Sixes","Three-Of-A-Kind","Four-Of-A-Kind","Full House","Small Straight","Large Straight","Yahtzee","Chance"};
		System.out.println("Here are the bonuses that you can choose from:");
		for (int i = 0; i < possibleBonuses.length; i++) {
			if(!completedBonuses[i])
				System.out.println("[ " + i + " ]: " + bonusNames[i] + " yields " + possibleBonuses[i] + " points.");
		}
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
	 */
	public static void errorDialouge(String error) {
		System.out.println("Error: " + error);
		
	}
}
