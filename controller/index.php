<?php

    session_start();

    //var_dump($_SESSION);
    //var_dump($_POST);

    require_once('../Model/Client_DAO.php');
    require_once('../Model/Profil_DAO.php');
    require_once('../Model/Personne_DAO.php');

    $dao_personne = new Personne_DAO('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');
    $dao_client = new Client_DAO('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');
    $dao_profil = new Profil_DAO('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');

    $message='vide';

    $client = $dao_client -> getByEmail($_SESSION['email']);
    $id_personn = $client -> getIdP();
    $id_client = $client -> getIdC();
    $id_subscription = $client -> getIdS();
    $password = $client -> getPassword();
    $age = $client -> getAge();
    $profil = $client -> getProfil();

    //inscription
    if (isset($_POST['']))           //manque un bouton 'submit' ds le formulaire
    {
        $reponse = $dao_client -> getEmail($_POST['email']);
        if (isset($_POST['email']) && $_POST['email'] != '')
        {
            if (isset($_POST['password']) && $_POST['password'] != '')
            {
                if ((strcmp($_POST['email'], $reponse['email'])==0) || (strcmp($_SESSION['email'], $reponse['email'])==0))
                {
                    $dao_client -> updInscription($_POST['email'], $_POST['password']);
                    $_SESSION['email'] = $_POST['email'];
                } else 
                    {
                        $dao_p -> inscription($_POST['email'], $_POST['password']);												//...sinon => nouveau compte
                        $_SESSION['email'] = $_POST['email'];
                    }
                    $message = 'Compte enregistré ou mis à jour';
    			    $module = '';                                //changer la vue
            } else $message = 'Erreur, champ(s) mot de passe vide(s)';
        } else $message ='Saisir un login (une adresse mail)';
    }
