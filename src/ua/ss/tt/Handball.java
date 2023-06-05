package ua.ss.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Handball extends Game {
	@Override
	public void createTeam(File file, Tournament tournament) throws Exception {
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] c = line.split(";");

			tournament.getPlayerList().get(i).setPlayer(c[0].trim());
			tournament.getPlayerList().get(i).setNickname(c[1].trim());
			tournament.getPlayerList().get(i).setNumber(c[2].trim());
			tournament.getPlayerList().get(i).setTeamName(c[3].trim());
			tournament.getPlayerList().get(i)
					.setGoalMade(Integer.parseInt(c[4]));
			tournament.getPlayerList().get(i)
					.setGoalReceived(Integer.parseInt(c[5]));

			i++;

		}

		br.close();

	}

	@Override
	public void defineWinnerTeamAndRatingPoints(ArrayList<Player> playerList) {

		int goalMade_A = 0;
		int goalMade_B = 0;

//Counting goal made of each team	
		for (Player player : playerList) {

			if (player.getTeamName().contains(" A")) {
				goalMade_A += player.getGoalMade();

			} else if (player.getTeamName().contains(" B")) {
				goalMade_B += player.getGoalMade();

			}

		}

//Defining winner team and add 10 extra points to each player of the winner team		
		if (goalMade_A > goalMade_B) {

			for (Player player : playerList) {
				if (player.getTeamName().contains(" A"))
					player.setRatingPoints(10);
			}

		} else {

			for (Player player : playerList) {
				if (player.getTeamName().contains(" B"))
					player.setRatingPoints(10);
			}

		}

// Counting rating points of each player
		for (Player player : playerList) {
			player.setRatingPoints(
					player.getGoalMade() * 2 + player.getGoalReceived() * (-1));
		}

	}

}
