
<div class="form_inscrip">
<form class= "inscription" action="index.php?creation" method="POST">
     
      <?php echo $message ?>

                <fieldset>
                    <legend>Créer un compte</legend>
                    <div class="ins_contenu"> 
                    <label>Email* :</label><input type="email" name="email">
                    <label>Mot de passe* :</label><input type="password" name="mdp">
                    <div class="abon">
                    <p>Choisissez un abonnement* (sans engagement)</p>
                    <label>Compte gratuit<input type="radio" name="abo" value="compte_gratuit"></label>
                    <label>Compte standard (10€/mois)<input type="radio" name="abo" value="compte_standard"></label>
                    <label>Compte premium (20€/mois)<input type="radio" name="abo" value="compte_premium"></label>
                    </div>
                    <div class="contenu_profil"
                    <label>Nom de votre profil* : </label><input type="text" name="nom_prof">
                    <label>Age maximum* :</label><input type="text" name="age_prof" class="age_prof">
                    </div>
                    <button name="btnValider">Valide r</button>
          
                    </div>
                </fieldset>
                    <h4>*champs obligatoires</h4>

</form>
</div>

 