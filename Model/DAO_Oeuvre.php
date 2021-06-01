<?php

require_once('../Model/DTO_Oeuvre.php');

class DAOOeuvre{

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
			echo '<a title="'.$data['titre'].'"href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'&acces='.$data['acces'].'"><img src="'.$data['miniature'].'"></a>';
		}
		
	}


	public function afficherMiniatureComplet($type){

		$sql ='SELECT  miniature, titre, type, acces, duree from oeuvre where type=?';
		$req = $this->bdd->prepare($sql);
		$req->execute([$type]);

		while($data=$req->fetch()){

			if($data['duree']==0){
				$data['duree']="Indéfini";
			}
			else $data['duree']=$data['duree']."min";
		
			echo '<div class="test">
						<a  href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'"><img src="'.$data['miniature'].'"</a>
						<p>Titre : '.$data['titre'].'<br><br>Type : '.$data['type'].'<br><br>Duree : '.$data['duree'].'<br><br>Accès : '.$data['acces'].'</p>

				</div>';
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

			if($data['duree']==0){
				$data['duree']="Indéfini";
			}
			else $data['duree']=$data['duree']."min";
		
			echo '<div class="test">
						<a  href="index.php?visionnage='.$data['type'].'&titre='.$data['titre'].'"><img src="'.$data['miniature'].'"</a>
						<p>Titre : '.$data['titre'].'<br><br>Type : '.$data['type'].'<br><br>Duree : '.$data['duree'].'<br><br>Accès : '.$data['acces'].'</p>

				</div>';

		}

	}

	public function afficherListeTitre(){

		$sql='SELECT * from oeuvre where type ="Vidéo"';
		$req=$this->bdd->prepare($sql);
		$req->execute();

		while($data=$req->fetch()){

			echo '<option value="'.$data['titre'].'">'.$data['titre'].'</option>';

		}

	}
}