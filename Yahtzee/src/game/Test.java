''
''''''';'package game;

public class Test {

	public static void main(String[] args) {
		int[] dice = {1,2,3,4,5,6};
		int[] newdice = UI.promptForReRoll(dice);
		
		for (int i : newdice) {
			System.out.print(i + ", ");
		}

	}

}
