<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />

<div id="main">
	<div class="cart">
		<div class="container">
			<div class="row col-md-10">
				<h1>${article.getDesignation()}</h1>
				<article class="row" data-id="${p.getId()}">
					<div class="col-md-2">
						<img src="image/${article.getId()}.jpg" alt="">
					</div>
					<div class="col-md-5">
						<p>${article.getDescription()}</p>
						<span class="error"></span><br>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-2">
						<p><fmt:formatNumber value="${article.getPrix()}" type="number" maxFractionDigits="2" /><%
						if (session.getAttribute("currency").equals("EUR")) {
					%>
                                €
                  <%
						}  else  {
					%> $  
						<%
						}
					%></p>
					</div>
				</article>

			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />