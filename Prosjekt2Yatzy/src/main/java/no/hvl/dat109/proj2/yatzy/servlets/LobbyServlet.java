package no.hvl.dat109.proj2.yatzy.servlets;

import static services.UrlMappings.LOBBY_URL;

import java.io.IOException;
import java.util.List;

import dao.LobbyDAO;
import entities.Lobby;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.RegisterForm;


@WebServlet("/" + LOBBY_URL)
public class LobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LobbyDAO ldao;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RegisterForm registerForm = new RegisterForm(request);
//		RegisterForm registerForm = new RegisterForm(request.getAttribute("registerForm"));

		request.getRequestDispatcher("WEB-INF/jsp/lobby.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
//		session.getAttribute(LOBBY_URL);
		List<Lobby> lobby = ldao.getAll();
		RegisterForm registerForm = new RegisterForm(request);
		session.setAttribute("registerForm", registerForm);
		
		response.sendRedirect(LOBBY_URL);
	}

}
