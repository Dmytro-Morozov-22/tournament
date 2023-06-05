package ua.ss.tt;

public class Player {
	private String player;
	private String nickname;
	private String number;
	private String teamName;

	private int rebounds;
	private int assists;
	private int scoredPoints;

	private int goalMade;
	private int goalReceived;
	
	private int ratingPoints;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getScoredPoints() {
		return scoredPoints;
	}

	public void setScoredPoints(int scoredPoints) {
		this.scoredPoints = scoredPoints;
	}

	public int getGoalMade() {
		return goalMade;
	}

	public void setGoalMade(int goalMade) {
		this.goalMade = goalMade;
	}

	public int getGoalReceived() {
		return goalReceived;
	}

	public void setGoalReceived(int goalReceived) {
		this.goalReceived = goalReceived;
	}

	public int getRatingPoints() {
		return ratingPoints;
	}

	public void setRatingPoints(int ratingPoints) {
		this.ratingPoints += ratingPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assists;
		result = prime * result + goalMade;
		result = prime * result + goalReceived;
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ratingPoints;
		result = prime * result + rebounds;
		result = prime * result + scoredPoints;
		result = prime * result
				+ ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (assists != other.assists)
			return false;
		if (goalMade != other.goalMade)
			return false;
		if (goalReceived != other.goalReceived)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (ratingPoints != other.ratingPoints)
			return false;
		if (rebounds != other.rebounds)
			return false;
		if (scoredPoints != other.scoredPoints)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [player=" + player + ", nickname=" + nickname
				+ ", number=" + number + ", teamName=" + teamName
				+ ", rebounds=" + rebounds + ", assists=" + assists
				+ ", scoredPoints=" + scoredPoints + ", goalMade=" + goalMade
				+ ", goalReceived=" + goalReceived + ", ratingPoints="
				+ ratingPoints + "]";
	}
	
}// Player
