package com.project.hangman;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class GameUtilityTest {
	
	@Autowired
	GameUtility utility;

	@Rollback(false)
	@Test
	@Transactional
	public void testCheckGuessCorrect() {
		
		utility = new GameUtility();

		String expectedPhrase = "hola";
		String currentPhrase = "h**a";
		String guessString = "o";
		String expectedResult = "ho*a";

		String obtainedResult = utility.checkGuess(expectedPhrase, currentPhrase, guessString);

		Assert.assertEquals(expectedResult, obtainedResult);
	}
	
	@Rollback(false)
	@Test
	@Transactional
	public void testCheckGuessFalse() {
		
		utility = new GameUtility();

		String expectedPhrase = "hola";
		String currentPhrase = "h**a";
		String guessString = "o";
		String notExpectedResult = "hola";

		String obtainedResult = utility.checkGuess(expectedPhrase, currentPhrase, guessString);

		Assert.assertNotEquals(notExpectedResult, obtainedResult);
	}

}
