package com.internousdev.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.loginTest.dto.LoginDTO;
import com.internousdev.loginTest.util.DBConnector;


public class LoginDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public List<LoginDTO> select(String userName, String password){

		List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

		String sql = "SELECT * FROM user_info WHERE user_name=? AND user_pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LoginDTO dto = new LoginDTO();
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("user_pass"));
				loginDTOList.add(dto);
			}

		}catch(SQLException e){

			e.printStackTrace();

		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return loginDTOList;

	}

}
