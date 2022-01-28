package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.MaskFormatter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login",
		initParams = {
				@WebInitParam(name = "login", value = "root"),
				@WebInitParam(name = "password", value = "123456")
		}
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init();
    	this.login = config.getInitParameter("login");
    	this.password = config.getInitParameter("password");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("message");
		if (message == null) {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typedLogin = request.getParameter("login");
		String typedPassword = request.getParameter("password");
		if (login.equals(typedLogin) && password.equals(typedPassword)) {
			request.setAttribute("connexionDate", new Date());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
