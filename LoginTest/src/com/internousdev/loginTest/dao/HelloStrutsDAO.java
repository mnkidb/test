package com.internousdev.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.loginTest.dto.HelloStrutsDTO;
import com.internousdev.loginTest.util.DBConnector;

public class HelloStrutsDAO{

	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public List<HelloStrutsDTO> select(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user_info";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("user_pass"));
				dto.setResult("MySQLと接続できます。");
				helloStrutsDTOList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return helloStrutsDTOList;

	}

}
