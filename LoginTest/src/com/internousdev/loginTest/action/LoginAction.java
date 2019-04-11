package com.internousdev.loginTest.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.loginTest.dao.LoginDAO;
import com.internousdev.loginTest.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String userName;
	private String password;


	public String execute(){

		String ret;

		LoginDAO dao = new LoginDAO();
		List<LoginDTO> loginDTOList = dao.select(userName, password);

		if(!(loginDTOList.isEmpty())){

			userName = loginDTOList.get(0).getUserName();
			password = loginDTOList.get(0).getPassword();

			session.put("loginDTOList", loginDTOList);

			ret = SUCCESS;

		}else{

			userName="該当なし";
			password="該当なし";

			ret=ERROR;
		}

		return ret;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}



}
