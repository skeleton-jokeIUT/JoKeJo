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
   				'util',
   				'Util1234!');
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

		
		$sql='SELECT * from favori where idClient=?';
		$req=$this->bdd->prepare($sql);
		$req->execute([$idClient]);

		$listeOeuvre=array();

		while($data=$req->fetch()){

			$listeOeuvre[]=$data['idOeuvre'];
		}

		foreach ($listeOeuvre as $value) {

			$sql='SELECT * from oeuvre where idOeuvre=?';
			$req=$this->bdd->prepare($sql);
			$req->execute([$value]);

			$data2=$req->fetch();

			if($data2['duree']==0){
				$data2['duree']="Indéfini";
			}
			else $data2['duree']=$data2['duree']."min";
		
			echo '<div class="test">
						<a href="index.php?visionnage='.$data2['type'].'&titre='.$data2['titre'].'"><img src="'.$data2['miniature'].'"></a>
						<p>Titre : '.$data2['titre'].'<br><br>Type : '.$data2['type'].'<br><br>Duree : '.$data2['duree'].'<br><br>Accès : '.$data2['acces'].'</p>
						<a href="index.php?supprFav='.$data2['titre'].'"><button>Supprimer</button></a>
				</div>';

		}

	}

	public function suppressionFavori($idOeuvre, $idClient){

		$sql='DELETE FROM favori where idOeuvre=? and idClient=?';
		$req= $this->bdd->prepare($sql);
		$req->execute([$idOeuvre, $idClient]);
	}

}