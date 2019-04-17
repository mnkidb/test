package com.internousdev.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.loginTest.dto.LoginDTO;
import com.internousdev.loginTest.util.DBConnector;

public class TestDAO {

	List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public int newRegist(String userName,String password){

		int ret = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO user_info(user_name, user_pass) VALUES(?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			int i = ps.executeUpdate();

			if(i>0){
				System.out.println(i + "件登録されました");
				ret = i;
			}


		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return ret;
	}

	public List<LoginDTO> select(String userName, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE user_name=? AND user_pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LoginDTO dto = new LoginDTO();

				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("user_pass"));

				loginDTOList.add(dto);
			}

			if(loginDTOList.size() <= 0){
				LoginDTO dto = new LoginDTO();
				dto.setUserName("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
				System.out.println("リストなし");
			}else{
				System.out.println("リストあり");
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
