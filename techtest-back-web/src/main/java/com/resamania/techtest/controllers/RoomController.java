package com.resamania.techtest.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.resamania.techtest.models.JsonBaseRoom;
import com.resamania.techtest.models.Room;

public class RoomController extends MainController {

	public List<Room> getRooms(String supplierId) {
		String rooms = restAPICall("room?size=10&offset=0&supplierId=" + supplierId);
		Gson gson = new Gson();
		JsonBaseRoom jbr = gson.fromJson(rooms, JsonBaseRoom.class);
		return jbr.getResultList();
	}

	public Room getRoom(String roomId) {
		String room = restAPICall("room/" + roomId);
		Gson gson = new Gson();
		Room r = gson.fromJson(room, Room.class);
		return r;
	}
}
