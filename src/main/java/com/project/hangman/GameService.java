package com.project.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;

	@Autowired
	private GameUtility utility;
	
	private static final String STATUS_WON = "Congratulations, you won";
	private static final String STATUS_LOST = "Sorry, you lost";
	private static final String STATUS_PLAYING = "Choose the next letter...";
	
	
	public void save(GameEntity g) {
		repository.save(g);
	}
	
	
	public GameEntity findBySessionId(String sessionId) {
		return repository.findBySessionId(sessionId);
	}
	

	public GameEntity nextMove(String guessString, String sessionId) {

		// i have the letter and i have the game
		GameEntity g = repository.findBySessionId(sessionId);

		short attempts = g.attempts;
		short wrongAttempts = g.wrongAttempts;
		String currentPhrase = g.currentPhrase;
		String expectedPhrase = g.expectedPhrase;
		String status = g.status;
		String lastTry = g.lastTry;
		Long id = g.id;

		// boolean isGameFinished = utility.isLost(g.wrongAttempts);
		

		String nextCurrentPhrase = utility.checkGuess(expectedPhrase, currentPhrase, guessString);

		lastTry = "correct";
		if (nextCurrentPhrase.equals(currentPhrase)) {
			lastTry = "incorrect";
			wrongAttempts++;
		}

		attempts++;

		if (nextCurrentPhrase.equals(expectedPhrase)) {
			status = STATUS_WON;
		}else if (wrongAttempts >= GameUtility.MAX_ATTEMPTS) {
			status = STATUS_LOST;
		} else {
			status = STATUS_PLAYING;
		}

		GameEntity g2 = new GameEntity();
		g2.id = id;
		g2.attempts = attempts;
		g2.wrongAttempts = wrongAttempts;
		g2.status = status;
		g2.currentPhrase = nextCurrentPhrase;
		g2.expectedPhrase = expectedPhrase;
		g2.lastTry = lastTry;
		g2.sessionId = sessionId;

		repository.save(g2);

		return g2;
	}
}
