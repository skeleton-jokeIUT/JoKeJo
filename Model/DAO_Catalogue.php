<?php

require_once('../Model/DTO_Catalogue.php');

class DAOCatalogue{

	private $bdd; 

	public function __construct(){
		try{
   			$this->bdd= new PDO(
   				"mysql:host=localhost;dbname=jokejo;charset=utf8",
   				'Johan',
   				'1234');
		}

		catch (Exception $e) {
     		die('Erreur'.$e->getMessage());
		}
	}

	public function getByName($nom){

		$sql ="SELECT * from catalogue where nom=?";
		$req = $this->bdd->prepare($sql);
		$req->execute([$nom]);
		
		$listeOeuvre = array();


		while($data=$req->fetch()){
			$nom=$data['nom'];
			$id=$data['idCatalogue'];
			$listeOeuvre[]=$data['idOeuvre'];
		}

		$catalogue=new DTOCatalogue($nom,$id,$listeOeuvre);

		return $catalogue;

	}

	public function afficherContenuComplet($nom){

		$this->getByName($nom);


	}

	public function afficherContenuReduit($nom){

		$this->getByName($nom);


	}
}