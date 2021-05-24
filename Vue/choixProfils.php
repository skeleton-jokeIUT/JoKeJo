
<div class=profils>
<a href="index.php?catalogue"><img src="../Vue/image/avatar.png" alt="image de votre avatar" class="avatar_img"></a>
<a href="index.php"><img src="../Vue/image/plus.png" alt="cliquez-ici pour créer un nouveau profil" class="plus_img"></a>
<a href="index.php?favori"><img src="../Vue/image/favori.png" alt="cliquez-ici pour accéder aux favori" class="plus_img"></a>
<a id="iconeSeance"href="index.php?seance"><img src="../Vue/image/seance.png" alt="cliquez-ici pour créer une séance privée" class="plus_img"></a>
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