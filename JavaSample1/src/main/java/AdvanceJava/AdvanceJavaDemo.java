package AdvanceJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdvanceJavaDemo
 */
@WebServlet("/DemoJava")
public class AdvanceJavaDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException{
        System.out.println("Hello World");

	}
    

}
