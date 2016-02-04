

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowImages
 */
@WebServlet("/ShowImages")
public class ShowImages extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> products = new ArrayList<>();
		products.add(1001);
		products.add(1002);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for(Integer i : products){
			out.println("<img src='images/"+i+".jpg'><br>");
		}
		out.println("</body></html>");
		out.close();
		
	}

}
