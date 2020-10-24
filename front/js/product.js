$.ajax({
		method: "GET",
		url: 'http://localhost:8081/product/list'
	}).done(function(data){//anonymus function, async task
		// data = JSON.parse(data.toString());
		console.log(data)
		showProducts(data);
	}).always(function(){

});


	function showProducts(data){
		var element = "";
		 for (var j = 0; j < data.length; j++) {
		 	element += "" +
		 		'<a href="currentproduct.html?id='+data[j].id+'" class="card" style="background: url(\''+data[j].photo+'\'); background-size: cover; background-position: center;">'+
		 			'<img src="">'+
		 			'<div class="text">'+
		 				'<h3 class="name"> Name: '+
		 					data[j].name+
		 				'</h3>'+
		 				'<h3 class="date"> Expiration Date: '+
		 					data[j].expirationDate+
		 				'</h3>'+
		 			'</div>'+
		 		"</a>";
		 }

		 cardsBlock.innerHTML = element;
	}

	function search() {
		console.log(search.val)
		$.ajax({
				method: "GET",
				url: 'http://localhost:8081/product/find/'+document.getElementById("search").value
			}).done(function(data){//anonymus function, async task
				// data = JSON.parse(data.toString());
				console.log(data)
				showProducts(data);
			}).always(function(){

		});
	}