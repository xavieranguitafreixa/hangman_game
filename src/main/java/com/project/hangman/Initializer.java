package com.project.hangman;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer { // <1>

	public Initializer() {
		super(Config.class); // <2>
	}
}
