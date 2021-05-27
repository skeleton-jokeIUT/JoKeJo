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
require_once('../Model/DAO_Favori.php');
require_once('../Model/DAO_Note.php');
require_once('../Model/DAO_Seance.php');

$image= new DAOImage();
$oeuvre= new DAOOeuvre();
$catalogue = new DAOCatalogue();
$personne = new Personne();
$client = new Client_DAO();
$profil = new Profil();
$favori = new DAOFavori();
$note = new DAONote;
$seance = new DAOSeance();

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
       		$module="profil";
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
            
            		$email=$reponse->__get("email");
            		var_dump($email);
                	if ($email!=null)
	                {
	                    $message="cette adresse mail est déjà associée un à compte";
	                    $module="creation";
	                } 
	                else 
	                {
	                    $client->inscription($_POST['email'], $_POST['mdp'],$_POST['nom_prof'],$_POST['age_prof']);

	                    $module="profil";//changer la vue 
	                    $message = 'Compte enregistré';
	 
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

//Gestion du catalogue à afficher : soit le général soit par type oeuvre
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

//Permet de définir quel type de page de visionnage sera affiché : vidéo / musique / livre et/ou image
if(isset($_GET['visionnage']) && isset($_GET['titre'])){

	$_SESSION['titre']=$_GET['titre'];

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


//Gestion de la recherche
if(isset($_GET['btnRecherche'])){

	if(isset($_GET['recherche']) && $_GET['recherche']!=""){
		$module="recherche";
	}
	else{
		$module="recherche";
		$message="Vous n'avez saisie aucun paramètre de recherche";
	}

}

//Redirection vers la page de création de séance
if(isset($_GET['seance'])){

	if(isset($_SESSION['abonnement']) && $_SESSION['abonnement']=="premium"){

		$module="seance";

		//gestion de la création de séance privée par les compte premium
		if(isset($_POST['btnCreerSeance'])){

			var_dump($_POST);

			if($_POST['nomSeance']!="" && $_POST['listeFilm']!="--votre choix--" && $_POST['horaire']!=""){
				
				$id=$oeuvre->getByTitre($_POST['listeFilm']);
				$id=$id->__get('id');
				$seance->creerSeancePrivee($_POST['nomSeance'],$_POST['horaire'],$id);
				$message="votre séance a bien été créée ! ";
		
			}
			else {
				$message="Certains champs obligatoire n'ont pas été saisie";		
			}
		}
	}
	
} 

if(isset($_GET['planning'])){
	$module="planning";
}

if(isset($_GET['visioSeance'])){
	$module="visioSeance";
}


//gestion des favori
if(isset($_GET['favori']) || isset($_GET['btnAjoutFavori'])){
	$module="favori";

	if(isset($_GET['btnAjoutFavori'])){
		
		$oeuvreAjoutee=$oeuvre->getByTitre($_SESSION['titre']);
		$clientALier=$client->getByEmail($_SESSION['email']);

		$idOeuvre=$oeuvreAjoutee->__get('id');
		$idClient=$clientALier->__get('id');

		$favori->ajoutFavori($idOeuvre,$idClient);
		unset($_SESSION['titre']);

	}
	else if(isset($_GET['btnSupprFav'])){

	}

}

if(isset($_GET['note']) && $_GET['note']!=""){

	$module="note";

	if($_GET['note']<1 || $_GET['note']>5){
		$message="Votre note n'est pas compris entre 1 et 5";
	}
	else{
		$oeuvreAjoutee=$oeuvre->getByTitre($_SESSION['titre']);
		$clientALier=$client->getByEmail($_SESSION['email']);

		$idOeuvre=$oeuvreAjoutee->__get('id');
		$idClient=$clientALier->__get('id');

		$message=$note->ajoutNote($idOeuvre,$idClient,$_GET['note']);

		unset($_SESSION['titre']);


	}

}

if(isset($_GET['abonnement'])){
	$module="abonnement";
	if($_GET['abonnement']!=""){

		$abo=$_GET['abonnement'];

		if($abo=="gratuit") $abo=1;
		else if($abo=="intermediaire") $abo=2;
		else $abo=3;

		$client->Abonnement($abo,$_SESSION['email']);

		$clients=$client->getByEmail($_SESSION['email']);
		if(($idAbo=$clients->__get("abonnement"))==1) $_SESSION['abonnement']="gratuit";
		else if(($idAbo=$clients->__get("abonnement"))==2)$_SESSION['abonnement']="payant";
		else if(($idAbo=$clients->__get("abonnement"))==3)$_SESSION['abonnement']="premium";

		header("location: index.php?profil");
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
	include '../Vue/headerCo.php';
	include('../Vue/choixProfils.php');
	include '../Vue/footerNonCo.php';
}

if($module=="seance"){
	include '../Vue/headerCo.php';
	include('../Vue/creerSeance.php');
	include '../Vue/footerNonCo.php';
}

if($module=="planning"){
	include '../Vue/headerCo.php';
	include('../Vue/planningSeance.php');
	include '../Vue/footerNonCo.php';
}

if($module=="abonnement"){
	include '../Vue/headerCo.php';
	include('../Vue/abonnement.php');
	include '../Vue/footerNonCo.php';
}

//affichage du catalogue vedette
if ($module=="catalogue"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogue.php');
	include '../Vue/footerNonCo.php';
}
//Affichage des catalogues par type d'oeuvre
else if($module=="catalogueIMG"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueIMG.php');
	include '../Vue/footerNonCo.php';

}
else if($module=="catalogueEcrit"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueEcrit.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueJeux"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueJeux.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueVOD"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueVideo.php');
	include '../Vue/footerNonCo.php';
	
}
else if($module=="catalogueMus"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/catalogue/catalogueMusique.php');
	include '../Vue/footerNonCo.php';
	
}

//Affichage des différents modules de visionnage en fonction de l'oeuvre

if ($module=="visioAutre"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageAutre.php');
	include '../Vue/visionnage/footerVisionnage.php';
	include '../Vue/footerNonCo.php';
}

if ($module=="visioMusique"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageMusique.php');
	include '../Vue/visionnage/footerVisionnage.php';
	include '../Vue/footerNonCo.php';
}

if ($module=="visioVideo"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/visionnage/visionnageVideo.php');
	include '../Vue/visionnage/footerVisionnage.php';
	include '../Vue/footerNonCo.php';
}

if($module=="visioSeance"){
	include '../Vue/headerCo.php';
	include('../Vue/visionnage/visionnageSeance.php');
	include '../Vue/footerNonCo.php';
}

//Affiochage des résultats de recherche
if($module=="recherche"){
	include '../Vue/headerCo.php';
	include '../Vue/recherche.php';
	include('../Vue/resultatRecherche.php');
	include '../Vue/footerNonCo.php';
}

if($module=="favori"){
	include '../Vue/headerCo.php';
	$User=$client->getByEmail($_SESSION["email"]);
	$idClient=$User->__get('id');
	include('../Vue/listeFavori.php');
	include '../Vue/footerNonCo.php';
}

if($module=="note"){
	include '../Vue/headerCo.php';
	echo '<p>'.$message.'</p>';
	include '../Vue/footerNonCo.php';
}

if ($module=="accueil"){
	include '../Vue/headerNonCo.php';
	include('../Vue/home.php');
	include '../Vue/footerNonCo.php';

}











