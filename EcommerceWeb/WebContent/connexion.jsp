
<jsp:include page="header.jsp" />


<span class="error"></span>
<form action="connexion" method="POST" id="formConnexion">
	<input type="text" name="email"> 
	<input type="password" name="password">
	<button name="submit" type="submit">Connexion</button>
</form>


<script type="text/javascript" src="js/connexion.js"></script>
<jsp:include page="footer.jsp" />