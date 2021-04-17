<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="utf-8" />
<title>CalculDistance</title>
</head>
<body>

	<div class="couleur">

		<%@ include file="menu.jsp"%>

	</div>
	
	
	<c:choose>
		<c:when test="${ empty nomA }">
		
			<form method="post" action="vroum">
	
	<select name="pointA" id="pointA">
    <option value="">--Ville de départ--</option>
    
    <c:forEach items="${ villes }" var="current" varStatus="status">
		<option value="${current.nom}">${current.nom}</option>		
	</c:forEach>
	</select>
	
	
	<select name="pointB" id="pointB">
    <option value="">--Ville d'arrivé--</option>
    
    <c:forEach items="${ villes }" var="current" varStatus="status">
		<option value="${current.nom}">${current.nom}</option>		
	</c:forEach>
	</select>
	
	<input value="Calculer" type="submit" />
	
	</form>
	
		</c:when>

		<c:otherwise>

			<c:out value="La distance entre ${ nomA } et ${ nomB } à vol d'oiseau est de ${ distance } km."></c:out>

		</c:otherwise>
	</c:choose>
	
	
	
	
	
	


</body>
</html>