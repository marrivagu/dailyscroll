package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");

		String n = request.getParameter("userName");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		RequestDispatcher rd = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			
			PreparedStatement ps = con.prepareStatement("insert into user(userName,password,email) values (?,?,?)");
			//ps.setInt(1, 1);
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);

			int i = ps.executeUpdate();
			if (i > 0) {
				//out.print("You are successfully registered...");
				rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("regsuccess","You are registered successfully, Please login");
			}
			con.close();

		} catch (Exception e2) {
			//System.out.println("HHN : " + e2);
			System.out.println(e2.getMessage());
		}

		rd.forward(request, response);
	}
}
