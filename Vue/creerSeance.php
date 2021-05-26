
<form id="formCreerSeance" method="POST" action="index.php?seance">
	<legend>Créer séance privée</legend>

		<?php echo $message ?>
		<div>
			<label for="nomSeance">Nom Séance* : <input type="text" id="nomSeance"></label>
		</div>

		<div>
			<label for="Film_select">Merci de choisir l'oeuvre que vous voulez visionner* : </label>
				<select name="listeFilm" id="Film_select" autocomplete="on">
					<option selected>--votre choix--</option>
					<?php $oeuvre->afficherListeTitre() ?>
				</select>
		</div>

		<div>
			<label for="hroaire">Horaire* : <input type="datetime-local" id="horaire"></label>
		</div>

		<div>
			<label for="email">Participant* : <input type="email" id="email"></label>
			<!-- <img src="../Vue/image/plusPetit.png" alt="ajoutezParticipant" id="imgSeance"> -->
		</div>
		<div>
			<button name="btnCreerSeance">CREER !</button>
		</div>
</form>

