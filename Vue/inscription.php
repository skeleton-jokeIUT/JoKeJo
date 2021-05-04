
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
                    <label>Compte gratuit<input type="radio" name="abo" value=1></label>
                    <label>Compte standard (10€/mois)<input type="radio" name="abo" value=2></label>
                    <label>Compte premium (20€/mois)<input type="radio" name="abo" value=3></label>
                    </div>
                    <div class="ins_avatar">
                    <label>Nom de votre profil* : </label><input type="text" name="nom_prof">
                    <label>Age maximum* :</label><input type="text" name="age_prof" class="age_prof">
                    </div>
                    <button type="reset" name="btnReset_inscr" class="reset">Effacer</button>
                    <button name="btnValider" class="valider">Valider</button>
          
                    </div>
                </fieldset>
                    <h4>*champs obligatoires</h4>

</form>
</div>

 
