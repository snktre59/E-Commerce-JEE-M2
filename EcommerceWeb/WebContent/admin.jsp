<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Page d'administration</title>
<link href="//fonts.googleapis.com/css?family=Roboto:400,300,500,700"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/EcommerceWeb/css/grid.bootstrap.css">
<link rel="stylesheet" href="/EcommerceWeb/css/style.css">
<script type="text/javascript" src="/EcommerceWeb/js/jquery.js"></script>
</head>
<body>

	<div id="main">
		<div class="cart">
			<div class="container">
				<div class="row col-md-11">

					<article>
						<h3>Liste des factures</h3>
						<div class="row">
							<span class="col-md-2" style="font-weight:bold">Id facture</span>
							<span class="col-md-6" style="font-weight:bold">Nom client</span>
							<span class="col-md-1" style="font-weight:bold">Total</span>
							<span class="col-md-2" style="font-weight:bold"></span>
						</div>
							<c:forEach items="${commandes}" var="p">
								<div class="row">
									<span class="col-md-2">${p.getFactures().getId()}</span>
									<span class="col-md-6">${p.getFactures().getUser().getNom()}
										${p.getFactures().getUser().getPrenom()}</span>
									<span class="col-md-1">${p.getFactures().getTotal()}</span>
									<span class="col-md-2" class="bouton" id="B${p.getId()}" style="color:blue"
										onclick="javascript:afficher('${p.getId()}');">Voir le
											details</span>
								
								</div>
									<div id="${p.getId()}" style="display: none">
									<div class="row">
										<span class="col-md-2" style="font-weight:bold">Id Article</span>
										<span class="col-md-7" style="font-weight:bold">D�signation</span>
										<span class="col-md-1" style="font-weight:bold">Quantit�</span>
										<span class="col-md-1" style="font-weight:bold">Prix/u</span>
									</div>
									<div>
										<span class="col-md-2">${p.getArticles().getId()}</span>
										<span class="col-md-7">${p.getArticles().getDesignation()}</span>
										<span class="col-md-1">${p.getQuantite()}</span>
										<span class="col-md-1">${p.getPrix()}</span>
									</div>
								</div>


							</c:forEach>
						
					</article>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function afficher(id) {
			if (document.getElementById(id).style.display == "none") {
				document.getElementById(id).style.display = "block";
				document.getElementById('B' + id).innerHTML = 'Cacher le d�tail';
			} else {
				document.getElementById(+id).style.display = "none";
				document.getElementById('B' + id).innerHTML = 'Voir le d�tails';
			}
			return true;
		}
	</script>
</body>
</html>