

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.html");
		}
		else{
			session.removeAttribute("uid");
			session.invalidate();
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Logout SuccessFully....</h1><a href='login.html'>Click to Login Again </a></body></html>");
			out.close();
		}
	}

}
