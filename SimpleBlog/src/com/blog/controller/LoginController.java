package com.blog.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.beans.Authenticator;
import com.blog.beans.Post;
import com.blog.beans.User;
import com.blog.dao.BlogDao;

import sun.text.normalizer.ICUBinary.Authenticate;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		List<Post> postList = new ArrayList<Post>();
		//List<Post> userPostList = new ArrayList<Post>();
		BlogDao blogDao = new BlogDao();
		Authenticator authenticator = new Authenticator();
		User user = new User();
		try {
			user = authenticator.authenticate(username, password);
			//postList = blogDao.getAllPosts();
			System.out.println(username);
			postList = blogDao.getPostsByUsername(username);
			System.out.println(postList.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("postList", postList);
			//request.setAttribute("userPostList", userPostList);
			request.setAttribute("username", user.getUsername());
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		RequestDispatcher rd = null;
		List<Post> postList = new ArrayList<Post>();
		//List<Post> userPostList = new ArrayList<Post>();
		BlogDao blogDao = new BlogDao();
		
		try {
			
			//postList = blogDao.getAllPosts();
			System.out.println(username);
			postList = blogDao.getPostsByUsername(username);
			System.out.println(postList.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("postList", postList);
			//request.setAttribute("userPostList", userPostList);
			request.setAttribute("username", username);
		
		rd.forward(request, response);
	}

}