package ua.ss.tt;

import java.io.File;
import java.util.ArrayList;

public abstract class Game {

//The method "createTeam" takes csv file and object of the tournament 
//after that makes changes to the main list of players
	public abstract void createTeam(File file, Tournament tournament) throws Exception;
	
//The method "defineWinnerTeam" takes the main list of players, counts the points
//scored by each team, defines the winning team and adds 10 extra rating 
//points to each player of the winning team and also counts the rating points of 
//each player
	public abstract void defineWinnerTeamAndRatingPoints(ArrayList<Player> playerList);

}
