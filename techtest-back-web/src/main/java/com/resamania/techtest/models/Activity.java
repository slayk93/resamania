package com.resamania.techtest.models;

public class Activity {

	private int id;
	private String name;
	private String description;
	private String shortDescription;
	private String defaultNbPlace;
	private String duration;
	private boolean disable;
	private String subname;
	private String beginDate;
	private String endDate;
	private String supplierId;
	private String colorCode;
	private String storedFileId;
	private String onlineToolTipStoredFileId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDefaultNbPlace() {
		return defaultNbPlace;
	}

	public void setDefaultNbPlace(String defaultNbPlace) {
		this.defaultNbPlace = defaultNbPlace;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean getDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getStoredFileId() {
		return storedFileId;
	}

	public void setStoredFileId(String storedFileId) {
		this.storedFileId = storedFileId;
	}

	public String getOnlineToolTipStoredFileId() {
		return onlineToolTipStoredFileId;
	}

	public void setOnlineToolTipStoredFileId(String onlineToolTipStoredFileId) {
		this.onlineToolTipStoredFileId = onlineToolTipStoredFileId;
	}

}
