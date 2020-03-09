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
	.then(res => {
		console.log(res);
					 if(res.status === 200) {
						res.json();
						window.location.href = url+'Collab/'+input;
					 }
					 else {
						 res.json().then(data=> {
								
								if(data.status !== 200) {
									window.alert(data.message);
								}

				     
						 })
					 }
	})
	.catch(err => console.log('Error:', err));	 
//	.then(data => {
//		
//		console.log("data");
//    });
})


