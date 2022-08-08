package no.hvl.dat109.proj2.yatzy.servlets;

import static no.hvl.dat109.proj2.yatzy.services.UrlMappings.LOGGINN_URL;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;          // Tomcat 10
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.services.PlayerForm;
//import util.PasswordUtil;
/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/" + LOGGINN_URL)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	private PlayerForm playerForm;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		session = request.getSession(true);
		
//		Skjema_OLD skjema = new Skjema_OLD(request);
		Player player= new Player();
//		PasswordUtil passwordUtil = new PasswordUtil();
//		String hashMedSalt = passwordUtil.hashMedSalt(password, salt);
		boolean gyldig = false;


		String usernamerequest = request.getParameter("username");
		String passwordrequest = request.getParameter("password");
		
		if (usernamerequest != null && passwordrequest != null && dao.playerExists(usernamerequest)) {
			String pass = dao.password(usernamerequest);
			byte[] s = passwordUtil.extractSalt(pass);
			String salt = new String(s, StandardCharsets.UTF_8);

			if (PasswordUtil.validateWithSalt(passwordrequest, salt, pass)) {
				gyldig = true;
			}
			player.setUsername(usernamerequest);
		}
		if (gyldig == false) {
			session.removeAttribute("skjema");
			response.sendRedirect(LOGGINN_URL);

		} else {
			playerForm.setUpErrorMessages(dao);
//			request.getSession().setAttribute("skjema", skjema);
			session.setAttribute("skjema", playerForm);
			response.sendRedirect(LOGGINN_URL);


		}
	}

}
