<?php

include_once('DTO_Note.php');

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

	public function ajoutNote($idClient, $idOeuvre,$note){

		if(verifNoteExiste($idClient,$idOeuvre)==true){
			
		}
		else{

			$sql='INSERT INTO note values(:t_idOeuvre,:t_idClient,:t_note)';
			$req=$this->bdd->preparer($sql);
			$req->execute(array('t_idOeuvre' =>$idOeuvre ,
				 				't_idClient'=>$idClient,
				 				't_note'=>$note););
		}

	}

	public function verifNoteExiste($idClient, $idOeuvre){

		$sql='SELECT * from note where idOeuvre=:t_idOeuvre and idClient=:t_idClient';
		$req=$this->bdd->preparer($sql);
		$req->execute(array('t_idOeuvre' =>$idOeuvre ,
			 				't_idClient'=>$idClient););

		if($req->fetch()) return true;
		else return false;

	}
}