<link rel="stylesheet" type="text/css" href="../Vue/styleCatalogue.css">
<meta charset="utf-8">

<body>
	

	<div>
		<h2>Image</h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Image") ?>
		</div>

	</div>

	<div>
		<h2>Ecrit</h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Ecrit") ?>
		</div>

	</div>

	<div>
		<h2>Musique</h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Musique") ?>
		</div>

	</div>

	<div>
		<h2>Vidéo</h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Vidéo") ?>
		</div>

	</div>

	<div>
		<h2>Jeux</h2>

		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Jeux-Vidéo") ?>
		</div>
	</div>


</body>