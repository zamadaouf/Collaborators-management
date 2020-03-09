
collabID = '';

window.onload = () => {
	collabID = $("#id").val();
	var url = "http://localhost:8080/";
}


$(document).ready(function() {

	$("#update-button").click(function(event) {
	    document.location.href = 'http://localhost:8080/Collab/edit/'+collabID;
	    event.preventDefault();
	 });

});