package ua.ss.tt;

import java.util.ArrayList;

public class Tournament {

//The main list of all players in the tournament
	private ArrayList<Player> playerList = new ArrayList<Player>();

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Player p) {
		playerList.add(p);
	}

	public void createObjectsForTornament(int numberOfObjects) {
		for (int i = 0; i < numberOfObjects; i++) {
			playerList.add(new Player());
		}
	}

	public void definingMVP() {
//finding the highest number of rating points 				
		int a = 0;
		for (Player player : playerList) {
			if (player.getRatingPoints() > a)
				a = player.getRatingPoints();
		}

//finding the player with the highest number of rating points 
		for (Player p : playerList) {
			if (p.getRatingPoints() == a)
				System.out.println("\n"+"The most valuable player of the "
						+ "tournament is \"" + p.getPlayer() + "\" he scored "
						+ p.getRatingPoints() + " rating points");
		}
	}

}
