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
		players.add(new Player("!◄Illuminati►!"));
	}
	
	/**
	 * Main loop of the game
	 */
	public void runGame(){
		
	}
	
	/**
	 * Runs when game is over
	 * Displays scores and such
	 */
	public void endGame(){
		
	}
	
	
	
}
