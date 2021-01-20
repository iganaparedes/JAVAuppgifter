package uppgift2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Uppgift2
 */
@WebServlet("/Uppgift2")
public class Uppgift2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uppgift2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		
		
		String userOne = request.getParameter("usernameOne");
		String passOne = request.getParameter("passOne");
		String userTwo = request.getParameter("usernameTwo");
		String passTwo = request.getParameter("passTwo");
		
		LoginBean beanOne = new LoginBean();
		beanOne.setName(userOne);
		beanOne.setPassword(passOne);
		request.setAttribute("beanOne", beanOne);
		boolean statusOne = beanOne.validateOne();
		
		LoginBean beanTwo = new LoginBean();
		
		beanTwo.setName(userTwo);
		beanTwo.setPassword(passTwo);
		request.setAttribute("beanTwo", beanTwo);
		boolean statusTwo = beanTwo.validateTwo();
		
		try {
		
		if(statusOne) {
			RequestDispatcher rd1 = request.getRequestDispatcher("LoggedInUserOne.jsp");
			rd1.forward(request, response);
			Cookie ck1 = new Cookie("UserOne", "Monkey");
			response.addCookie(ck1);
			
		}
		else if(statusTwo) {
			RequestDispatcher rd2 = request.getRequestDispatcher("LoggedInUserTwo.jsp");
			rd2.forward(request, response);
			Cookie ck1 = new Cookie("UserTwo", "Dog");
			response.addCookie(ck1);
		}
		else {
			out.print("Wrong password!");
			RequestDispatcher rd3 = request.getRequestDispatcher("index.jsp");
			rd3.forward(request, response);
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
