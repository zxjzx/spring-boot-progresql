/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

package com.main.pagemodel;

import java.util.List;

import com.main.entity.WebConstants;
public class ListResult<T> extends BaseResult {

	private List<T> list;

	private Integer totalCount;

	public List<T> getList() {
		return list;
	}

	private void setList(List<T> list) {
		this.list = list;
	}

	public ListResult() {
		super();
	}

	public ListResult(String message, String result) {
		super(message, result);
	}

	public ListResult(List<T> list) {
		super(WebConstants.RESULT_SUCCESS);
		this.setList(list);
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
