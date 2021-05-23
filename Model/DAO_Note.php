<?php

require_once('../Model/DTO_Note.php');

class DAONote{

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

	public function getById($idOeuvre, $idClient){



	}

	public function ajoutNote($idOeuvre, $idClient,$note){

		if($this->verifNoteExiste($idClient,$idOeuvre)==true){
			//update mais pour l'instant rien
			return $message="Vous avez déjà noté cette oeuvre";
		}
		else{

			$sql='INSERT INTO note values(:t_idOeuvre,:t_idClient,:t_note)';
			$req=$this->bdd->prepare($sql);
			$req->execute(array('t_idOeuvre' =>$idOeuvre ,
				 				't_idClient'=>$idClient,
				 				't_note'=>$note));

			return $message="Votre note a bien été prise en compte";
		}

	}

	public function verifNoteExiste($idClient, $idOeuvre){

		$sql='SELECT * from note where idOeuvre=:t_idOeuvre and idClient=:t_idClient';
		$req=$this->bdd->prepare($sql);
		$req->execute(array('t_idOeuvre' =>$idOeuvre ,
			 				't_idClient'=>$idClient));

		if($req->fetch()) return true;
		else return false;

	}
}