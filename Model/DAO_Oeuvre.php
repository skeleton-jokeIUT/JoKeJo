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
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		$data=$req->fetch();

	$oeuvre = new DTOOeuvre($data['idOeuvre'],$data['titre'],$data['dateDeSortie'],$data['type'],$data['catPrincipale'],$data['catSecondaire'],$data['ageMini'],$data['prixAchat'],$data['prixLocation'],$data['cheminAcces'],$data['miniature']);		
		
	return $oeuvre;
	}

	public function afficherMiniatureReduit($type){

		$sql ='SELECT titre, miniature, type, acces from oeuvre where type=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$type]);

		
		for($i=0;$i<3;$i++){

			$data=$req->fetch();
			echo '<a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'&acces='.$data['acces'].'"><img src="'.$data['miniature'].'.jpg"></a>';
		}
		
	}


	public function afficherMiniatureComplet($type){

		$sql ='SELECT  miniature, titre, type, acces from oeuvre where type=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$type]);

		while($data=$req->fetch()){

			echo '<a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'&acces='.$data['acces'].'"><img src="'.$data['miniature'].'.jpg"></a>';
		}

	}

	public function recupCheminAcces($titre){



		$sql ='SELECT  cheminAcces from oeuvre where titre=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		$data=$req->fetch();
		
		if($data['cheminAcces']==null){
			header('Location: https://www.youtube.com/watch?v=dQw4w9WgXcQ');
		}
		else{
			echo $data['cheminAcces'];
		}
	}

	public function rechercher($titre){

		$titre = '%'.$titre.'%';

		$sql ='SELECT * from oeuvre where titre like ?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$titre]);

		while($data=$req->fetch()){
		
			echo '<p><a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'">'.$data['titre'].'</a>   '.$data['type'].'  '.$data['duree'].'</p>';

		}

	}
}