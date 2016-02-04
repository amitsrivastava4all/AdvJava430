

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		String userid  = request.getParameter("userid");
			String password = request.getParameter("pwd");
			if(userid.equals(password)){
				// It creates New Session
				HttpSession session = request.getSession(true);  // Session No
				session.setAttribute("uid", userid);
				
				//RequestDispatcher rd = request.getRequestDispatcher("welcome");
				//rd.forward(request, response);
				response.sendRedirect("welcome");
				//out.println("Welcome "+userid);
			}
			else
			{
				out.println("Invalid Userid or Password");
			}
			out.close();
	}

}
