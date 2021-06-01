<?php

require_once('Personne_DTO.php');

class Personne {

	private $bdd; 

	public function __construct(){
		try{
   			$this->bdd= new PDO(
   				"mysql:host=localhost;dbname=jokejo;charset=utf8",
   				'util',
   				'Util1234!');
		}

		catch (Exception $e) {
     		die('Erreur'.$e->getMessage());
		}
	}

}
