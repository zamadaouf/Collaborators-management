window.addEventListener("load", function () {
    const loader = document.querySelector(".loader");
    loader.className += " hidden"; // class "loader hidden"
});

hasNext             ='';
hasPrevPage         ='';
currentPage         ='';
totalItemsCount     ='';
pageSize            ='';
currentItemsCount   ='';
pageCount           ='';
offset              ='';
nextPageNumber      ='';
prevPageNumber      ='';
nextPageUrl         ='';
prevPageUrl         ='';
numPage				= 1;

/* function to get page infos */
function getPageParam(number){
	
	const SERVER_URL = 'http://localhost:8080/Collaborators/page?page_size=4&page='+number;
 
	
	fetch(SERVER_URL)
	.then(res => res.json())
	.then(data => {
		
	 	hasNext = data['pageMeta'].hasNext;
	 	hasPrevPage = data['pageMeta'].hasPrevPage;
	 	currentPage = data['pageMeta'].currentPage;
	 	totalItemsCount = data['pageMeta'].totalItemsCount;
	 	pageSize = data['pageMeta'].pageSize;
	 	currentItemsCount = data['pageMeta'].currentItemsCount;
	 	pageCount = data['pageMeta'].pageCount;
	 	offset = data['pageMeta'].offset;
	 	nextPageNumber = data['pageMeta'].nextPageNumber;
	 	prevPageNumber = data['pageMeta'].prevPageNumber;
	 	nextPageUrl = data['pageMeta'].nextPageUrl;
	 	prevPageUrl = data['pageMeta'].prevPageUrl;
			
        })
        .catch(err => console.log('Error:', err));	
}


/* function fill Table */
function fillTable(number){
	var PAGE_URL = "http://localhost:8080/Collaborators/page?page_size=4&page="+number;

	const table = document.querySelector('.collabs-list');
	const tbody = table.querySelector('tbody');
	
	const newtbody = document.createElement('tbody');
	
	fetch(PAGE_URL)
	.then(res => res.json())
	.then(data => {
		
		/* fill table */
		data['collaborator'].forEach(obj => {
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
			
			var attClass = document.createAttribute("class");
			attClass.value = "table-row";
			
			var attHref = document.createAttribute("data-href");
			attHref.value = "http://localhost:8080/Collab/"+obj.id;
			
	   	    tr.setAttributeNode(attClass);
	   	    tr.setAttributeNode(attHref);
	   	    
			tr.appendChild(idTd);
	   	    tr.appendChild(prenomTd);
	   	    tr.appendChild(nomTd);
	   	    tr.appendChild(civilityTd);
	   	    tr.appendChild(birthTd); 
	   	    tr.appendChild(emailTd);
	   	    tr.appendChild(phoneNumberTd); 
	 	
	   	newtbody.appendChild(tr);
	   	table.appendChild(newtbody);
	 		 
    });
		  	
		table.replaceChild(newtbody, tbody);
		
	})
    .catch(err => console.log('Error:', err));	
}

/* function set Pagination */
function setPagination(number){
	
	var PAGE_URL = "http://localhost:8080/Collaborators/page?page_size=4&page="+number;
	fetch(PAGE_URL)
	.then(res => res.json())
	.then(data => {
		const ul = document.querySelector('.pagination');
	    const nextli = document.querySelector('.next-page');
	
	    for(let i=0 ; i<pageCount ; i++){
		    const li = document.createElement('li');
		    
		    var liClass = document.createAttribute("class");
			liClass.value = "page-item";
			li.setAttributeNode(liClass);
			
			const a = document.createElement('a');
		    var aClass = document.createAttribute("class");
		    aClass.value = "page-link num-page";
		    a.setAttributeNode(aClass);
		    
			var aHref = document.createAttribute("href");
			a.setAttributeNode(aHref);
			a.textContent=i+1;
			aHref.value="#";//http://localhost:8080/Collabs/page?page="+a.textContent;
			
			li.appendChild(a);
			ul.appendChild(li);
			ul.insertBefore(li, nextli);
				
	    	}
		})
}


/* on Load         ******************/
window.onload = () => {
	getPageParam(numPage);
	fillTable(numPage);	
	setPagination(numPage);
};


/* click on numPage event ***********/
$("ul").on("click", ".num-page", function(event) {
	
	numPage =$(this).text();
	getPageParam(numPage);
	fillTable(numPage);

})


/* click on next page event ***********/

$("ul").on("click", ".next-page", function(event) {
	getPageParam(numPage);
	if(hasNext){
		
		console.log("to next");
		console.log("numPage "+currentPage);
		console.log("next to "+nextPageNumber);
		
		fillTable(nextPageNumber);	
		getPageParam(nextPageNumber);
	}
});


/* click on pervious page event ***********/

$("ul").on("click", ".prev-page", function(event) {
	getPageParam(numPage);
	if(hasPrevPage){
		console.log("to prev");
		console.log("numPage "+currentPage);
		console.log("prev to "+prevPageNumber);
		
		fillTable(prevPageNumber);	
		getPageParam(prevPageNumber);
	}
});


/* click row event ***********/
$("body").on("click", ".table-row", function(event) { // bind the parent and specify event and the

	var collabID;
	var textID =  $(this).text().substring(0,3);
    var matches = textID.match(/(\d+)/); 
      
    if (matches) { 
    	collabID = matches[0]; 
    } 
	console.log("-->"+collabID);
	localStorage.setItem('id',collabID);												  // element that we want to apply the event on it
	window.document.location = $(this).data("href");
});
