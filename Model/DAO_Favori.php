<?php

include_once('../Model/DTO_Favori.php');
include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/Client_DAO.php');

class DAOFavori {

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

	public function getByID($idOeuvre, $idClient){

		$sql= 'SELECT * from favori where idOeuvre=? and idClient=?';
		$req=$this->bdd->prepare($sql);
		$req->execute();

		$data=$req->fetch();

		$favori= new DTOFavori($data['idOeuvre'], $data['idClient']);

		return $favori;

	}

	public function ajoutFavori($idOeuvre, $idClient){

		$sql='INSERT INTO favori values(?,?)';
		$req= $this->bdd->prepare($sql);
		$req->execute([$idOeuvre, $idClient]);

	}

	public function listeFavori($idClient){

		
		$sql='SELECT * from favori where id=?';
		$req=$this->bdd->prepare($sql);
		$req->execute([$idClient]);

		while($data=$req->fetch()){
			echo "coucou";
			echo '<p><a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'">'.$data['titre'].'</a>   '.$data['type'].'  '.$data['duree'].'</p>';

		}


	}

	public function suppressionFavori($email, $titre){

		$oeuvre = new DAOOeuvre();
		$client = new Client_DAO();

		$oeuvreAjoutee=$this->oeuvre->getByTitre($titre);
		$clientALier=$this->client->getByEmail($email);

		$idOeuvre=$oeuvreAjoutee->__get('id');
		$idClient=$clientALier->__get('id');

		$sql='DELETE FROM favori where idOeuvre=? and idClient=?';
		$req= $this->bdd->prepare($sql);
		$req->execute([$idOeuvre, $idClient]);
	}

}