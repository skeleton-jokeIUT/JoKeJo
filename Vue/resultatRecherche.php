<div class="resultatRecherche">
	<p id="intro">Votre recherche a retourné les oeuvres suivantes : </p>
<?php 
	if($_GET['recherche']!="") $tabRecherche=$oeuvre->rechercher($_GET['recherche']);
	else echo "Votre recherche est vide ou ne retourne aucun résultat";
?>
</div>
