package com.resamania.techtest.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.resamania.techtest.models.Booking;

public class BookingController extends MainController {

	public List<Booking> getBooking(String supplierId, String begin, String end, String roomId, String activityId) {
		String booking = restAPICall("booking?supplierId=" + supplierId
												+ "&begin=" + begin 
												+ "&end=" + end 
												+ "&roomId=" + roomId 
												+ "&activityId=" + activityId);
		
		Type listType = new TypeToken<ArrayList<Booking>>(){}.getType();
		List<Booking> b = new Gson().fromJson(booking, listType);

		return b;
	}	
}
