package com.project.hangman;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/newGame")
public class NewGameServlet extends HttpServlet {

	private static final long serialVersionUID = 2878267318695777395L;

	@Autowired
	GameRepository repository;

	@Autowired
	GameService service;

	@Autowired
	GameUtility utility;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sessionId = req.getSession().getId();
		System.out.println("sessionId: " + sessionId);

		GameEntity g = service.findBySessionId(sessionId);
		if (g != null) {
			g = utility.startGame(sessionId, g);
		} else {
			g = utility.startGame(sessionId, null);
		}

		utility.setToSession(req, g);

		service.save(g);

		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

}
// tag::end[]
