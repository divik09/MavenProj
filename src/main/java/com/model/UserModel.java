package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserModel {
	
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int nextPK() throws SQLException {
		int pk = 0;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ors_3","root","root");
		 PreparedStatement pre = con.prepareStatement("select max(id) from st_user");
		   ResultSet rs =  pre.executeQuery();
		     while(rs.next()) {
		    	 pk=rs.getInt(1);
		     }
		     return pk + 1;
	}
	public static void main(String[] args) throws SQLException {
		System.out.println("This is NextPK= "+nextPK());
	}

}
