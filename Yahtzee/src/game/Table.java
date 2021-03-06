package game;

import java.util.ArrayList;
import java.util.List;

import game.Player;

public class Table {

	private static List<Player> players = new ArrayList<Player>();

	/**
	 * Prepares the game for play
	 */
	public static void main(String[] args) {
		players.clear();
		int playerNum = UI.promptNumPlayers();
		
		for (int i = 1; i <= playerNum; i++) {
			players.add(new Player(UI.getPlayerName(i)));
		}
		runGame();
	}

	/**
	 * Main loop of the game
	 */
	public static void runGame() {
		while (!players.get(0).isFinished()) {
			for (Player p : players) {

				UI.announcePlayerTurn(p);
				p.act();
			}
		}
		endGame();
	}

	/**
	 * Runs when game is over Displays scores and catagories, compares players, ask
	 * if they want to play again
	 */
	public static void endGame() {
		Player winner = players.get(0);
		for (Player p : players) {
			UI.displayFinalScore(p);
			if(winner.getNumericScore()<p.getNumericScore())
				winner = p;
		}
		UI.displayWinner(winner);
		if (UI.promptForRePlay())
			main(null);
	}

}
