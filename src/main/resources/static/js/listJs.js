window.addEventListener("load", function () {
    const loader = document.querySelector(".loader");
    loader.className += " hidden"; // class "loader hidden"
});

window.onload = () => {
	const SERVER_URL = 'http://localhost:8080/Collaborators/';
 
	const table = document.querySelector('.collabs-list');

	fetch(SERVER_URL)
	.then(res => res.json())
	.then(data => {
		data.forEach(obj => {
		const tr = document.createElement('tr');		        
		
			const idTd                = document.createElement('td');
			idTd.textContent          = obj.id;		
			const prenomTd            = document.createElement('td');
			prenomTd.textContent      = `${obj.firstName}`;
			const nomTd               = document.createElement('td');
			nomTd.textContent         = `${obj.lastName}`;			
			const civilityTd          = document.createElement('td');
			civilityTd.textContent    = `${obj.civility}`;			
			const birthTd             = document.createElement('td');
			birthTd.textContent       = `${obj.birthDate}`;	
			const emailTd             = document.createElement('td');
			emailTd.textContent       = `${obj.email}`;			
			const phoneNumberTd       = document.createElement('td');
			phoneNumberTd.textContent = `${obj.phoneNumber}`;			
				    
	   	    tr.appendChild(idTd);
	   	    tr.appendChild(prenomTd);
	   	    tr.appendChild(nomTd);
	   	    tr.appendChild(civilityTd);
	   	    tr.appendChild(birthTd); 
	   	    tr.appendChild(emailTd);
	   	    tr.appendChild(phoneNumberTd); 
	   	    console.log(nomTd);

	 	
	 	table.querySelector('tbody').appendChild(tr);
    });
    })
    .catch(err => console.log('Error:', err));
};