package game;



public class Player {
	public final String name;
	private int[] dice;
	private boolean[] completedCatagories = new boolean[13];
	private int[] score = new int[13];

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
	 *Yaht zee			All five dice the same								50	
	 *Chance			Any combination										Sum of all dice
	 * 
	 */
	public Player(String name){
		this.name = name;
	}

	/**
	 * Prompts the player to choose an action
	 */
	public void act() {
		roll();
		reRoll();
		reRoll();
		reRoll();
		chooseCatagory();
		
			
	}
	
	/**
	 * A method that returns if the player has completed all of their score slots
	 * @return if the player is done with the game
	 */
	public boolean isFinished()
	{
		for (boolean b : completedCatagories) {
			if(!b) //if catagory is not completed
				return false; // player still has catagoryes
		}
		return true;
	}
	
	
	/**
	 * Updates dice with new values
	 */
	public void roll(){
		dice = DiceUtil.getRandomDice();
		UI.printRoll(dice);
	}

	/**
	 * Lets the user reroll designated dice
	 */
	public void reRoll(){
		int[] newDice = UI.promptForReRoll(dice);
		dice = DiceUtil.populateDiceArray(newDice);
		UI.printReRoll(dice);
	}
	

	/**
	 * Let the player choose a catagory
	 */
	public void chooseCatagory(){
		int[] possibleCatagories = DiceUtil.calculateScores(dice);

		//determine if joker needs to be handeled
		if(score[11] == 0 && completedCatagories[11] && possibleCatagories[11] != 0){
			int dieNum = dice[0];
			if(!completedCatagories[dieNum - 1]){
				score[dieNum - 1] = dieNum * 5; // modify the upper half corrosponding to the die.
				UI.jokerDialouge(dieNum);
			}
			else 
				UI.jokerChooseLower();
		}
		else{ //if there are no jokers go on
			UI.displayCatagories(possibleCatagories, completedCatagories);

			int choice = UI.promptToChooseCatagories();

			//determine if a double yathzee needs to be handeled
			if(choice >= 0 && choice <= 12){
				if(choice == 11 && completedCatagories[11] && score[11] != 0) //yathzee twice!
					score[11] += 100;

				else if (!completedCatagories[choice]) {
					score[choice] = possibleCatagories[choice];
					completedCatagories[choice] = true;
				} else {
					UI.invalidCatagoryChoice();
					chooseCatagory();
				}

			}
			else {
				UI.outOfRangeCatagory();
				chooseCatagory();
			}
		}
	}

	/**
	 * Gets the numeric score of a player's roll
	 * @return the sum of the dice, and a catagory if neccisary
	 */
	public int getNumericScore()
	{
		
		int upper = 0;
		int sum = 0;
		
		for (int i = 0; i < 6; i++) {
			upper += score[i];
		}
		
		if(upper >= 63)
			sum += 35;
		
		for(int x = 0; x < score.length; x++)
		{
			sum += score[x];
		}
		return sum;
	}
	


}
