window.onload = () => {
	
	let param = localStorage.getItem('id');
	const SERVER_URL = 'http://localhost:8080/Collaborators/'+param;
 
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
$(".delete-btn").on("click", ".delete", function(event) {
	
	console.log("clicked !");
})
