<?php

class DTOSeance{

	private $idSeance;
	private $nom;
	private $type;
	private $idOeuvre;
	private $horaire;

	public function __construct($idSeance,$nom,$type,$idOeuvre,$horaire){

		$this->idSeance=$idSeance;
		$this->nom=$nom;
		$this->type==$type;
		$this->idOeuvre=$idOeuvre;
		$this->horaire=$horaire;
	}

	public function __get($attr){
		switch ($attr) {
			case 'idSeance':
				return $this->idSeance;
				break;
			case 'nom':
				return $this->nom;
				break;
			case 'type':
				return $this->type;
				break;
			case 'idOeuvre':
				return $this->idOeuvre;
				break;
			case 'horaire':
				return $this->horaire;
				break;
			
			default:
				return "problème";
				break;
		}
	}
}