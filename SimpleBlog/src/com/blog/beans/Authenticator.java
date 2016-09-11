package com.blog.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {

	public User authenticate(String username, String password) throws SQLException {
		Connection con = StandaloneJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();

		try {
			ps = con.prepareStatement("SELECT * FROM user where username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {

				user.setUserID(rs.getInt("userid"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return user;

		} finally {

			ps.close();
			rs.close();
			con.close();
		}

		return user;

	}
}
