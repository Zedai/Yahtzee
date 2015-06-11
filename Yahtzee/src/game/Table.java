package game;

import java.util.ArrayList;
import java.util.List;

import game.Player;

public class Table {

	private List<Player> players = new ArrayList<Player>();
	
	/**
	 * Prepares the game for play
	 */
	public void setupGame(){
		players.clear();
		for(int i=1;i<=2;i++) {
			players.add(new Player(UI.getPlayerName(i)));
		}
		runGame();
	}
	
	/**
	 * Main loop of the game
	 */
	public void runGame()
	{
		System.out.println("WALCOM 2 YATZIE");
		while(!players.get(0).isFinished()){
			for (Player p : players) 
			{
				
				UI.announcePlayerTurn(p);
				p.act();
			}
		}
	}

	/**
	 * Runs when game is over
	 * Displays scores and bonuses, compares players, ask if they want to play again
	 */
	public void endGame()
	{
		for(Player p : players)
		{
			p.getNumericScore();
		}
		
		if(UI.promptForRePlay())
			setupGame();
	}
	
	
	
}
