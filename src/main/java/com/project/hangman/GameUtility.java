package com.project.hangman;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class GameUtility {

	protected final static int MAX_ATTEMPTS = 6;

	protected boolean isLost(int wrongAttempts) {
		return MAX_ATTEMPTS == wrongAttempts;
	}

	protected boolean isWin(int wrongAttempts, String currentPhrase, String expectedPhrase) {
		return currentPhrase.equals(expectedPhrase) && wrongAttempts < MAX_ATTEMPTS;
	}

	protected boolean isLetterInPhrase(String expectedPhrase, String letter) {
		return expectedPhrase.contains(letter);
	}

	protected boolean isLetterFindBefore(String currentPhrase, String letter) {
		return currentPhrase.contains(letter);
	}

	protected String checkGuess(String expectedPhrase, String currentPhrase, String guessString) {
		char guess = guessString.charAt(0);
		guess = Character.toLowerCase(guess);
		StringBuilder sb = new StringBuilder(currentPhrase);
		for (int index = 0; index < expectedPhrase.length(); index++) {
			if (Character.toLowerCase(expectedPhrase.charAt(index)) == guess) {
				sb.setCharAt(index, expectedPhrase.charAt(index));
			}
		}
		return sb.toString();
	}

	protected String getNextWord() {
		String nextWord = "hola";
		int i = new Random().nextInt(4 - 1 + 1) + 1;
		switch (i) {
		case 1:
			nextWord = "hola";
			break;
		case 2:
			nextWord = "holaquehaces";
			break;
		case 3:
			nextWord = "adeuquehaces";
			break;
		case 4:
			nextWord = "eiquehaces";
			break;
		default:
			nextWord = "adeu";
			break;
		}
		return nextWord;
	}

	public void setToSession(HttpServletRequest req, GameEntity g) {
		req.getSession().setAttribute("expectedPhrase", g.expectedPhrase);
		req.getSession().setAttribute("currentPhrase", g.currentPhrase);
		req.getSession().setAttribute("wrongAttempts", g.wrongAttempts);
		req.getSession().setAttribute("attempts", g.attempts);
		req.getSession().setAttribute("lastTry", g.lastTry);
		req.getSession().setAttribute("sessionId", g.sessionId);
		req.getSession().setAttribute("status", g.status);
		
		String prefix = "/static/img_";
		String post = ".png";
		String name = prefix + g.wrongAttempts + post;
		req.getSession().setAttribute("img", name);
	}

	public GameEntity startGame(String sessionId, GameEntity gOld) {

		GameEntity g = new GameEntity();

		if (gOld != null) {
			g.id = gOld.id;
		}

		g.expectedPhrase = getNextWord();
		g.currentPhrase = g.expectedPhrase.replaceAll(".", "*");
		g.attempts = 0;
		g.wrongAttempts = 0;
		g.sessionId = sessionId;
		g.status = "started";
		return g;
	}

}
