package ua.ss.tt;

@SuppressWarnings("serial")
public class NotUniqueNicknameException extends Exception {

	@Override
	public String toString() {
		String message = "Please ensure that each player has a unique nickname";
		return message;
	}

}
