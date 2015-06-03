package game;



public class Player {
	public final String name;
	private int[] dice;
	private boolean[] completedBonuses = new boolean[13];
	private int rerolls;
	private int[] score;
	/*
	 *Ones				Any combination										The sum of dice with the number 1	
	 *Twos				Any combination										The sum of dice with the number 2	
	 *Threes			Any combination										The sum of dice with the number 3	
	 *Fours				Any combination										The sum of dice with the number 4	
	 *Fives				Any combination										The sum of dice with the number 5	
	 *Sixes				Any combination										The sum of dice with the number 6
	 *Three-Of-A-Kind	At least three dice the same						Sum of all dice
	 *Four-Of-A-Kind	At least four dice the same							Sum of all dice	
	 *Full House		Three of one number and two of another				25	
	 *Small Straight	Four sequential dice (1-2-3-4, 2-3-4-5, or 3-4-5-6)	30	
	 *Large Straight	Five sequential dice (1-2-3-4-5 or 2-3-4-5-6)		40	
	 *Yahtzee			All five dice the same								50	
	 *Chance			Any combination										Sum of all dice
	 * 
	 */
	public Player(String name){
		this.name = name;
	}

	/**
	 * Prompts the player to choose an action
	 * @TODO
	 */
	public void act() {


	}
	
	/**
	 * Updates dice with new values
	 */
	public void roll(){
		dice = DiceUtil.getRandomDice();
		UI.printRoll(dice);
		act();
	}

	/**
	 * Lets the user reroll designated dice
	 */
	public void reRoll(){
		if(rerolls >= 3){
			int[] newDice = UI.promptForReRoll(dice);
			dice = DiceUtil.populateDiceArray(newDice);
			UI.printReRoll(dice);
			rerolls++;
		}
		else
		act();
	}

	/**
	 * Let the player choose a bonus
	 */
	public void chooseBonus(){
		int[] possibleBonuses = DiceUtil.calculateScores(dice);
		UI.displayBonuses(possibleBonuses, completedBonuses);
		int choice = UI.promptToChooseBonus();
		if (!completedBonuses[choice]) {
			score[choice] += possibleBonuses[choice];
			completedBonuses[choice] = true;
		} else {
			UI.invalidBonusChoice();
			act();
		}
	}
	


}
