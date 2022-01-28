package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class ForwardExampleServlet
 */
@WebServlet(value = "/forward",
initParams = {
		@WebInitParam(name = "driver", value = "dirver value"),
}
)
public class ForwardExampleServlet extends HttpServlet {
	private final static Log log = LogFactory.getLog(ForwardExampleServlet.class);
	
	private String driver;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardExampleServlet() {
        super();
        log.info("---------- > new ForwardExampleServlet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init();
		log.info("---------- > Method Init");
		this.driver = config.getInitParameter("driver");
		log.info("---------- > Driver : "+driver);
	}

//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		super.service(req, res);
//		HttpServletRequest request = (HttpServletRequest) req;
//		log.info("---------- > Method Service :"+request.getMethod());
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("---------- > doGet");
		// get la valeur du parametre dans l'url
		String forward = request.getParameter("forwardTo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
