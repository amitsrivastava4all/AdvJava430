

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/loginpage")
/*@WebServlet(
urlPatterns = "/loginpage",
loadOnStartup = 1,
initParams =
{
    @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
    @WebInitParam(name = "dburl", value = "localhost:3306/mydb")
})*/
public class LoginPage extends HttpServlet {
	
	public void init(){
		System.out.println("Servlet Init Called....");
	}
	
	private String doDesign(String msg){
		
		String design = "";/*"<!DOCTYPE html> "*/
		/*+"<html>"
		+"<head>"
		+"<meta charset='ISO-8859-1'>"
		+"<title>Login Page</title>"
		+"</head>"
		+"<body>";*/
		String drivername = this.getServletConfig().getInitParameter("driver");
		String email = this.getServletConfig().getInitParameter("email");
		String emailId = this.getServletContext().getInitParameter("email");
		if(msg!=null && msg.length()>0){
			design = design + "<h1>"+msg+"</h1>";
		}
		design = design +"<form method='post' action='loginpage'> "+drivername+" "+email+" "+emailId
		+"<table>"
		+"<tr>"
		+"<td>"
		+"<label>Userid</label>"
		+"</td>"
		+"<td><input type='text' name='userid'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td>"
		+"<label>Password</label>"
		+"</td>"
		+"<td><input type='password' name='pwd'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td>"
		+"<label>Color</label>"
		+"</td>"
		+"<td><input type='color' name='favcolor'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td>"
		+"<label></label>"
		+"</td>"
		+"<td><input type='hidden' name='branch' value='Noida'/></td>"
		+"</tr>"
		
		+"<tr>"
		+"<td><input type='submit'/></td>"
		+"<td><input type='reset'/></td>"
		+"</tr>"
		+"</table>"
		+"</form>";
		/*+"</body>"
		+"</html>";*/
		return design;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO GET CALL");
		//response.setHeader("refresh", "1");
		
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("header");
		rd.include(request, response);
		Enumeration<String> en = request.getHeaderNames();
		String temp = "";
		while(en.hasMoreElements()){
			String headerName = en.nextElement();
			String headerValue = request.getHeader(headerName);
			temp = temp + headerName+" "+headerValue+" <BR>";
		}
		out.println(this.doDesign(temp));
		RequestDispatcher rd2 = request.getRequestDispatcher("FooterServlet");
		rd2.include(request, response);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO POST CALL");
		PrintWriter out = response.getWriter();
		String userid  = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String favcolor = request.getParameter("favcolor");
		String branch = request.getParameter("branch");
		boolean isCookieFound = false;
		if(userid.equals(password)){
			// It creates New Session
			Cookie cookieArray[]= request.getCookies();
			if(cookieArray!=null && cookieArray.length>0){
				for(Cookie c : cookieArray){
					if(c.getName().equals("favcolor")){
						isCookieFound = true;
						break;
					}
				}
			}
			if(!isCookieFound){
				Cookie cookie = new Cookie("favcolor", favcolor);
				cookie.setMaxAge(365*24*60*60);
				response.addCookie(cookie);
			}
			HttpSession session = request.getSession(true);  // Session No
			session.setAttribute("uid", userid);
			
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			//session.setMaxInactiveInterval(1*60);
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");

			//RequestDispatcher rd = request.getRequestDispatcher("welcome");
			//rd.forward(request, response);
			String urlWithSessionId = response.encodeRedirectURL("welcome.lms");
			System.out.println("URLWithSessionId "+urlWithSessionId);
			//response.sendRedirect("welcome");
			response.sendRedirect(urlWithSessionId);
			//out.println("Welcome "+userid);
		}
		else
		{
			out.println(this.doDesign("Invalid Userid or Password"));
		}
		
	}

}
