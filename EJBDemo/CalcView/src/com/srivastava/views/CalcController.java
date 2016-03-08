package com.srivastava.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.models.CalcBeanRemote;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	@EJB
	CalcBeanRemote remote;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstNo = Integer.parseInt(request.getParameter("firstno"));
		int secondNo = Integer.parseInt(request.getParameter("secondno"));
		int result = remote.add(firstNo,secondNo);
		PrintWriter out = response.getWriter();
		out.println ("Sum is "+result);
		out.close();
		
	}

}
