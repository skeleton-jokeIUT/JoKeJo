<form id="ajoutFav" method="GET" action="index.php?visionnage=<?echo $_SESSION['visionnage']?>&titre<?echo $_SESSION['titre']?>">
	<button name="btnAjoutFavori"> Ajouter aux favoris</button>
</form>

<div class="">
	
	<form id="formNote">
		<label>Note : </label>
		<label><input type="radio" name="note" id="1" value="1"></label>
		<label>2<input type="radio" name="note" id="2" value="2"></label>
		<label>3<input type="radio" name="note" id="3" value="3"></label>
		<label>4<input type="radio" name="note" id="4" value="4"></label>
		<label>5<input type="radio" name="note" id="5" value="5"></label>
		<button type="submit" name="btnNoter">Noter !</button>
	</form>

</div>

<div id="achatLocation">
	<form>
		<button class="achat_location" type="input" name="btnAchat" id="btnAchat">Acheter</button>
		<button class="achat_location" type="input" name="btnLocation" id="btnLocation">Louer</button>
	</form>
</div>

<script type="text/javascript">

	var acces="<?php echo $_GET['acces'] ?>";

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

	var oeuvre= document.getElementsByClassName("oeuvre");
	var btnAchat =document.getElementById("btnAchat");
	var btnLocation = document.getElementById("btnLocation");
	var btnFav = document.getElementById("ajoutFav");
	var formNote = document.getElementById("formNote");
	var achatLocation = document.getElementsByClassName("achat_location");

	/*
	function niveau(){

		if(abonnement>=acces){
			alert("Votre abonnement vous donne déjà accès à cette oeuvre !");
		}
		else alert("Vous pouvez acheter/Louer");
	}
	*/
	
	accesOeuvre = function (oeuvre){

		if(abonnement<acces){
			alert("Malheureusement votre abonnement ne vous donne pas accès à cet oeuvre. Toutefois vous pouvez l'acheter ou la louer. Ou y accéder via des séances publics et/ou privée");
			console.log(oeuvre);
			oeuvre.style.display="none";
			btnFav.style.display="none";
			formNote.style.display="none";

			/* Tentative de changer la taille de la police pour rendre les boutons + gros !
			achatLocation[0].style.fontsize="100px";
			achatLocation[1].style.fontsize="110px";
			*/

		}
		else{

			achatLocation[0].style.display="none";
			achatLocation[1].style.display="none";

		}

	}

	this.accesOeuvre(oeuvre[0]);
	
</script>