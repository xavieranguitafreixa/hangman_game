package com.project.hangman;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class GameEntity extends AbstractEntity {

	String sessionId;
	
	String currentPhrase, expectedPhrase;
	
	String letter;
	
	short attempts, wrongAttempts;
	
	String status;
	
	String lastTry;

	protected GameEntity() {
	}
}
