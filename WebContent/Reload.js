var urlParams = new URLSearchParams(window.location.search);
var entries = urlParams.entries();
var id;
var ipformat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
for(pair of entries) { 
  id=pair[1];
}
console.log(id);
jQuery(document).ready(function() {
	getObject();
});

function getObject() {
	
	
	$.ajax({
		  method: "GET",
		  url: "Reload",
		  data: { ID:id}
	})
	  .done(function( data ) {
		  console.log("data ", data);
		  $("#fn1").val(data.xxdeviceId);$("#fn2").val(data.emsSessionId);
		  $("#fn3").val(data.user);$("#fn4").val(data.xxOperation);
		  $("#fn5").val(data.xxdeviceType);$("#fn6").val(data.xxIpaddress);
		  $("#fn7").val(data.emsIp);
		  
    });
	
}

function func()
{
	var xxIpaddress = $("#fn6").val();
	var emsIp = $("#fn7").val();
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


