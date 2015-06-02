/**
 * 
 */
package game;

import java.util.List;

/**
 * @author 310843
 *
 */
public class DiceUtil {

	/**
	 * Populates an array with a random value from 1 - 6 ONLY if the current value is 0
	 * Leaves nonzero values alone
	 * @param dice The array to populate / repopulate
	 * @return a populated array
	 */
	public static int[] populateDiceArray(int[] dice) {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == 0) {
				dice[i] = 1 + (int) (Math.random() * 6);
			}
		}
		return dice;
	}
	
	/**
	 * Returns a random array of ints from 1 to 6, with 6 ints in total
	 * @return
	 */
	public static int[] getRandomDice(){
		return populateDiceArray(new int[6]);
	}

	/**
	 * Calculates All possible scores based on the current dice state
	 * 
	 * @return
	 */
	public static int[] calculateScores() {

		/*
		 * GO AWAY JUSTIN IS DOING THIS LOL
		 */
		return null;

	}

}
