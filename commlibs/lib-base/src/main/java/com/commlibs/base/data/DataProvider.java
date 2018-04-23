package com.commlibs.base.data;

public class DataProvider {

	private String fridge_id;
	private String authen_token = "";

	private static DataProvider mInstance = new DataProvider();

	private DataProvider() {
	}

	/**
	 * 提供一个单例方法
	 * @return
	 */
	public static DataProvider get() {
		return mInstance;
	}

	public String getFridge_id() {
		return fridge_id;
	}

	public void setFridge_id(String fridge_id) {
		this.fridge_id = fridge_id;
	}

	public String getAuthen_token() {
		return authen_token;
	}

	public void setAuthen_token(String authen_token) {
		this.authen_token = authen_token;
	}
}