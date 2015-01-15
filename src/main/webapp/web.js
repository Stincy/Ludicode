function inscription() {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/inscription/",
		dataType : "json",
		data : JSON.stringify({
			"nom" : $('#nom').val(),
			"prenom" : $('#prenom').val(),
			"pseudo" : $('#pseudo').val(),
			"mdp" : $('#mdp').val(),
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			alert($('#prenom').val());
			$("#message").html("Inscription réussie !");
			window.location.href = "index.html" ;
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#message").html("Inscription echouée !");
			alert('postUser error: ' + textStatus + " " + errorThrown);
		}
	});
}

function connexion() {
	var pseudo = $('#pseudo').val();
	var mdp = $('#mdp').val();
	
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"pseudo" : pseudo,
			"mdp" : mdp,
		}),
		success : function(data, textStatus, jqXHR) {
			$("#message").html("Connexion reussie !");
			window.location.href = "Accueil.html";
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#message").html("Connexion echouée !");
			alert('postUser error: ' + textStatus + " " + errorThrown);
		}
	});
}