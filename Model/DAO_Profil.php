<?php

class DAOProfil{

	private $bdd; 

	public function __construct(){
		try{
   			$this->bdd= new PDO(
   				"mysql:host=localhost;dbname=jokejo;charset=utf8",
   				'util',
   				'1234');
		}

		catch (Exception $e) {
     		die('Erreur'.$e->getMessage());
		}
	}

	public function creerProfil($idClient, $nomProfil, $ageProfil){


		if($nomProfil=="") $nomProfil="default";
        if($ageProfil=="") $ageProfil=100;


        $sql = 'INSERT INTO profil (idClient, nom, age) values(?,?,?)';
        $req= $this->bdd->prepare($sql);
        $req->execute([$idClient,$nomProfil,$ageProfil]);

	}

	public function listeProfil($idClient){

		$sql='SELECT * from profil where idClient=?';
		$req=$this->bdd->prepare($sql);
		$req->execute([$idClient]);

		while($data=$req->fetch()){

			echo '<a href="index.php?catalogue"><img src="../Vue/image/avatar.png" alt="image de votre avatar" class="img"></a>';

		}

	}

	//Appelé pour ajouter des profils à un compte déjà existant
	public function ajoutProfil($idClient,$ageProfil,$nomProfil){
		if($nomProfil=="") $nomProfil="default";
        if($ageProfil=="") $ageProfil=100;

        $sql='SELECT count(*) as nombre from profil where idClient=?';
        $req=$this->bdd->prepare($sql);
        $req->execute([$idClient]);

        $data=$req->fetch();

        if(($data['nombre'])<4){

	        $sql = 'INSERT INTO profil (idClient, nom, age) values(?,?,?)';
	        $req= $this->bdd->prepare($sql);
	        $req->execute([$idClient,$nomProfil,$ageProfil]);

	    }
	    else return "Vous avez atteint le nombre maximum de profil !";

	}
}