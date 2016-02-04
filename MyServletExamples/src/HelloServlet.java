

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	private int counter;
	
	@Override
	public void init(){
		counter=0;
		System.out.println("Init Called....");	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		System.out.println("This is Service Method Call...");
		PrintWriter out = response.getWriter();
		out.println("<html><body>No of times Page Hit "+counter+"</body></html>");
		out.close();
	}
	@Override
	public void destroy(){
		System.out.println("Destroy Call");
	}

}
