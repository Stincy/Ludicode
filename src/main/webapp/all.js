function getUser(name) {
	$.getJSON("v1/user/" + name, function(data) {
		afficheUser(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(data.id + " : " + data.name);
}

function postUser(name) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"prenom" : prenom,
			"pseudo" : pseudo,
			"mdp" : mdp,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			$("#message").html("Inscription reussi !");
			window.location.replace("http://stackoverflow.com");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#message").html("Inscription echoué !");
			alert('postUser error: ' + textStatus + " " + errorThrown);
		}
	});
}

function listUsers() {
	$.getJSON("v1/user/", function(data) {
		afficheListUsers(data)
	});
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>" + data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}