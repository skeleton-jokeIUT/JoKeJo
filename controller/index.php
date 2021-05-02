<?php

    session_start();

    //var_dump($_SESSION);
    //var_dump($_POST);

    require_once('../model/Client_DAO.php');                //ordre??
    //require_once('../model/Profil_DAO.php');
    //require_once('../model/Personne_DAO.php');
    //require_once('../model/DAO_Catalogue.php');
    //require_once('../model/DAO_Image.php');
    //require_once('../model/DAO_Oeuvre.php');


    //$dao_personne = new Personne_DAO('127.0.0.1', 'appli_synth', 'p0401831', 'mdp');
    $dao_client = new Client_DAO('127.0.0.1', 'appli_synth', 'p0401831', 'mdp');
    //$dao_profil = new Profil_DAO('127.0.0.1', 'appli_synth', 'p0401831', 'mdp');

    $message='vide';
    $message1='vide';
    $module='vide';

    $client = $dao_client->getByEmail($_SESSION['email']);
    //$id_personn = $client->getIdP();
    $id_client = $client-> getIdC();
    //$id_subscription = $client->getIdS();
    $password = $client->getPassword();
    $age = $client->getAge();
    $profil = $client->getProfil();

    //redirection
    if(isset($_POST['connexion']))   //bouton connexion
        $module='../view/connexion.php';
    if(isset($_POST['inscription']))   //bouton inscription
        $module='../view/inscription.php';
    if(isset($_POST['deconnection']))   //bouton deconnexion
    {
        unset($_SESSION['email']);
        $module='../view/home.php';
    }


    //inscription
    if (isset($_POST['inscription']))           //manque un bouton 'submit' ds le formulaire
    {
        $reponse = $dao_client->getEmail($_POST['email']);
        if (isset($_POST['email']) && $_POST['email'] != '')
        {
            if (isset($_POST['password']) && $_POST['password'] != '')
            {
                if (strcmp($_POST['email'], $reponse['email'])==0)                      //si l'adresse mail existe deja
                {
                    $message = 'Adresse email déjà enregistrée';
                    $_SESSION['email'] = $_POST['email'];
                } else
                    {
                        $dao_client->inscription($_POST['email'], $_POST['password']);		//...sinon => nouveau compte
                        $_SESSION['email'] = $_POST['email'];
                    }
                    $message = 'Compte enregistré ou mis à jour';
    			    $module = '../view/catalogue.php';                                       //inscription ok => connexion => redirection (catalogue?)
            } else $message = 'Erreur, champ(s) mot de passe vide(s)';
        } else $message ='Saisir un login (votre adresse mail)';
    }

    //connexion
    if (isset($_POST['connexion']))
    {
        $reponse1 = $dao_client->connexion($_POST['email']);							         //recupere login + mdp ds la base afin de comparer avec ce qu'a saisi l'utilisateur
        if(isset($_POST['email']) && $_POST['email'] != '' && isset($_POST['password']) && $_POST['password'] !='')
        {
            if ($_POST['login'] ==  $reponse1['login'] && $_POST['password'] == $reponse1['password'])
            {
                $_SESSION['login'] = $_POST['login'];
                $module='../view/catalogue.php';                                            //connexion ok => page catalogue
            } else
            {
                $message1 = 'Erreur de saisie de l\'identifiant ou du mot de passe';
            }
        } else
        {
            $message1 = 'Erreur, champs vides';
        }
    }


    //inclure les vues
    //include("");    //header??
    include("$module");
    //include("");    //footer??
