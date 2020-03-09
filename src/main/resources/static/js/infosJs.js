collabID = '';

window.onload = () => {
	
	collabID = $("#id").val();
	const SERVER_URL = 'http://localhost:8080/Collaborators/'+collabID;
 
	const collabInfos = document.querySelector('.collab-infos');

	fetch(SERVER_URL)
	.then(res => res.json())
	.then(data => {
			var numProp=1;
			for (prop in data) {
				if(numProp!=8){
					const property = document.createElement('div');
					var attClass = document.createAttribute("class");
					attClass.value = "p-2 bd-highlight";
					property.setAttributeNode(attClass);
					console.log(data.firstName);
					property.textContent=data[prop];
					collabInfos.appendChild(property);
				}else break;
                numProp++;
			}  		
    })

    .catch(err => console.log('Error:', err));

};

/* click on delete event ***********/
$(".delete-btn").on("click", ".btn-delete", function(event) {
	var url = "http://localhost:8080/"
      event.preventDefault();
      var choice = confirm(this.getAttribute('data-confirm'));
      if (choice) {
    	  fetch(url + 'Collaborators/' + collabID, {
    			method: 'delete'
    		    })
    		    .then(response =>
    		     response.json()
    		    .then(json => {
    		      return json;
    		     })
    		  )
    		  .catch(err => console.log('Error:', err));
    	  window.location.href = url+'Collabs';
      }
})

/* click on update event ***********/
$(".update-btn").on("click", ".btn-update", function(event) {
//	var numi =$("#id").val();
//	console.log(numi);
//	document.location.href = 'http://localhost:8080/Collab/add';
//	function ajaxPost() {
//
//		// PREPARE FORM DATA
//		var formData = {
//			id:$("#id").val(),
//			firstName : $("#firstName").val(),
//			lastName : $("#lastName").val(),
//			civility : $("#civility").val(),
//			birthDate : $("#birthDate").val(),
//			email : $("#email").val(),
//			phoneNumber : $("#phoneNumber").val()
//		}
//
//		// DO POST
//		$.ajax({
//			type : "POST",
//			contentType : "application/json",
//			url : "http://localhost:8080/Collaborators",
//			data : JSON.stringify(formData),
//			dataType : 'json',
//			success : function(result) {
//				if (result.status == "success") {
//					$("#postResultDiv").html(
//							"" + result.data.firstName
//									+ "Post Successfully! <br>"
//									+ "---> Congrats !!" + "</p>");
//				} else {
//					$("#postResultDiv").html("<strong>Error</strong>");
//				}
//				console.log(result);
//			},
//			error : function(e) {
//				if (e.status !== 201) {
//					$("#postResultDiv").html("<strong>Error</strong>");
//				} else {
//					$("#postResultDiv").html("<strong>A new collaborator is added</strong>");
//				}
//				console.log("status: ", e.status);
//			}
//		});
//
//	}
////    event.preventDefault();

	
})

$(document).ready(function() {

	$("#update-button").click(function(event) {
	    document.location.href = 'http://localhost:8080/Collab/edit/'+collabID;
	    event.preventDefault();
	 });

});