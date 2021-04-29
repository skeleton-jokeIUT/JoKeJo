<?php

    session_start();

    //var_dump($_SESSION);
    //var_dump($_POST);

    require_once('Client_DAO.php');
    require_once('Profil_DAO.php');
    require_once('Personne_DAO.php');

    $dao_personne = new Personne_DAO();
    $dao_client = new Client_DAO();
    $dao_profil = new Profil_DAO();

    $client =
