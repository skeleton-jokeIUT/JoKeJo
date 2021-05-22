<?php

include_once('../Model/DTO_Favori.php');

class DTOFavori{

	private $idClient;
	private $idOeuvre;

	public function __construct($idOeuvre,$idClient){
		$this->idClient=$idClient;
		$this->idOeuvre=$idOeuvre;
	}

	public function __get($attribut){
		switch ($attribut) {
			case 'idClient':
				return $this->idClient
				break;

			case 'idOeuvre':
				return $this->idOeuvre;
				break;
			
			default:
				return "problème";
				break;
		}
	}

}