<?php

class DTOCatalogue{

	private $nom;
	private $idCatalogue;
	private $idOeuvre;
	

	public function __construct($nom,$idCatalogue,$idOeuvre){

		$this->idCatalogue=$idCatalogue;
		$this->idOeuvre=$idOeuvre;
		$this->nom=$nom;
	}

	public function __get($attribut){

		switch ($attribut) {
			case 'nom':
				return $this->nom;
				break;

			case 'idCatalogue':
				return $this->idCatalogue;
				break;

			case 'idOeuvre':
				return $this->idOeuvre;
				break;
			
			default:
				echo "Erreur";
				break;
		}
	}
}