<link rel="stylesheet" type="text/css" href="../Vue/style.css">
<meta charset="utf-8">

<body>
	

	<div>
		<h2><a href="index.php?catalogue=Image">Image</a></h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Image") ?>
		</div>

	</div>

	<div>
		<h2><a href="index.php?catalogue=Ecrit" >Ecrit</a></h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Ecrit") ?>
		</div>

	</div>

	<div>
		<h2><a href="index.php?catalogue=Musique">Musique</a></h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Musique") ?>
		</div>

	</div>

	<div>
		<h2><a href="index.php?catalogue=Video">Vidéo</a></h2>
		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Vidéo") ?>
		</div>

	</div>

	<div>
		<h2><a href="index.php?catalogue=Jeux">Jeux</a></h2>

		<div class="miniature">
			<?php $oeuvre->afficherMiniatureReduit("Jeux-Vidéo") ?>
		</div>
	</div>


</body>