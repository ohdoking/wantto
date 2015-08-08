package com.uni.unitonwanttoapp.dto;

public class FilterInfo {

	String filterWord;
	String locWord;
	boolean locCheck;
	boolean locNoti;
	Integer scope;
	
	
	//get,set
	public String getFilterWord() {
		return filterWord;
	}
	public void setFilterWord(String filterWord) {
		this.filterWord = filterWord;
	}
	public String getLocWord() {
		return locWord;
	}
	public void setLocWord(String locWord) {
		this.locWord = locWord;
	}
	public boolean isLocCheck() {
		return locCheck;
	}
	public void setLocCheck(boolean locCheck) {
		this.locCheck = locCheck;
	}
	public boolean isLocNoti() {
		return locNoti;
	}
	public void setLocNoti(boolean locNoti) {
		this.locNoti = locNoti;
	}
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	
	
	
	
}
