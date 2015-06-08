package game;

import java.util.ArrayList;
import java.util.List;

public class Table {

	public Table(){
		
	}
	
	private List<Player> players = new ArrayList<Player>();
	/**
	 * Prepares the game for play
	 */
	public void setupGame(){
		if (players.isEmpty()) {
		for(int i=1;i<=4;i++) {
			
			players.add(new Player(UI.getPlayerName(i)));
			
		}
		}
	}
	
	/**
	 * Main loop of the game
	 */
	public void runGame(){
		
	}
	
	/**
	 * Runs when game is over
	 * Displays scores and bonuses, compares players, ask if they wqnt to play again
	 */
	public void endGame()
	{
		
	}
	
	
	
}
