<div id="accesVisio">
	<div class="visionnage">
		<legend>Film</legend>
	</div>

	<div class="chat">
		<legend>Chat</legend>
	</div>
</div>

<div id="formAcces">

	<legend>Identification</legend>
	<p>Merci de saisir votre mail afin de vous identifier : </p>
	<input type="email" name="mailAcces">
	<button id="btnValider">Valider !</button>

</div>

<script type="text/javascript">
	
	var none= document.getElementById("accesVisio");
	var btn = document.getElementById("btnValider");

	btn.addEventListener('click',affiche);

	none.style.display="none";

	function affiche(){
		none.style.display="block";
		formAcces.style.display="none";
	}

</script>
