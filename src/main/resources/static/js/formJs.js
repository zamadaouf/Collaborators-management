/*$(document).ready(function() {

  function ajaxCallRequest(f_method, f_url, f_data) {
    $("#dataSent").val(unescape(f_data));
    var f_contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    $.ajax({
      url: f_url,
      type: f_method,
      contentType: f_contentType,
      dataType: 'json',
      data: f_data,
      success: function(data) {
        var jsonResult = JSON.stringify(data);
        $("#results").val(unescape(jsonResult));
      }
    });
  }


//  var formResults = JSON.stringify({
//   first_name = document.querySelector("#first_name"),
//   last_name = document.querySelector("#last_name"),
//   civility = document.querySelector("#civility"),
//   email = document.querySelector("#email"),
//   phone_number = document.querySelector("#phone_number")
//  });


$("#sendSerialized").click(function(event) {
    event.preventDefault();
    var form = $('#contact_form');
    var method = form.attr('method');
    var url = form.attr('action');
    var objectData = $(form).serializeObject();
    var data = JSON.stringify(objectData);
    
    console.log(data);
    ajaxCallRequest(method, url, data);
  });
  $.mockjax({
    url: 'http://localhost:8080/Collaborators',
    type: 'POST',
    contentType: 'application/x-www-form-urlencoded',
    responseTime: 0,
    response: function(settings) {
      var data = settings.data;
      this.responseText = data;
    }
  });


   //form serializer
(function($) {
  $.fn.serializeObject = function() {

    var self = this,
      json = {},
      push_counters = {},
      patterns = {
        "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
        "key": /[a-zA-Z0-9_]+|(?=\[\])/g,
        "push": /^$/,
        "fixed": /^\d+$/,
        "named": /^[a-zA-Z0-9_]+$/
      };
      
    this.pair = function(base, key, value) {
      base[key] = value;
      return base;
    };

    this.push_counter = function(key) {
      if (push_counters[key] === undefined) {
        push_counters[key] = 0;
      }
      return push_counters[key]++;
    };

    $.each($(this).serializeArray(), function(index, item) {

      // skip invalid keys
      var name = item.name;
      if (!patterns.validate.test(name)) {
        return;
      }

      var key;
      var keys = name.match(patterns.key);
      var value = item.value;
      var reverse_key = name;

      while ((key = keys.pop()) !== undefined) {

        // adjust reverse_key
        reverse_key = reverse_key.replace(new RegExp("\\[" + key + "\\]$"), '');

        // push
        if (key.match(patterns.push)) {
          value = self.pair([], self.push_counter(reverse_key), value);
        }

        // fixed
        else if (key.match(patterns.fixed)) {
          value = self.pair([], key, value);
        }

        // named
        else if (key.match(patterns.named)) {
          value = self.pair({}, key, value);
        }
      }

      json = $.extend(true, json, value);
    });

    return json;
  };
})(jQuery);
*/


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