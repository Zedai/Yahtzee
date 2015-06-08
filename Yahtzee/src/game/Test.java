package game;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		
		int[] dice = {1,2,3,4,5,6};
		int [] newshet = DiceUtil.calculateScores(dice);
		Arrays.toString(newshet);
		
		
	}

}
