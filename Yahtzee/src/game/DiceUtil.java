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
	
	/**z
	 * Returns a random array of ints from 1 to 6, with 6 ints in total
	 * @return
	 */
	public static int[] getRandomDice(){
		return populateDiceArray(new int[6]);
	}

	/**
	 * Calculates All possible scores based on the current dice state
	 * @author 177864
	 * @return
	 */
	//hypothetical dice because I don't see how scores will be calculated if nothing is passed in
	public static int[] calculateScores(int[] dice) 
	{
		/*
		 * GO AWAY JUSTIN & ARYAK ARE DOING THIS LOL //Justin you're hella territorial.
		 */
		int[] possibleScoreSet = new int[7];		//7 types of scoring possible
		/*Order goes according to indexes:
		 *3 of a kind
		 *4 of a kind
		 *full house
		 *small Straight
		 *Large Straight
		 *Yahtzee
		 *Chance
		 */
		int sumDice = 0;							
		for(int x = 0; x < dice.length; x++)
			sumDice += dice[x];
		
		int duplicates = 0;
		for(int j = 0; j < dice.length; j++)
			for(int k = 0; k < dice.length; k++)
				if(j!=k && dice[j] == dice[k])
					duplicates++;
		
		possibleScoreSet[6] = sumDice;
		if(duplicates == 3)
			possibleScoreSet[0] = sumDice;
		if(duplicates == 4)
		{
			possibleScoreSet[0] = sumDice;
			possibleScoreSet[1] = sumDice;
		}
		if(duplicates == 3 && )
	}

}
