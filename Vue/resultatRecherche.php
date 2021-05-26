<div class="resultatRecherche">
<?php 
	if($_GET['recherche']!="") $oeuvre->rechercher($_GET['recherche']);
	else echo "Votre recherche est vide ou ne retourne aucun résultat";
?>
</div>


<script type="text/javascript">
	
	var img= document.getElementsByClassName("img");
	var bulle= document.getElementsByClassName("bulle");

	for(i=0;i<img.length; i++){
		img[i].addEventListener('mouseenter',montre);
		img[i].addEventListener('mouseout',cache);
	}

	for(i=0;i<3; i++){
		alert(bulle[i]);
		bulle[i].style.display="none";
	}
	

	function montre(){
		
		bulle[i].style.display="inline-block";

	}

	function cache(){

		bulle[i].style.display="none";

	}

</script>
