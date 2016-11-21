package com.resamania.techtest.controllers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class MainController {

	protected static String URL = "http://api.intprod01.resamania.fr/rest/resamania/v1/";
	protected static String USERNAME = "test-api@intprod01.resamania.fr";
	protected static String PASSWORD = "anthony";
	
	
	protected static String restAPICall(String path) {
		ClientResponse response = Client
				.create()
				.resource(URL)
				.path(path)
				.header("mail", USERNAME)
				.header("password", PASSWORD)
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		return output;
	}
	
}
