<?php

require_once('../Model/DTO_Image.php');

class DAOImage extends DAOOeuvre{

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

	public function getByTitre($titre){

		$sql ='SELECT * from oeuvre, image where titre=? and oeuvre.idOeuvre = image.idOeuvre';
		var_dump($sql);
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		$data=$req->fetch();

		echo $data['idOeuvre'].$data['titre'].$data['format'];

		
	}

	public function afficherMiniature($titre, $idOeuvre){

		$catalogue=$this->getByTitre($tire);

	}

}