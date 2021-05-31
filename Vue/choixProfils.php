

<div class=profils>
	<p>Bonjour <strong><?php echo htmlspecialchars($_SESSION['email']) ?></strong>, vous avez un abonnement de type <em><?php echo $_SESSION['abonnement'] ?></p>
	<p><?php echo $message ?></p>
	<div id=optionsProfil>
		
		<?php $profil->listeProfil($idClient)?>
		<a href="index.php?ajoutProfil" title="créer un nouveau profil"><img src="../Vue/image/plus.png" alt="cliquez-ici pour créer un nouveau profil" class="img"></a>
	</div>
	<div id="autresOptions">	
		<a href="index.php?favori" title="accéder aux favoris"><img src="../Vue/image/favori.png" alt="cliquez-ici pour accéder aux favori" class="img"></a>
		<a id="iconeSeance"href="index.php?seance" title="Planifier une séance"><img src="../Vue/image/seance.png" alt="cliquez-ici pour créer une séance privée" class="img"></a>
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