<?php

require_once('../Model/DTO_Oeuvre.php');

class DAOOeuvre{

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

		$sql ='SELECT * from oeuvre where titre=?';
		var_dump($sql);
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		$data=$req->fetch();

		echo $data['idOeuvre']." ".$data['titre'];

		
	}
}