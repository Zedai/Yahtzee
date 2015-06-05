package game;

public class Test {

	public static void main(String[] args) {
		int[] dice = {5,4,6,2,3,1};
		int[] newdice = UI.promptForReRoll(dice, 0);
		
		for (int i : newdice) {
			System.out.print(i + ", ");
		}

	}

}
