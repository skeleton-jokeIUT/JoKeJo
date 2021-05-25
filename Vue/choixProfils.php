
<div class=profils>
	<div id=optionsProfil>
		<a href="index.php?catalogue"><img src="../Vue/image/avatar.png" alt="image de votre avatar" class="img"></a>
		<a href="index.php"><img src="../Vue/image/plus.png" alt="cliquez-ici pour créer un nouveau profil" class="img"></a>
	</div>
	<div id="autresOptions">	
		<a href="index.php?favori"><img src="../Vue/image/favori.png" alt="cliquez-ici pour accéder aux favori" class="img"></a>
		<a id="iconeSeance"href="index.php?seance"><img src="../Vue/image/seance.png" alt="cliquez-ici pour créer une séance privée" class="img"></a>
	</div>
</div>


<script type="text/javascript">

	var IconeSeance = document.getElementById("iconeSeance");
	
	function afficheIconeSeance(){

		
		if(abonnement!=3){
			IconeSeance.style.display="none";
		}

	}

	this.afficheIconeSeance();

</script>