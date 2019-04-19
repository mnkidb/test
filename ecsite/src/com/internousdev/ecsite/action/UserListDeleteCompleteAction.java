package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	private String message;
	private Map<String,Object> session;
	List<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();

	public String execute(){

		String result = SUCCESS;

		UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();

		int i = dao.userDelete();

		if(i > 0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(i == 0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}

		return result;
	}


	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
