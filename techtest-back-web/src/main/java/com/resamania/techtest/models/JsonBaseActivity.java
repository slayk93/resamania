package com.resamania.techtest.models;

import java.util.List;

public class JsonBaseActivity extends JsonBase {

	private List<Activity> resultList;

	public List<Activity> getResultList() {
		return resultList;
	}

	public void setResultList(List<Activity> resultList) {
		this.resultList = resultList;
	}
	
}
