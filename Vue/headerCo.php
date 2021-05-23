<!DOCTYPE html>
<html lang="fr">
 <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="../Vue/style.css">
    <title>PrimeFixPlus - Jokejo</title>
 </head>
 <body>
<header>
		<div>
			<a href="index.php"><img src="../Vue/image/logo.png" alt="image logo" class="img_logo"></a>
		</div>
		<div class="lien_deco">
			<a href="index.php?deco">Se déconnecter</a>
		</div>
		<div class="lien_co">
			<a href="index.php?profil">Profil</a>
		</div>
		<div class ="lien_compte">
			<a href="index.php?catalogue">Catalogue</a>
		</div>
</header>

<script type="text/javascript">

	var abonnement="<?php echo $_SESSION['abonnement'] ?>";
	var acces="<?php echo $_GET['acces'] ?>";

	switch(abonnement){
		case 'gratuit':
			abonnement=1;
			break;
		case 'payant':
			abonnement=2;
			break;
		case 'premium':
			abonnement=3;
			break;
		default:
			alert("pas cool");
	}

	switch(acces){
		case 'gratuit':
			acces=1;
			break;
		case 'payant':
			acces=2;
			break;
		case 'premium':
			acces=3;
			break;
		default:
			alert("pas cool");
	}

</script>
