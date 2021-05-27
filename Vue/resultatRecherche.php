<div class="resultatRecherche">
<?php 
	if($_GET['recherche']!="") $oeuvre->rechercher($_GET['recherche']);
	else echo "Votre recherche est vide ou ne retourne aucun résultat";
?>
</div>
