package com.resamania.techtest.models;

import java.util.List;

public class JsonBaseSupplier extends JsonBase {

	private List<Supplier> resultList;

	public List<Supplier> getResultList() {
		return resultList;
	}

	public void setResultList(List<Supplier> resultList) {
		this.resultList = resultList;
	}
	
}
