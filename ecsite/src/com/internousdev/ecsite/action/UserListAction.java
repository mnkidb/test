package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private UserListDAO userListdao = new UserListDAO();
	private List<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();

	public String execute(){

		String result=SUCCESS;

		userInfoList = userListdao.readUserList();
		session.put("userInfoList", userInfoList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setUserInfoList(List<UserInfoDTO> userInfoList){
		this.userInfoList=userInfoList;
	}

	public List<UserInfoDTO> getUserInfoList(){
		return userInfoList;
	}

}
