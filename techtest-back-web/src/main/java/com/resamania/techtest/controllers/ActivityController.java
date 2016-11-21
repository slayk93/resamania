package com.resamania.techtest.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.resamania.techtest.models.Activity;
import com.resamania.techtest.models.JsonBaseActivity;

public class ActivityController extends MainController {

	public List<Activity> getActivities(String supplierId) {
		String activities = restAPICall("activity?size=10&offset=0&supplierId=" + supplierId);
		Gson gson = new Gson();
		JsonBaseActivity jba = gson.fromJson(activities, JsonBaseActivity.class);
		return jba.getResultList();
	}
	
	public Activity getActivity(String activityId) {
		String activity = restAPICall("activity/" + activityId);
		Gson gson = new Gson();
		Activity a = gson.fromJson(activity, Activity.class);
		return a;
	}	
}
