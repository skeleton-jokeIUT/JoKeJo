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

		

		
	}

	public function afficherMiniatureReduit($type){

		$sql ='SELECT titre,miniature,type from oeuvre where type=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$type]);

		
		for($i=0;$i<3;$i++){

			$data=$req->fetch();
			echo '<a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'"><img src="'.$data['miniature'].'.jpg"></a>';
		}
		
	}


	public function afficherMiniatureComplet($type){

		$sql ='SELECT  miniature, titre, type from oeuvre where type=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$type]);

		while($data=$req->fetch()){

			echo '<a href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'"><img src="'.$data['miniature'].'.jpg"></a>';
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
}