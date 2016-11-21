package com.resamania.techtest.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.resamania.techtest.models.JsonBaseSupplier;
import com.resamania.techtest.models.Supplier;

public class SupplierController extends MainController {

	public List<Supplier> getSuppliers() {
		String activities = restAPICall("supplier?size=10&offset=0");
		Gson gson = new Gson();
		JsonBaseSupplier jbs = gson.fromJson(activities, JsonBaseSupplier.class);
		return jbs.getResultList();
	}	
}
