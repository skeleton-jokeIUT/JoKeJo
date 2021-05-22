<?php

include_once('../Model/DTO_Favori.php');
include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/Client_DAO.php');

class DAOFavori {

	private $bdd;
	private $oeuvre= new DAO_Oeuvre();
	private $client = new Client_DAO(); 

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

		$sql 'SELECT * from favori where idOeuvre=? and idClient=?';
		$req=$this->bdd->prepare($sql);
		$req->execute();

		$data=$req->fetch();

		$favori= new DTOFavori($data['idOeuvre'], $data['idClient']);

		return $favori;

	}

	public function ajoutFavori($email, $titre){

		$oeuvreAjoutee=$this->oeuvre->getByTitre($titre);
		$clientALier=$this->client->getByEmail($email);

		$idOeuvre=$oeuvreAjoutee->__get('id');
		$idClient=$clientALier->__get('id');

		$sql='INSERT INTO favori values(?,?)';
		$req= $this->bdd->prepare($sql);
		$req->execute();

	}

}