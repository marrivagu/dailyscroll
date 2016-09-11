package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.blog.beans.Post;
import com.blog.beans.StandaloneJDBC;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class BlogDao {
	
	public List<Post> getAllPosts() throws SQLException{	
		List<Post> postList = new ArrayList<>();
		Connection con = StandaloneJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT * FROM posts");
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setPostID(rs.getInt("postid"));
				post.setUsername(rs.getString("username"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPosttext(rs.getString("posttext"));
				post.setCreateddate(rs.getString("createddate"));
				postList.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			ps.close();
			rs.close();
			con.close();
		}
		java.util.Collections.reverse(postList);
		return postList;
	}
	
	public List<Post> getPostsByUsername(String username) throws SQLException{
		List<Post> postList = new ArrayList<>();
		Connection con = StandaloneJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT * FROM posts WHERE username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setPostID(rs.getInt("postid"));
				post.setUsername(rs.getString("username"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPosttext(rs.getString("posttext"));
				post.setCreateddate(rs.getString("createddate"));
					postList.add(post);
					System.out.println(postList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			ps.close();
			rs.close();
			con.close();
		}
		java.util.Collections.reverse(postList);
		return postList;
		
	}

}
