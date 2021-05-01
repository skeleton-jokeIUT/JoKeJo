<?php

class Catalogue{

	private $idCatalogue;
	private $idOeuvre;
	private $nom;

	public function __construct($idCatalogue,$idOeuvre,$nom){

		$this->idCatalogue=$idCatalogue;
		$this->idOeuvre=$idOeuvre;
		$this->nom=$nom;
	}
}