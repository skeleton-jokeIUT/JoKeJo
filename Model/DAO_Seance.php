<?php

require_once('../Model/DTO_Seance.php');

class DAOSeance{

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

	public function listeSeance($type){
		$sql='SELECT * from seance where type=?';
		$req=$this->bdd->prepare($sql);
		$req->execute([$type]);

		while($data=$req->fetch()){
			echo 'Nom : '.$data['nom'].' Oeuvre : '.$data['idOeuvre'].' Horaire : '.$data['horaire'].'<br>';
		}
	}
}

