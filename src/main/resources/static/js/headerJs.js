input = 0;


/* click on search event ***********/
$("div").on("click", ".btn-search", function(event) {
		
	input = document.querySelector('.search-input').value;

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


