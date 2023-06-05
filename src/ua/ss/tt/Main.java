package ua.ss.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
//This part of the code requests the number of players from the console
//and provides some checks
		boolean flag = true;
		int numberOfPlayers = 0;
		while (flag) {
			System.out.println("Please enter the number of players in the games");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int consoleData = sc.nextInt();
				if (consoleData % 2 == 0 && consoleData > 0) {
					numberOfPlayers = consoleData;
					sc.close();
					flag = false;

				} else {
					System.out.println(
							"The number of players must be even. Please enter "
									+ "an even number");
				}
			} else {
				System.out.println("Please enter an even number");
			}
		}

		Tournament tournament = new Tournament();
//Create empty player objects
		tournament.createObjectsForTornament(numberOfPlayers);

		Handball handball = new Handball();
		Basketball basketball = new Basketball();
		try {
			File folder = new File("CSV_files");

//Checking for the wrong format of files
			for (File file : folder.listFiles()) {
				if (!(file.getName().contains(".csv"))) {
					throw new WrongFileFormatException();
				}
			}

			for (File file : folder.listFiles()) {
				String firstLine = "";
				BufferedReader br = new BufferedReader(new FileReader(file));
				firstLine = br.readLine().toUpperCase();
//Defining the type of game. If you want to add one more game you must add
//one more "else if" statement for new game
				if (firstLine.contains("BASKETBALL")) {
					basketball.createTeam(file, tournament);
					basketball.defineWinnerTeamAndRatingPoints(tournament.getPlayerList());
				} else if (firstLine.contains("HANDBALL")) {
					handball.createTeam(file, tournament);
					handball.defineWinnerTeamAndRatingPoints(tournament.getPlayerList());

				}
				br.close();

//This part of the code checks for the uniqueness of the nickname
				Set<String> uniqueNicknames = new HashSet<String>();
				for (Player player : tournament.getPlayerList()) {
					boolean checkForUnique = uniqueNicknames
							.add(player.getNickname());
					if (!checkForUnique) {
						System.out.println("The nickname of \""
								+ player.getPlayer() + "\" is not unique");
						throw new NotUniqueNicknameException();
					}
				}

			}
			
//Displaying all players to the console
			for (Player p : tournament.getPlayerList())
				System.out.println(p);
			
//Calling the method "definingMVP" for defining Most Valuable Player
			tournament.definingMVP();
			
		} catch (WrongFileFormatException e) {
			System.out.println(e);
		} catch (NotUniqueNicknameException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println("You want to create more players than are "
					+ "actually in the csv file " + "\n" + "Please enter the  "
					+ "number of players according to the csv file");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("You want to create less players than are "
					+ "actually in the csv file " + "\n" + "Please enter the  "
					+ "number of players according to the csv file");
		}

	}// main

}// class
