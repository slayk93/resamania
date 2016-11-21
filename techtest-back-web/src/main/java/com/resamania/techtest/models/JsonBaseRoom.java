package com.resamania.techtest.models;

import java.util.List;

public class JsonBaseRoom extends JsonBase {

	private List<Room> resultList;

	public List<Room> getResultList() {
		return resultList;
	}

	public void setResultList(List<Room> resultList) {
		this.resultList = resultList;
	}
	
}
