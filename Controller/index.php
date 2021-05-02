<?php

session_start();

var_dump($_POST);
var_dump($_GET);
var_dump($_SESSION);

include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/DAO_Catalogue.php');
include_once('../Model/DAO_Image.php');
require_once('../Model/Client_DAO.php');
require_once('../Model/Profil_DAO.php');
require_once('../Model/Personne_DAO.php');


$image= new DAOImage();
$oeuvre= new DAOOeuvre();
$catalogue = new DAOCatalogue();
$personne = new Personne('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');
$client = new Client_DAO('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');
$profil = new Profil('127.0.0.1', 'bdd_roulette', 'p0401831', 'mdp');




$module="accueil";

$titre="NetPrimePlus";

if(isset($_GET['deco'])){
	unset($_SESSION['connexion']);
}

if(isset($_SESSION['connexion'])){
	$module="profil";
}

if(isset($_GET['connexion'])){

	if(isset($_POST['btnValider'])){

		$_SESSION['connexion']=true;
	}
	else $module="connexion";

}

if (isset($_GET['creation'])) {

	if (isset($_POST['btnValider']))           //manque un bouton 'submit' ds le formulaire
    {
        $reponse = $dao_client->getEmail($_POST['email']);
        if (isset($_POST['email']) && $_POST['email'] != '')
        {
            if (isset($_POST['password']) && $_POST['password'] != '')
            {
                if ((strcmp($_POST['email'], $reponse['email'])==0) || (strcmp($_SESSION['email'], $reponse['email'])==0))
                {
                    $dao_client->updInscription($_POST['email'], $_POST['password']);
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
	else $module="creation";

}

if(isset($_GET['catalogue'])){

	if($_GET['catalogue']=='Image'){

		$module="catalogueIMG";
		
	}
	else if($_GET['catalogue']=='Musique'){

		$module="catalogueMus";
		
	}
	else if($_GET['catalogue']=='Jeux'){

		$module="catalogueJeux";
		
	}
	else if($_GET['catalogue']=='Video'){

		$module="catalogueVOD";
		

	}
	else if($_GET['catalogue']=='Ecrit'){

		$module="catalogueEcrit";
		
	}
	else $module="catalogue";
}

if(isset($_GET['visionnage']) && isset($_GET['titre'])){

	if($_GET['visionnage'] !="Vidéo" && $_GET['visionnage']!="Musique"){

		$module="visioAutre";	

	}
	else if ($_GET['visionnage']=="Vidéo"){
		$module="visioVideo";
	}
	else if ($_GET['visionnage']=="Musique"){
		$module="visioMusique";
	}
}



//Affichage des différentes parties des pages
if($module=="creation"){
	include '../Vue/headerNonCo.php';
	include('../Vue/inscription.php');
	include '../Vue/footerNonCo.php';
}

if($module=="connexion"){
	include '../Vue/headerNonCo.php';
	include('../Vue/connexion.php');
	include '../Vue/footerNonCo.php';
}

if($module=="profil"){
	include '../Vue/headerNonCo.php';
	include('../Vue/choixProfils.php');
	include '../Vue/footerNonCo.php';
}

//affichage du catalogue vedette
if ($module=="catalogue"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogue.php');
	include '../Vue/footerNonCo.php';
}
//Affichage des catalogues par type d'oeuvre
else if($module=="catalogueIMG"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogueIMG.php');
	include '../Vue/footerNonCo.php';

}
else if($module=="catalogueEcrit"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogueEcrit.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueJeux"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogueJeux.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueVOD"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogueVideo.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueMus"){
	include '../Vue/headerNonCo.php';
	include('../Vue/catalogue/catalogueMusique.php');
	include '../Vue/footerNonCo.php';
	
}

//Affichage des différents modules de visionnage en fonction de l'oeuvre

if ($module=="visioAutre"){
	include '../Vue/headerNonCo.php';
	include('../Vue/visionnage/visionnageAutre.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="visioMusique"){
	include '../Vue/headerNonCo.php';
	include('../Vue/visionnage/visionnageMusique.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="visioVideo"){
	include '../Vue/headerNonCo.php';
	include('../Vue/visionnage/visionnageVideo.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="accueil"){
	include '../Vue/headerNonCo.php';
	include('../Vue/home.php');
	include '../Vue/footerNonCo.php';
}

var_dump($module);












