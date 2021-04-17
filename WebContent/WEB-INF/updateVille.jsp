<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="utf-8" />
<title>UpdateVille</title>
</head>
<body>
	<div class="couleur">

		<%@ include file="menu.jsp"%>

	</div>

	<c:if test="${ !empty villeToDel }">

		<br />
		<c:out value="Modificaion des renseignement de la ville :  ${ villeToDel }" />
		<form method="post" action="refresh">
			<br /><label for="nom">Nom : </label> 
			<input value="${nom }" type="text" name="nom" id="nom" /> 
			<label for="cp">Code postal : </label> 
			<input value="${cp }" type="text" name="cp" id="cp" /> 
			<br /><label for="cc">Code commune : </label> 
			<input value="${cc }" type="text" name="cc" id="cc" /> 
			<label for="lat">Latitude : </label> 
			<input value="${lat }" type="text" name="lat" id="lat" /> 
			<br /><label for="lon">Longitude : </label> 
			<input value="${lon }" type="text" name="lon" id="lon" /> 
			<label for="libelle">Libelle : </label> 
			<input value="${libelle }" type="text" name="libelle" id="libelle" /> 
			<br /><label for="nom">Ligne : </label> 
			<input value="${ligne }" type="text" name="ligne" id="ligne" />



			<input value="Modifier" type="submit" />
		</form>
	</c:if>
	
	<c:if test="${ empty villeToDel }">
	
	<c:out
			value="Modificaion des renseignement effectué sur la ville ${ sessionScope.ChangedVille }! " />
			
			
	</c:if>



</body>
</html>