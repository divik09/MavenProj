package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserDTO;



public class UserModel {
	
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int nextPK() throws SQLException {
		int pk = 0;
		
		 PreparedStatement pre = con.prepareStatement("select max(id) from st_user");
		   ResultSet rs =  pre.executeQuery();
		     while(rs.next()) {
		    	 pk=rs.getInt(1);
		     }
		     return pk + 1;
	}
	
	public static UserDTO retrieve() throws Exception {
		
		UserDTO dto = new UserDTO();
	  PreparedStatement pre = con.prepareStatement("Select * from st_user");
	    ResultSet rs =  pre.executeQuery();
	    while(rs.next()) {
	    	dto.setId(rs.getInt(1));
	      dto.setEmail(	rs.getString(2));
	      dto.setPassword(rs.getString(3));
	      dto.setFirstName(rs.getString(4));
	      dto.setLastName(rs.getString(5));
	    }
	  
	  return dto;
	}
	public static void main(String[] args) throws Exception {
	 	System.out.println("This is NextPK= "+nextPK());
	   UserDTO dto = retrieve();
	   System.out.println(dto.getId());
	
	}

}
