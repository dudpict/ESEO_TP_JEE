<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="utf-8" />
<title>AddVille</title>
</head>
<body>

	<div class="couleur">

		<%@ include file="menu.jsp"%>
		
	</div>

		<form method="post" action="new">
			<label for="nom">Nom : </label> <input type="text" name="nom"
				id="nom" /> <label for="cc">Code de la commune : </label> <input
				type="text" name="cc" id="cc" /> <br /> <label for="cp">Code
				postal : </label> <input type="text" name="cp" id="cp" /> <label
				for="libelle">Libelle : </label> <input type="text" name="libelle"
				id="libelle" /> <br /> <label for="ligne">Ligne : </label> <input
				type="text" name="ligne" id="ligne" /> <label for="lon">Longitude
				: </label> <input type="text" name="lon" id="lon" /> <br /> <label
				for="lat">Latitude : </label> <input type="text" name="lat" id="lat" />
			<br /> <input value="ajouter" type="submit" />
		</form>

	

</body>
</html>