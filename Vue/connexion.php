


<div class="contenu">
    <p id="accroche">You're Back ! Connecte toi vite pour voir les nouveaux contenus</p>
            <form class="connexion" action="index.php?connexion" method="POST">
                <fieldset>
                    <?php echo $message ?>
                    <legend>Connexion</legend>
                    <div>
                        <label> Login (votre email) : <input type="text"  name="login"></label>
                    </div>
                    <div>
                        <label> Mot de passe : <input type="password" name="mdp"></label>
                    </div>
                    <button type="reset" name="btnReset" class="reset">Effacer</button>
                    <button name="btnValider" class="valider">Valider</button>
                </fieldset>
            </form>
    </div>
</div>

