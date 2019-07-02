package com.ZfullLogin.SignuoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SignupDao {
	
	public Boolean check(String name, String id, String pwd) {
		String url = "jdbc:mysql://localhost:3306/test";
		String db_name = "root";
		String db_password = "";
		String query = "INSERT INTO `login`(`uname`, `pass`, `email_id`) VALUES (?, ?, ?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, db_name, db_password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, id);
			int row = ps.executeUpdate();
			if(row !=0) {
				System.out.println("db---");
				con.close();
				return true;
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
