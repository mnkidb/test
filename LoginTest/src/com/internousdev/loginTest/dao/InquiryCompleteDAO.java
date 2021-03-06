package com.internousdev.loginTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.loginTest.dto.InquiryDTO;
import com.internousdev.loginTest.util.DBConnector;

public class InquiryCompleteDAO {

	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public List<InquiryDTO> getInquiryList(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM inquiry";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return inquiryDTOList;
	}

	public int setInquiryList(String name,String qtype,String body){

		int i = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO inquiry(name,qtype,body) VALUES(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2,qtype);
			ps.setString(3, body);

			i = ps.executeUpdate();

			if(i>0){
				System.out.println(i + "件登録されました。");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return i;

	}

	public List<InquiryDTO> getInquiryDTO(){
		return inquiryDTOList;
	}

}
