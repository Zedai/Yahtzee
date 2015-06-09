package game;

public class test {

	public static void main(String[] args) {
		int[] dice = {1,2,3,4,5};
		int[] reroll = UI.promptForReRoll(dice);
		for ( int i : reroll) {
			System.out.print(i+", ");
		}

	}

}
