package game;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private List<Player> players = new ArrayList<Player>();
	
	public Table(int numPlayers)
	{
		//IDK if number of payers is taken here or in setupGame. I'll just put int parameters in both method headers
	}
	
	/**
	 * Prepares the game for play
	 */
	public void setupGame(int numPlayers){
		players.clear();
		for(int i=1;i<=4;i++) {
			
			players.add(new Player(UI.getPlayerName(i)));
			
		}
		
		runGame();
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
