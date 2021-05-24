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

	public function creerSeancePrivee($nom,$horaire,$oeuvre){

		$sql='INSERT INTO seance (nom,type,idOeuvre,horaire) values (:t_nom, :t_type, :t_oeuvre, :t_horaire)';
		$req=$this->bdd->prepare($sql);
		$req->execute(array('t_nom' =>$nom,
							't_type'=>"PRIVEE",
							't_horaire'=>$horaire,
							't_oeuvre'=>$oeuvre));
	}

	public function listeSeance($type){
		$sql='SELECT * from seance where type=?';
		$req=$this->bdd->prepare($sql);
		$req->execute([$type]);

		while($data=$req->fetch()){

			$sql2='SELECT * from oeuvre where idOeuvre=?';
			$req2=$this->bdd->prepare($sql2);
			$req2->execute([$data['idOeuvre']]);

			$data2=$req2->fetch();

			echo 'Nom : '.$data['nom'].' Oeuvre : '.$data2['titre'].' Horaire : '.$data['horaire'].'<br>';
		}
	}
}

