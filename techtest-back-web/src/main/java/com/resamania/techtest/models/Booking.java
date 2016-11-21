package com.resamania.techtest.models;

import java.util.List;

public class Booking {

	private int id;
	private String beginDate;
	private String endDate;
	private int nbPlace;
	private int nbPlaceInUsed;
	private List<Integer> roomIdList;
	private List<Integer> activityIdList;
	private List<Integer> coachIdList;
	private String roomName;
	private String activityName;
	private String commentary;
	private String lastModificationDate;
	private String suppressionDate;
	private boolean isFromScheduledBooking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public int getNbPlaceInUsed() {
		return nbPlaceInUsed;
	}

	public void setNbPlaceInUsed(int nbPlaceInUsed) {
		this.nbPlaceInUsed = nbPlaceInUsed;
	}

	public List<Integer> getRoomIdList() {
		return roomIdList;
	}

	public void setRoomIdList(List<Integer> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public List<Integer> getActivityIdList() {
		return activityIdList;
	}

	public void setActivityIdList(List<Integer> activityIdList) {
		this.activityIdList = activityIdList;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public List<Integer> getCoachIdList() {
		return coachIdList;
	}

	public void setCoachIdList(List<Integer> coachIdList) {
		this.coachIdList = coachIdList;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getSuppressionDate() {
		return suppressionDate;
	}

	public void setSuppressionDate(String suppressionDate) {
		this.suppressionDate = suppressionDate;
	}

	public boolean isFromScheduledBooking() {
		return isFromScheduledBooking;
	}

	public void setFromScheduledBooking(boolean isFromScheduledBooking) {
		this.isFromScheduledBooking = isFromScheduledBooking;
	}

}
