input = 0;

/* input change event ***********/
$("div").on("keyup", ".search-input", function(event) {
		
	input = document.querySelector('.search-input').value;
	
	  if (event.keyCode === 13) {
	   event.preventDefault();
	   document.querySelector(".btn-search").click();
	  }
	
})


$("div").on("click", ".btn-search", function(event) {
		
	var url = "http://localhost:8080/";

	  fetch(url + 'Collaborators/' + input, {
			method: 'get'
				
		    })
		    .then(response =>
		     response.json()
		    .then(json => {
		      return json;
		     }))
		     
		     .catch(err => console.log('Error:', err));
	
		     window.location.href = url+'Collab/'+input;
		     console.log("final"+input);
})


