<?php

class DTOOeuvre{

	private $idOeuvre;
	private $titre;
	private $dateDeSortie;
	private $type;
	private $catPrincipale;
	private $catSecondaire;
	private $ageMini;
 	private $prixAchat;
	private $prixLocation;
	private $cheminAcces;
	private $miniature;


	public function __construct($idOeuvre,$titre,$dateDeSortie,$type,$catPrincipale,$catSecondaire,$ageMini,$prixAchat,$prixLocation,$cheminAcces,$miniature){

		$this->idOeuvre=$idOeuvre;
		$this->titre=$titre;
		$this->dateDeSortie=$dateDeSortie;
		$this->type=$type;
		$this->catPrincipale=$catPrincipale;
		$this->catSecondaire=$catSecondaire;
		$this->ageMini=$ageMini;
		$this->prixAchat=$prixAchat;
		$this->prixLocation=$prixLocation;
		$this->cheminAccès=$cheminAcces;
		$this->miniature=$miniature;

	}

	public function __get($attr){
		switch ($attr) {
			case 'id':
				return $this->idOeuvre;
				break;
			
			default:
				return "problème";
				break;
		}
	}


}