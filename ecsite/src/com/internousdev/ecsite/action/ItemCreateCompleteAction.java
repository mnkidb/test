package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int itemPrice;
	private int itemStock;

	Map<String,Object> session;

	public String execute(){

		String result = SUCCESS;
		ItemCreateCompleteDAO iccDao = new ItemCreateCompleteDAO();

		iccDao.createItem(session.get("itemName").toString(),
						  Integer.parseInt(session.get("itemPrice").toString()),
						  Integer.parseInt(session.get("itemStock").toString()));

		return result;
	}

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public int getItemPrice(){
	return itemPrice;
	}

	public void setItemPrice(int itemPrice){
		this.itemPrice=itemPrice;
	}

	public int getItemStock(){
		return itemStock;
	}

	public void setItemStock(int itemStock){
		this.itemStock=itemStock;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
