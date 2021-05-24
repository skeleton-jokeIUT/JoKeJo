<form id="formCreerSeance" method="POST" action="index.php?seance">
	<legend>Créer séance privée</legend>

		<?php echo $message ?>
		<div>
			<label>Nom Séance* : <input type="text" name="nomSeance"></label>
		</div>

		<div>
			<label for="Film_select">Merci de choisir l'oeuvre que vous voulez visionner* : </label>
				<select name="listeFilm" id="Film_select" autocomplete="on">
					<option selected>--votre choix--</option>
					<?php $oeuvre->afficherListeTitre() ?>
				</select>
		</div>

		<div>
			<label>Horaire* : <input type="datetime-local" name="horaire"></label>
		</div>

		<div>
			<label>Participant* : <input type="email" name="email"></label>
		</div>

		<button name="btnCreerSeance">CREER !</button>
</form>