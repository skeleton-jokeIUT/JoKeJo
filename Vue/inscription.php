
<div class="form_inscrip">

    <p id="accroche">Film, Jeux-Vidéo, et plus encore en illimité et sans engagement !<br> Venez profitez de l'expérience la plus complète du marché sur<br><strong>NetPrimePlus</strong></p>
<form class= "inscription" action="index.php?creation" method="POST">
            
      <?php echo $message ?>

                <fieldset>
                    <legend>Créer un compte</legend>
                    <div class="ins_contenu"> 
                    <label>Email* : <input type="email" name="email"></label>
                    <label>Mot de passe* : <input type="password" name="mdp"></label>
                    <div class="ins_avatar">
                    <label>Nom de votre profil* : <input type="text" name="nom_prof"></label>
                    <label>Age maximum* : <input type="text" name="age_prof" class="age_prof"></label>
                    </div>
                    <div class="abon">
                    <p><strong>Lors de votre inscription nous vous attribuons un compte gratuit. Vous pouvez changer cela à tout moment depuis la page de sélection de profil !</p>
                    </div>
                    <button type="reset" name="btnReset_inscr" class="reset">Effacer</button>
                    <button name="btnValider" class="valider">Valider</button>
          
                    </div>
                </fieldset>
                    <h4>*champs obligatoires</h4>

</form>
</div>

 
