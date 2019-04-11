package com.internousdev.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.loginTest.dto.TestDTO;
import com.internousdev.loginTest.util.DBConnector;

public class TestDAO {

	List<TestDTO> testDTOList = new ArrayList<TestDTO>();

	public int newRegist(String userName,String password){

		int ret = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO user_info(user_name, user_pass) VALUES(?,?)";

		TestDTO dto = new TestDTO();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			int i = ps.executeUpdate();


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

}