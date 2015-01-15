function inscription() {
	
	alert($('#nom')+$('#prenom')+$('#pseudo')+$('#mdp'));
	
}
//
//function connexion() {
//	var pseudo = $('#pseudo').val();
//	var mdp = $('#mdp').val();
//	
//	$.ajax({
//		type : 'GET',
//		contentType : 'application/json',
//		url : "v1/user/",
//		dataType : "json",
//		data : JSON.stringify({
//			"pseudo" : pseudo,
//			"mdp" : mdp,
//		}),
//		success : function(data, textStatus, jqXHR) {
//			$("#message").html("Connexion reussie !");
//			window.location.replace("http://stackoverflow.com");
//		},
//		error : function(jqXHR, textStatus, errorThrown) {
//			$("#message").html("Connexion echouée !");
//			alert('postUser error: ' + textStatus + " " + errorThrown);
//		}
//	});
//}