package no.hvl.dat109.proj2.yatzy.servlets;

import static no.hvl.dat109.proj2.yatzy.services.UrlMappings.LOBBY_URL;
import static no.hvl.dat109.proj2.yatzy.services.UrlMappings.REGISTERFORM_URL;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.proj2.yatzy.controller.Main;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Sentral;
import no.hvl.dat109.proj2.yatzy.services.LobbyService;
import no.hvl.dat109.proj2.yatzy.services.PlayerForm;
import no.hvl.dat109.proj2.yatzy.services.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/" + REGISTERFORM_URL)
//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PlayerDAO dao;
	LobbyService lobbyService;
	Sentral sentral;
	Main main;
	
//	public RegisterServlet() {
//		
//	}
       
   @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/register.jsp")
		.forward(request, response);
		
	}

   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session = request.getSession(false);
		
	   //Trengs ikkje for denne oppgaven
//		MyValidator validator = new MyValidator();
	   
	   
//		Player player = new Player();
		PlayerDAO dao = new PlayerDAO();
//		HashMap<String, Toast> map = new HashMap<String, Toast>();
		boolean allowed = true;
		
		if (session != null) {
			session.invalidate();
		}
		session = request.getSession(true);
		PlayerForm playerForm = new PlayerForm();
//		playerForm.populateFromRequestAndSetUpErrors(request, dao);
		
//		player = new Player(request);
		RegisterForm registerForm = new RegisterForm(request);
		try {
		if (registerForm.isAllInputGyldig()) {

			//opprette Person og lagre i database
//			Person p = skjema.lagPerson();
			//....
			
			//Oppretter spiller
			Player player = new Player(request);
			//Populate database with player
			
			
			//Legger til spillere i oversikten over alle spillere som ikke er i en lobby
//			Sentral sentral = main.getSentral(); //E DETTE L�V?
			
			
			
			//pr�ver � sende playerForm fra RegisterServlet til LobbyServlet
			request.setAttribute("registerForm",registerForm);
			RequestDispatcher rd = request.getRequestDispatcher(LOBBY_URL);
			rd.forward(request,response);

			//original
//			request.getSession().removeAttribute("registerForm");
//			response.sendRedirect(LOBBY_URL);
		} else {
				
			//gjøre klart skjema med feilmeldinger ++
			registerForm.setupErrorMessage();
			
			request.getSession().setAttribute("registerForm", registerForm);
//			session.setAttribute("skjema", skjema);

			response.sendRedirect(REGISTERFORM_URL);
		}
		} catch (NullPointerException e) {
//			skjema.setKjonnFeilmelding("Du m� oppgi kjonn!");
			registerForm.clearPassord();
			request.getSession().setAttribute("registerForm", registerForm);
			response.sendRedirect(REGISTERFORM_URL);

		}
//		
//
//       String username = request.getParameter("username");
//
//       if (username == null || !Validator.isValidUsername(username)) {
//           response.sendRedirect("PaaMeldingServlet" + "?invalidUsername");
//       } else {
//
//           HttpSession sesjon = request.getSession(false);
//           if (sesjon != null) {
//               sesjon.invalidate();
//           }
//           sesjon = request.getSession(true);
//           sesjon.setMaxInactiveInterval(10);
//
//           sesjon.setAttribute("username", username);
////           sesjon.setAttribute("cart", new Cart());
//
//           response.sendRedirect("PaaMeldingServlet");
//       }
		
	}

}
