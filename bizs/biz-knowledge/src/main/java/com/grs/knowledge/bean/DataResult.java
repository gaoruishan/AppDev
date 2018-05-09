package com.grs.knowledge.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者:gaoruishan
 * @时间:2018/2/12/15:41
 * @邮箱:grs0515@163.com
 */

public class DataResult<T> {

	private List<T> data;

	public List<T> getData() {
		if (data == null) {
			return new ArrayList<>();
		}
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
