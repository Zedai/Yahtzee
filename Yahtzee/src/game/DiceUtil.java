/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 310843
 * @author 155053 and the rest of the group
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
		return populateDiceArray(new int[5]);
	}

	/**
	 * Calculates All possible scores based on the current dice state
	 * @author 177864
	 * @return an array of all of the possible scores
	 */
	public static int[] calculateScores(int[] dice) 
	{
		
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
		int[] a = greatestOccurrence(dice);
		List<Integer> lastTwo = new ArrayList<Integer>();
		if(a[0]== 3){
			int threeOfMe = a[1];
			for(int c = 0; c<dice.length; c++){
				if (!(dice[c]==threeOfMe))
					lastTwo.add(dice[c]);
			}
			if(lastTwo.get(0).equals(lastTwo.get(1)))
				return 25;
			else
				return 0;
			
		}
		else
			return 0;
		
	}
	/**
	 * returns the total of the entire tray if four dice are the same
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
		return 50;
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
		if(straightCounter(4,dice))
			return 30;
		return 0;
	}
	
	private static int largeStraight(int[] dice)
	{
		if(straightCounter(5,dice))
			return 40;
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
	private static boolean straightCounter(int key, int [] dice){
		int temp=0;
		int counter = 0;
		Arrays.sort(dice);
		for(int c=1; c<dice.length;c++){
			temp = dice[c-1];
			if(dice[c] == (temp+1)){
				counter++;
			}
		}
		if(counter == key)
			return true;
		return false;
	}
}
