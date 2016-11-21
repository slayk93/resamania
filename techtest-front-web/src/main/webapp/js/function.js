$(document).ready(function() {
	bind();
	initDatePicker();
	loadSuppliers();
});

var BASE_URL = "http://localhost:8080/techtest-back-web-1.0.0/rest/resources/";
var _supplierId = undefined;

function loadSuppliers() {
	var supplierSettings = {};
	supplierSettings.crossOrigin = true;
	supplierSettings.dataType = "json",
	supplierSettings.url = BASE_URL + "supplier";
	supplierSettings.error = function(_jqXHR, _textStatus, _err){
		Alert.show("danger", "Unable to list suppliers.", _err);
	};
	supplierSettings.success = function(suppliers, _textStatus, _jqXHR){
		_supplierId = suppliers[0].id;
		supplierName = suppliers[0].name;
		
		$("#supplier").append(supplierName);
		
		loadRooms(_supplierId);
		loadActivities(_supplierId);
	};

	HttpHelper.ajaxCall(supplierSettings);
}

function loadRooms(supplierId) {
	var roomSettings = {};
	roomSettings.crossOrigin = true;
	roomSettings.dataType = "json",
	roomSettings.url = BASE_URL + "rooms/" + supplierId;
	roomSettings.error = function(_jqXHR, _textStatus, _err){
		Alert.show("danger", "Unable to list rooms.", _err);
	};
	roomSettings.success = function(rooms, _textStatus, _jqXHR){
		var htmlcontent = '';
		$.each(rooms, function(u, room) {
			htmlcontent += "<option value='" + room.id + "'>" + room.name + "</option>";
		});
		
		$("#room").append(htmlcontent);
		$('#room').selectpicker('refresh');
	};

	HttpHelper.ajaxCall(roomSettings);
}

function loadActivities(supplierId) {
	var activitySettings = {};
	activitySettings.crossOrigin = true;
	activitySettings.dataType = "json",
	activitySettings.url = BASE_URL + "activities/" + supplierId;
	activitySettings.error = function(_jqXHR, _textStatus, _err){
		Alert.show("danger", "Unable to list activities.", _err);
	};
	activitySettings.success = function(activities, _textStatus, _jqXHR){
		var htmlcontent = '';
		$.each(activities, function(u, activity) {
			htmlcontent += "<option value='" + activity.id + "'>" + activity.name + "</option>";
		});
		
		$("#activity").append(htmlcontent);
		$('#activity').selectpicker('refresh');
	};

	HttpHelper.ajaxCall(activitySettings);
}

function loadBooking(roomId, activityId, from, to) {
	var bookingSettings = {};
	bookingSettings.crossOrigin = true;
	bookingSettings.dataType = "json",
	bookingSettings.url = BASE_URL + "booking/" + _supplierId
	+ "/" + from
	+ "/" + to
	+ "/" + roomId
	+ "/" + activityId;
	bookingSettings.error = function(_jqXHR, _textStatus, _err){
		Alert.show("danger", "Unable to list booking.", _err);
	};
	bookingSettings.success = function(booking, _textStatus, _jqXHR){
		var htmlcontent = '';
		$.each(booking, function(u, oneBooking) {
			var availablePlaces = (oneBooking.nbPlace - oneBooking.nbPlaceInUsed);
			var date = new Date(oneBooking.beginDate);
			var bookingDate = date.toDateString();
			var bookingTime = date.getHours() + ":" + date.getMinutes();
			
			var diffMs = new Date(new Date(oneBooking.endDate) - date);
			var diffHrs = Math.floor((diffMs % 86400000) / 3600000);
			var diffMins = Math.round(((diffMs % 86400000) % 3600000) / 60000);
			var sessionTime = diffHrs + " hour(s) " + diffMins + " minutes";
			
			htmlcontent += '<a class="list-group-item">'
				    + '<h4 class="list-group-item-heading">Room Name : ' + oneBooking.roomName + '     -     Activity name : ' + oneBooking.activityName + '</h4>'
				    + '<p class="list-group-item-text"><span style="color:red;">' 
					+ bookingDate + '</span> at <span style="color:red;">' 
					+ bookingTime + '</span> for ' + sessionTime + '</p>'
					+ '<p>Available places : <span style="color:red;">' + availablePlaces + '</span></p>'
					+ '<button style="display: table-cell;" class="btn btn-primary">Subscribe</button></a>'
		});
		
		$("#booking").html(htmlcontent);
	};
	HttpHelper.ajaxCall(bookingSettings);
}

function initDatePicker() {
	$('#from').datepicker({
		autoclose: true,
		format: "yyyy-mm-dd"
	});
	
	$('#to').datepicker({
		autoclose: true,
		format: "yyyy-mm-dd"
	});
}

function checkForm() {
	var roomId = $("#room").val();
	var activityId = $("#activity").val();
	var from = $("#from").val();
	var to = $("#to").val();
	if( roomId != "" &&
		activityId != "" &&
		from != "" &&
		to != "") {
		$("#search").removeClass("disabled");
	} else {
		$("#search").addClass("disabled");
	}
}

function bind() {
	$("#room").change(function(){
		checkForm()
	});
	
	$("#activity").change(function(){
		checkForm()
	});
	
	$("#from").change(function(){
		checkForm()
	});
	
	$("#to").change(function(){
		checkForm()
	});
	
	$("#form").submit(function(event) {
		var roomId = $("#room").val();
		var activityId = $("#activity").val();
		var from = $("#from").val();
		var to = $("#to").val();
		loadBooking(roomId, activityId, from, to);
		event.preventDefault();
	});
}