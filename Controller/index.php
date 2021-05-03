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
$personne = new Personne();
$client = new Client_DAO();
$profil = new Profil();




$module="accueil";
$message="";

$titre="NetPrimePlus";

//permet de se déconnecter
if(isset($_GET['deco'])){
	unset($_SESSION['email']);
	unset($_SESSION['abonnement']);
	unset($_SESSION['connexion']);
}


//Verification de la connexion
if(isset($_SESSION['email'])){
	$module="profil";
}

//Traitement de la connexion
if(isset($_GET['connexion'])){

	if (isset($_POST['btnValider']))
	{

		if (isset($_POST['login']) && $_POST['login'] !="" &&($_POST['mdp']) && $_POST['mdp']!="")
    	{
       		$client->connection($_POST['login'],$_POST['mdp'],$message,$module);
    	}
    	else 
    	{
    	$message="Pas de saisie";
    	$module="connexion";
    	}

	}
	else $module="connexion";

}


//traitement de l'inscription
if (isset($_GET['creation'])) {

	if(isset($_SESSION['email'])){
		$module="profil";
	}
	else if (isset($_POST['btnValider']))
    {
    	
        $reponse = $client->getByEmail($_POST['email']);
        if (isset($_POST['email']) && $_POST['email'] != '')
        {
            if (isset($_POST['mdp']) && $_POST['mdp'] != '')
            {
            	if(isset($_POST['abo']))
            	{
            		$email=$reponse->getEmail();
            		var_dump($email);
                	if ($email!=null)
	                {
	                    $message="cette adresse mail est déjà associée un à compte";
	                    $module="creation";
	                } 
	                else 
	                {
	                    $client->inscription($_POST['email'], $_POST['mdp'],$_POST['abo'],$_POST['nom_prof'],$_POST['age_prof']);

	                    $module="profil";//changer la vue 
	                    $message = 'Compte enregistré';
	 
	                }
	                
	    		}     
	    		else 
	    		{
	    			$message="Merci de choisir un type de compte";    
	    			$module="creation"; 
	    			
	    		}               
            } 
            else 
            {
            	$message = "Erreur, champ(s) mot de passe vide(s)";
            	$module="creation"; 
            	
            }
        } 
        else 
        {
        	$message ="Saisir un login (une adresse mail)";
        	$module="creation"; 
        	
        }
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
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogue.php');
	include '../Vue/footerNonCo.php';
}
//Affichage des catalogues par type d'oeuvre
else if($module=="catalogueIMG"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueIMG.php');
	include '../Vue/footerNonCo.php';

}
else if($module=="catalogueEcrit"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueEcrit.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueJeux"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueJeux.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueVOD"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueVideo.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueMus"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueMusique.php');
	include '../Vue/footerNonCo.php';
	
}

//Affichage des différents modules de visionnage en fonction de l'oeuvre

if ($module=="visioAutre"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageAutre.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="visioMusique"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageMusique.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="visioVideo"){
	include '../Vue/headerNonCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageVideo.php');
	include '../Vue/footerNonCo.php';
}

if ($module=="accueil"){
	include '../Vue/headerNonCo.php';
	include('../Vue/home.php');
	include '../Vue/footerNonCo.php';
}











