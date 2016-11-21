package com.resamania.techtest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.resamania.techtest.controllers.ActivityController;
import com.resamania.techtest.controllers.BookingController;
import com.resamania.techtest.controllers.RoomController;
import com.resamania.techtest.controllers.SupplierController;
import com.resamania.techtest.models.Activity;
import com.resamania.techtest.models.Booking;
import com.resamania.techtest.models.Room;

@Path("/resources")
public class ResourcesService {

	@GET
	@Path("/activities/{supplierId}")
	public Response getActivities(@PathParam("supplierId") String supplierId) {
		Gson gson = new Gson();
		ActivityController ac = new ActivityController();
		String result = gson.toJson(ac.getActivities(supplierId));

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/activity/{activityId}")
	public Response getActivity(@PathParam("activityId") String activityId) {
		Gson gson = new Gson();
		ActivityController ac = new ActivityController();
		String result = gson.toJson(ac.getActivity(activityId));

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/supplier")
	public Response getSuppliers() {
		Gson gson = new Gson();
		SupplierController sc = new SupplierController();
		String result = gson.toJson(sc.getSuppliers());

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/rooms/{supplierId}")
	public Response getRooms(@PathParam("supplierId") String supplierId) {
		Gson gson = new Gson();
		RoomController rc = new RoomController();
		String result = gson.toJson(rc.getRooms(supplierId));

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/room/{roomId}")
	public Response getRoom(@PathParam("roomId") String roomId) {
		Gson gson = new Gson();
		RoomController rc = new RoomController();
		String result = gson.toJson(rc.getRoom(roomId));

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/booking/{supplierId}/{begin}/{end}/{roomId}/{activityId}")
	public Response getBooking(
			@PathParam("supplierId") String supplierId,
			@PathParam("begin") String begin,
			@PathParam("end") String end,
			@PathParam("roomId") String roomId,
			@PathParam("activityId") String activityId) {
		Gson gson = new Gson();
		BookingController bc = new BookingController();
		List<Booking> booking = bc.getBooking(supplierId, begin, end, roomId, activityId);
		
		RoomController rc = new RoomController();
		ActivityController ac = new ActivityController();
		for (Booking oneBooking : booking) {
			// Loading the room name for a specific booking
			Room room = rc.getRoom(oneBooking.getRoomIdList().get(0).toString());
			oneBooking.setRoomName(room.getName());
			
			// Loading the activity name for a specific booking
			Activity activity = ac.getActivity(oneBooking.getActivityIdList().get(0).toString());
			oneBooking.setActivityName(activity.getName());
		}
		String result = gson.toJson(booking);

		return Response.status(200).entity(result).build();
	}

}