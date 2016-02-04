

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminlogin")
public class AdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String msg = request.getParameter("msg");
		String hobby[] = request.getParameterValues("hobby");
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = request.getParameter(name);
		}
		Map<String,String[]> dataMap = request.getParameterMap();
		for(Map.Entry<String, String[]> map: dataMap.entrySet()){
			String name = map.getKey();
			String value = map.getValue()[0];
		}
		
		PrintWriter out = response.getWriter();
		if(userid.equals(password)){
			ServletContext sc = this.getServletContext();
			sc.setAttribute("message", msg);
			out.println("Message Send SuccessFully....");
			
		}
		else
		{
			out.println("Invalid Userid or Password ");
		}
		out.close();
	}

}
