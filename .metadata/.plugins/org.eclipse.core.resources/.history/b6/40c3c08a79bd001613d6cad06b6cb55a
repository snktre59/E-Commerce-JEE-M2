	
		$('#formConnexion').on(
				'submit',
				function(e) {
					e.preventDefault();
					$.post('/EcommerceWeb/', $(this).serialize(),
							function(data) {
								if (data == 'Mauvais mot de passe') {
									$('.error').text(data);
								} else {
									window.location = "/EcommerceWeb/";
								}

							});
				});
