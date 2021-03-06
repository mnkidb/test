package com.internousdev.loginTest.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.loginTest.dao.InquiryCompleteDAO;
import com.internousdev.loginTest.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	private String name;
	private String qtype;
	private String body;

	public String execute(){

		InquiryCompleteDAO dao = new InquiryCompleteDAO();

		dao.setInquiryList(name, qtype, body);
		List<InquiryDTO> inquiryDTOList = dao.getInquiryList();

		session.put("inquiryDTOList", inquiryDTOList);

		return SUCCESS;
	}



	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getQtype(){
		return qtype;
	}

	public void setQtype(String qtype){
		this.qtype=qtype;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body=body;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}



}
