

$(document).ready(
		function() {

			// SUBMIT FORM
			$("#contact_form").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
						
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					civility : $("#civility").val(),
					birthDate : $("#birthDate").val(),
					email : $("#email").val(),
					phoneNumber : $("#phoneNumber").val(),
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "http://localhost:8080/Collaborators",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.firstName
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						if (e.status !== 201) {
							$("#postResultDiv").html("<strong>Error</strong>");
						} else {
							$("#postResultDiv").html("<strong>A new collaborator is added</strong>");
						}
						console.log("status: ", e.status);
					}
				});

			}

		})