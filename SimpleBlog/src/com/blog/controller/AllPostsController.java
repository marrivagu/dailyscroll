package com.blog.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.beans.Post;
import com.blog.beans.StandaloneJDBC;
import com.blog.dao.BlogDao;

public class AllPostsController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Connection con = StandaloneJDBC.getConnection();
		//PreparedStatement ps = null;
		RequestDispatcher rd = null;
		List<Post> postList = new ArrayList<Post>();
		BlogDao blogDao = new BlogDao();
		

		try {
			
			postList = blogDao.getAllPosts();
			System.out.println(postList.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//ps.close();
				con.close();
				rd = request.getRequestDispatcher("/success.jsp");
				request.setAttribute("postList", postList);
				request.setAttribute("username", request.getParameter("username"));
			rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
