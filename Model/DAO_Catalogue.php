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
		$data=$req->fetch($req);

	}
}