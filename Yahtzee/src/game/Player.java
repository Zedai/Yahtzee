package game;



public class Player {
	public final String name;
	private int[] dice;
	private int rerolls;
	/*
	 *Aces				Any combination										The sum of dice with the number 1	
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
		this.rerolls = 0;
	}

	/**
	 * Prompts the player to choose an action
	 * @TODO
	 */
	public void act(){

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
	 * Rerolls designated dies
	 * Precondition: rerolls is not greater than 3
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
	 * @TODO
	 */
	public void chooseBonus(){

	}


}
