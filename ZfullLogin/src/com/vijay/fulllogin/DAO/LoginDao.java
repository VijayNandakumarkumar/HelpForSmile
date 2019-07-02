package com.vijay.fulllogin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public boolean check(String username, String password) {
		String url = "jdbc:mysql://localhost:3306/test";
		String uname = "root";
		String pass = "";
		String query = "Select * from login where uname=? and pass=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("in db --- "+ rs.getString("email_id"));
				con.close();
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
