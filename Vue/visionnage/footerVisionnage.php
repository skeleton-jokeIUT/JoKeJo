<form method="GET" action="index.php?visionnage=<?echo $_SESSION['visionnage']?>&titre<?echo $_SESSION['titre']?>">
	<button name="btnAjoutFavori"> Ajouter aux favoris</button>
</form>

<div class="">
	
	<form class="formNote">
		<label>Note : </label>
		<label><input type="radio" name="note" id="1" value="1"></label>
		<label>2<input type="radio" name="note" id="2" value="2"></label>
		<label>3<input type="radio" name="note" id="3" value="3"></label>
		<label>4<input type="radio" name="note" id="4" value="4"></label>
		<label>5<input type="radio" name="note" id="5" value="5"></label>
		<button type="submit" name="btnNoter">Noter !</button>
	</form>

</div>

<div>
	<form>
		<button type="input" name="btnAchat" id="btnAchat">Acheter</button>
		<button type="input" name="btnLocation" id="btnLocation">Louer</button>
	</form>
</div>

<script type="text/javascript">
	
	var btnAchat =document.getElementById("btnAchat");
	var btnLocation = document.getElementById("btnLocation");

	function niveau(){

		alert(acces);

		if(abonnement>=acces){
			alert("Votre abonnement vous donne déjà accès à cette oeuvre !")
		}
		else alert("Vous pouvez acheter/Louer");
	}

	btnLocation.addEventListener('click',niveau);
	btnAchat.addEventListener('click',niveau);


</script>