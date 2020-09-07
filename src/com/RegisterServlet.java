package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfPassword = request.getParameter("cnfpwd");
		String gender = request.getParameter("gender");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(name.isEmpty() || email.isEmpty() || password.isEmpty() || cnfPassword.isEmpty() || gender.isEmpty()) {
			out.println("<h1>None of the field should be empty!</h1>");
		}else if(!(password.equals(cnfPassword))) {
			out.println("<h1>Password and confirm password should be equal!</h1>");
		}else {
			out.println("<h1>User login successfull !!</h1>");
			out.println("<h2>User details are :</h2>");
			out.println("<h3>Name: "+name+"</h3>");
			out.println("<h3>Email: "+email+"</h3>");
			out.println("<h3>Password: "+password+"</h3>");
			out.println("<h3>Gender: "+gender+"</h3>");
		}
	}

}
