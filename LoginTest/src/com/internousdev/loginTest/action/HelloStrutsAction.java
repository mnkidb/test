package com.internousdev.loginTest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.loginTest.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport implements SessionAware{

	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	private Map<String,Object> session;

	public String execute(){

		String ret = ERROR;

		return ret;
	}



	
	public String getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





}
