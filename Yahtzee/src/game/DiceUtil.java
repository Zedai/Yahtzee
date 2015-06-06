/**
 * 
 */
package game;

import java.util.Arrays;
import java.util.List;

/**
 * @author 310843
 *
 */
public class DiceUtil {
	/*	int sumDice = 0;							
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
	if(duplicates == 3 && true)
		
		
		
		
		
	for(int i=0;i<dice.length;i++)	{
		
		if(dice[i] == dice[i-1])
			possibleScoreSet[5] = 50;
		else 
			possibleScoreSet[5] = 0;
		
			
		
		
	}
		
		*/
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
		 * GO AWAY JUSTIN & ARYAK ARE DOING THIS LOL
		 */
		
		//7 types of scoring possible
		/*Order goes according to indexes:
		 *Ones
		 *Twos
		 *Threes
		 *Fours
		 *Fives
		 *Sixes
		 *3 of a kind
		 *4 of a kind
		 *full house
		 *small Straight
		 *Large Straight
		 *Yahtzee
		 *Chance
		 */
	
		
		return new int[] {				
				oneToSix(1,dice),
				oneToSix(2,dice),
				oneToSix(3,dice),
				oneToSix(4,dice),
				oneToSix(5,dice),
				oneToSix(6,dice),
				threeOfAKind(dice),
				fourOfAKind(dice),
				fullHouse(dice),
				smallStraight(dice),				
				largeStraight(dice),
				yahtzee(dice),
				chance(dice)				
		};
			
	}
	/**
	 * Returns 25 if fullhouse is possible
	 * 
	 * @param dice
	 * @return
	 */
	private static int fullHouse(int[] dice) {
		
		
		int duplicates = 0;
		for(int j = 0; j < dice.length; j++)
			for(int k = 0; k < dice.length; k++)
				if(j!=k && dice[j] == dice[k])
					duplicates++;
		if(duplicates >= 3)
			return 25;
		
		return 0;
		
	}
	/**
	 * @TODO fix the algorithm
	 * @param dice
	 * @return
	 */
	private static int fourOfAKind(int[] dice) {
		int duplicates = greatestOccurrence(dice)[0];
		
		if(duplicates >= 4)
			return chance(dice);
		
		return 0;
		
	}

	private static int chance(int[] dice) {
		int sum = 0;
		for (int i : dice) {
			sum += i;
		}
		return sum;
	}

	/**
	 * Calculates the score for yahtzee
	 * @param dice the dice to be scored
	 * @return the score for yahtzee
	 */
	private static int yahtzee(int[] dice) {
		int key = dice[0];
		for (int i = 1; i < dice.length; i++) {
			if (dice[i] != key)
				return 0;
		}
		return 0;
	}
	
	private static int oneToSix(int number, int[] dice)
	{
		int sum = 0;
		for(int x = 0; x < dice.length; x++)
		{
			if(dice[x] == number)
				sum += dice[x];
		}
		return sum;
	}
	
	private static int smallStraight(int[] dice)
	{
		
		return 0;
	}
	
	private static int largeStraight(int[] dice)
	{
		//TODO implement this shit pls
		return 0;
	}
	private static int threeOfAKind(int[] dice){

		int duplicates = greatestOccurrence(dice)[0];
		
		if(duplicates >= 3)
			return chance(dice);
		
		return 0;
	}
	
	/**
	 * @author 177864
	 * @param dice
	 * 	The array of values representing the dice roll
	 * @return
	 *	The number of occurrences of the most occurring element in the first index of the return array
	 *	The element itself in the second index of the array
	 */
	private static int[] greatestOccurrence(int[] dice)
	{
		 int count = 1, tempCount;
		  int popular = dice[0];
		  int temp = 0;
		  for (int i = 0; i < (dice.length - 1); i++)
		  {
		    temp = dice[i];
		    tempCount = 0;
		    for (int j = 1; j < dice.length; j++)
		    {
		      if (temp == dice[j])
		        tempCount++;
		    }
		    if (tempCount > count)
		    {
		      popular = temp;
		      count = tempCount;
		    }
		  }
		  
		  int[] retArray = {count , popular};
		  return retArray;
	}
	private boolean straightCounter(int key, int [] dice){
		boolean isStraight = false;
		int temp=0;
		
		Arrays.sort(dice);
		return isStraight;
	}
}
