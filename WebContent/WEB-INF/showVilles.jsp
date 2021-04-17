<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>

<meta charset="utf-8" />
<title>ShowVilles</title>
</head>
<body>

	<div class="couleur">

		<%@ include file="menu.jsp"%>

	</div>

	<table id="table_villes">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Code Postal</th>
				<th>Code commune</th>
				<th>Latitude</th>
				<th>Longitude</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${ villes }" var="villes">
			<tr>
				<td><c:out value="${ villes.getNom() }"></c:out></td>
				<td><c:out value="${ villes.getCodePostal() }"></c:out></td>
				<td><c:out value="${ villes.getCodeCommune() }"></c:out></td>
				<td><c:out value="${ villes.getLatitude() }"></c:out></td>
				<td><c:out value="${ villes.getLongitude() }"></c:out></td>
				<td><a href="<%=application.getContextPath()%>/refresh?ville=${ villes.getNom() }">Modifier</a>
				<a href="<%=application.getContextPath()%>/bin?ville=${ villes.getNom() }">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_villes').dataTable();
		});
	</script>



</body>
</html>