package com.project.hangman;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 2878267318695777395L;

	@Autowired
	GameService service;
	
	@Autowired
	GameUtility utility;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sessionId = req.getSession().getId();
		System.out.println("sessid: " + sessionId);
		GameEntity g = service.findBySessionId(sessionId);
		if (g != null) {
			utility.setToSession(req, g);
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("newGame");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String letter = req.getParameter("letter");
		String sessid = req.getSession().getId();

		System.out.println("sessid2: " + sessid);
		System.out.println("letter2: " + letter);

		// recalculate next step
		GameEntity g = service.nextMove(letter, sessid);
		utility.setToSession(req, g);

		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

}