collabID = '';

window.onload = () => {
	
	collabID = $("#id").val();
	console.log(collabID);
	const SERVER_URL = 'http://localhost:8080/Collaborators/'+collabID;
 
	const collabInfos = document.querySelector('.collab-infos');

	fetch(SERVER_URL)
	.then(res => res.json())
	.then(data => {
		
        for (prop in data) {
        	
        	const property = document.createElement('div');
    		var attClass = document.createAttribute("class");
    		attClass.value = "p-2 bd-highlight";
    		property.setAttributeNode(attClass);
    		property.textContent=data[prop];
            collabInfos.appendChild(property);
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
