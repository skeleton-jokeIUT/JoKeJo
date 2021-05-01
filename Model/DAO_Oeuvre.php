<?php

require_once('../Model/DTO_Oeuvre.php');

class DAOOeuvre{

	private $bdd; 

	public function __construct(){
		try{
   			$this->bdd= new PDO(
   				"mysql:host=localhost;dbname=surv'easy;charset=utf8",
   				'Johan',
   				'1234');
		}

		catch (Exception $e) {
     		die('Erreur'.$e->getMessage());
		}
	}

	public function getByTitre($titre){

		$sql ="SELECT * from oeuvre, image where oeuvre.titre=?";
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		$data=$req->fetch($req);

		echo $data['idOeuvre'].$data['titre'].$data['type'].$data['format'];

	}
}