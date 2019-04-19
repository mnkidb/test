package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{

	private String message;
	private Map<String,Object> session;
	List<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	public String execute(){

		String result = SUCCESS;

		ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

		int i = dao.itemDelete();

		if(i > 0){
			setMessage("商品情報を正しく削除しました。");
		}else if(i == 0){
			setMessage("商品情報の削除に失敗しました。");
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
