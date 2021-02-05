package ControllerServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import model.LoginBean;
import model.ApiBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApiBean lineType = new ApiBean();
		lineType.setLineType();
		request.setAttribute("lineType", lineType);

		ApiBean journeyDateTime = new ApiBean();
		journeyDateTime.setJourneyTime();
		request.setAttribute("journeyDateTime", journeyDateTime);

		ApiBean journeyTo = new ApiBean();
		journeyTo.setJourneyTowards();
		request.setAttribute("journeyTo", journeyTo);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean bean = new LoginBean();

		bean.setName(username);
		bean.setPassword(password);

		request.setAttribute("bean", bean);

		boolean status = bean.validate();

		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}

	}

}
