package org.practice.Ankit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1
 */
/*@WebServlet(
		name = "DemoPattern", 
		description = "Practicing the Servelt Demo", 
		urlPatterns = { 
				"/DemoPatternPath", 
				"/DemoPattern1"
		})*/
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello from Demo pattern inside Get method");
		PrintWriter out=response.getWriter();
		out.println("<h1>Hello from Demo1 goGet</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello from Demo pattern inside Post method");
		PrintWriter out=response.getWriter();
		out.println("<h1>Hello from Demo1 goPost</h1>");
	}

}
