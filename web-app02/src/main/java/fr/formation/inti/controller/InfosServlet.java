package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class InfosServlet
 */
@WebServlet("/infos")
public class InfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(InfosServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfosServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		/*
		 *  Avec false, il récupère une session mais n'en crée pas s'il n'y en a pas
		 *  Avec true, il crée une nouvelle session dans tous les cas
		 *  Sans argument, il récupère la session existante ou en crée une
		 */
//		if (session == null || session.getAttribute("login") == null) {
//			response.sendRedirect("index.jsp");
//			return;
//		}
		log.info(">>>>>>>>>>>>>>>>>>>> test message");
		// SendRedirect tout seul continue quand même l'exzcution du code
		// On rajoute return pour éviter la suite du code
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title> infos Servlet </title></head>");
		String requestUrl = request.getRequestURL().toString();
		out.println("<br><span>requestURL : " + requestUrl + "</span>");

		String requestUri = request.getRequestURI();
		out.println("<br><span>requestURI : " + requestUri + "</span>");

		String contextPath = request.getContextPath();
		out.println("<br><span>contextPath : " + contextPath + "</span>");
		
		// Header infos
		out.println("<br><br><b>Headers :</b>");
		
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br> "+header+" : "+request.getHeader(header));
		}
		
		// Emplacement de l'application dans le HDD
		out.println("<br><br><b>Real path :</b>");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("");
		out.print(realPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title> infos Servlet </title></head>");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		out.println("<h1> Method post : " + login + "-" + password + "</h1>");
	}
}
