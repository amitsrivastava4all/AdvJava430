

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome.lms")
public class WelcomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drivername = this.getServletConfig().getInitParameter("driver");
		String email = this.getServletConfig().getInitParameter("email");
		String emailId = this.getServletContext().getInitParameter("email");
		String msg = (String)this.getServletContext().getAttribute("message");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		/*if(session ==null){
			response.sendRedirect("login.html");
		}*/
		/*else{*/
			String color = "aqua";
			Cookie cookieArray[]= request.getCookies();
			if(cookieArray!=null && cookieArray.length>0){
				for(Cookie c : cookieArray){
					if(c.getName().equals("favcolor")){
						color = c.getValue();
						break;
					}
				}
			//}
		String userid  = (String)session.getAttribute("uid");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		out.println("<html><body bgcolor='"+color+"'> "+drivername+" "+email+ " "+emailId);
		out.println("Welcome "+userid+" Count is "+SessionCountListener.sessionCount);
		String urlWithSession = response.encodeURL("logout");
		System.out.println("URL ---> "+urlWithSession);
		//out.println("<form action='logout' method='post'>");
		out.println("<form action='"+urlWithSession+"' method='post'>");
		out.println("<input type='submit' value='Logout'>");
		out.println("</form></body></html>");
		
		out.println("Your Account Balance is 0 and Message From Admin is "+msg);
		out.close();
		}
	}

}
