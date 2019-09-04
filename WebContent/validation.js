var ipformat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
var existingData;
var str = "invalid ip pattern for";
console.log('Loading validation script...');
function fun() {
	$("#lbe1,#lbe2,#errorMessage").hide();
	var xxdeviceId = $("#fn1").val();
	console.log(xxdeviceId);
	var emsSessionId = $("#fn2").val();
	var xxIpaddress = $("#fn6").val();
	var emsIp = $("#fn7").val();
	
	// Check for duplicate entries
	if(checkDuplicate(xxdeviceId, emsSessionId)) {
		return false;
	}
	
	// xxIpaddress Field Validations
	if (xxIpaddress.match(ipformat)) {
		console.log("success ip");
	} else {
		$("#errorMessage").text('Invalid xxIpaddress!!').show();
		return false;
	}
	// emsIp Field Validations
	if (emsIp.match(ipformat)) {
		console.log("success ip");
	} else {
		$("#errorMessage").text('Invalid emsIp!!').show();
		return false;
	}
	return true;
}

function checkDuplicate(xxdeviceId, emsSessionId) {
	var hasDuplicate = false;
	for (i in existingData) {
		if (existingData[i].xxdeviceId === xxdeviceId) {
			$("#lbe1").show();
			hasDuplicate = true;
		}
		if (existingData[i].emsSessionId === emsSessionId) {
			$("#lbe2").show();
			hasDuplicate = true;
		}
	}
	return hasDuplicate;
}

function userDetail() {
	console.log('Get user details...');
	$.get("/Test2/JsonWriting", function(data) {
		existingData = data;
	}, "json");
}

jQuery(document).ready(function() {
	$("#lbe1,#lbe2,#errorMessage").hide();
	console.log('Document load called....');
	userDetail();
});
