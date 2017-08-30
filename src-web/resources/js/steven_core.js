String.prototype.interpolate = function(o) {
	return this.replace(/{([^{}]*)}/g, function(a, b) {
		var r = o[b];
		return typeof r === 'string' || typeof r === 'number' ? r : a;
	});
};

String.prototype.startsWith = function(prefix) {
    return this.indexOf(prefix) === 0;
}

String.prototype.endsWith = function(suffix) {
    return this.match(suffix+"$") == suffix;
};  

Number.prototype.round = function(places) {
  return +(Math.round(this + "e+" + places)  + "e-" + places);
}

$(document).ready(function() {
	$(this).ajaxStart(function() {
		var time = new Date();
		var timestamp = time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
	});
	
	$(this).ajaxComplete(function() {
		var today = new Date();
		var timestamp = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds(); 
	});
	
	//timeout : ((1000 * 60) * 5), // 5 Minutes
	$.ajaxSetup({
		cache : true,
		dataType : 'json',
		error : function(xhr, status, error) {
			if(status == 'parsererror'){
				alert("You'v lost session information. Please try re-login.");
				document.location.href = "/common/SessionExpired.steven";
			} else {
				alert('An error occurred: ' + error + ', status:' + status);
			}
		},
		timeout : 300000, // ((1000 * 60) * 5) : 1000 = 1 second
		type : 'POST',
		url : 'ajax-gateway.php'
	}); 
});


function progress(turnOnOff) {
	if(turnOnOff == true) {
		kendo.ui.progress($('#contentsDiv'), true);
	} else {
		kendo.ui.progress($('#contentsDiv'), false);
	}
}


