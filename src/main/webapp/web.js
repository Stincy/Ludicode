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
	
	createCookie("pseudo",pseudo,7);
	window.location.href = "Accueil.html";
//	$.ajax({
//		type : 'GET'
//		contentType : 'application/json',
//		url : "v1/user/",
//		dataType : "json",
//		data : JSON.stringify({
//			"pseudo" : pseudo,
//			"mdp" : mdp,
//		}),
//		success : function(data, textStatus, jqXHR) {
//			$("#message").html("Connexion reussie !");
//			window.location.href = "Accueil.html";
//		},
//		error : function(jqXHR, textStatus, errorThrown) {
//			$("#message").html("Connexion echouée !");
//			alert('postUser error: ' + textStatus + " " + errorThrown);
//		}
//	});
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
	var html = 'Signed in as ';
	html = html + readCookie("pseudo");
	$("#session").html(html);
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}