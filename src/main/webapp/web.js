function inscription() {
	var nom = $('#nom').val();
	var prenom = $('#prenom').val();
	var pseudo = $('#pseudo').val();
	var mdp = $('#mdp').val();
	
	if(mdp == "" || nom == "" || prenom == "" || pseudo == ""){
		alert("Champs manquants");
	} 
	
	else {
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : "v1/userdb/",
			dataType : "json",
			data : JSON.stringify({
				"nom" : $('#nom').val(),
				"prenom" : $('#prenom').val(),
				"pseudo" : $('#pseudo').val(),
				"mdp" : $('#mdp').val(), 
				"typeUser" : "",
				"id" : 0
			}),
			
			success : function(data, textStatus, jqXHR) {
				alert("Inscription réussie");
				window.location.href = "index.html" ;
				
			},
			
			error : function(jqXHR, textStatus, errorThrown) {
				$("#message").html("Inscription echouée !");
				alert('postUser error: ' + textStatus + " " + errorThrown);
			}
		});
	}
}

function deconnexion() {
	eraseCookie("pseudo");
	window.location.href = "index.html";
}

function connexion() {
	var pseudo = $('#pseudo').val();
	var mdp = $('#mdp').val();
	
	createCookie("pseudo",pseudo,7);
	 
	 $.getJSON("v1/userdb/"+pseudo+"/"+mdp, function(data) {
		 if (data == null){
			 $("#erreur").html("<div class='alert alert-danger' role='alert'>Mauvais Identifiant</div>");
			 return;
		 }
		 createCookie("pseudo",pseudo,7);
		 window.location.href = "Accueil.html";
		}).error(function() {
			$("#erreur").html("<div class='alert alert-danger' role='alert'>Mauvais Identifiant</div>");
		});
}

function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function afficherSession() {
	var html = 'Tu es ';
	if (readCookie("pseudo") == null) {
		window.location.href = "index.html";
	} else {
		html = html + readCookie("pseudo");
		$("#session").html(html);
	}
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}