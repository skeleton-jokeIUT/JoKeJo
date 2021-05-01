<?php

Class DTOPersonne{

	private $idPersonne;
	private $nom;
	private $prenom;

	public function __construct($idP,$nom,$prenom){
		$this->idPersonne=$idP;
		$this->nom=$nom;
		$this->prenom=$prenom;
	}

	public function __get($attribut){

		switch ($attribut) {
			case 'id':
				return $this->idPersonne;
				break;
			
			case 'nom':
				retrun $this->nom;
				break;

			case 'prenom':
				return $this->prenom;
				break;

			default:
				return "erreur"
				break;
		}

	}

	public function __set($attribut, $valeur){

		switch ($attribut) {
			case 'id':
				$this->idPersonne=$valeur;
				break;
			
			case 'nom':
				$this->nom=$valeur;
				break;

			case 'prenom':
				$this->prenom=$valeur;
				break;

			default:
				return "erreur"
				break;
		}
}