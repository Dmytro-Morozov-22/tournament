package ua.ss.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Basketball extends Game {
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
					.setRebounds(Integer.parseInt(c[5]));
			tournament.getPlayerList().get(i)
					.setAssists(Integer.parseInt(c[6]));
			tournament.getPlayerList().get(i)
					.setScoredPoints(Integer.parseInt(c[4]));

			i++;
		}

		br.close();
	}
	
	@Override
	public void defineWinnerTeamAndRatingPoints(ArrayList<Player> playerList) {

		int scoredPoints_A = 0;
		int scoredPoints_B = 0;

//Counting scored points of each team	
		for (Player player : playerList) {

			if (player.getTeamName().contains(" A")) {
				scoredPoints_A += player.getScoredPoints();

			} else if (player.getTeamName().contains(" B")) {
				scoredPoints_B += player.getScoredPoints();

			}

		}

//Defining winner team and add 10 extra points to each player of the winner team
		if (scoredPoints_A > scoredPoints_B) {

			for (Player player : playerList) {
				if (player.getTeamName().contains(" A"))
					player.setRatingPoints(10);
			}
			System.out.println("A");
		} else {

			for (Player player : playerList) {
				if (player.getTeamName().contains(" B"))
					player.setRatingPoints(10);
			}
			System.out.println("B");
		}

//Counting rating points of each player		
		for (Player player : playerList) {
			player.setRatingPoints(player.getScoredPoints() * 2
					+ player.getRebounds() * 1 + player.getAssists() * 1);
		}

	}

}