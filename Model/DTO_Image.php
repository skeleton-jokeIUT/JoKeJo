<?php

include_once('../Model/DTO_Oeuvre.php');

class DTOImage extends DTOOeuvre{

	private $auteurs;
	private $format;

	public function __construct($idOeuvre,$titre,$dateDeSortie,$type,$catPrincipale,$catSecondaire,$ageMini,$prixAchat,$prixLocation,$cheminAccès,$miniature,  $auteurs, $format){

		$this->auteurs=$auteurs;
		$this->format=$format;

		parent::__construct($idOeuvre,$titre,$dateDeSortie,$type,$catPrincipale,$catSecondaire,$ageMini,$prixAchat,$prixLocation,$cheminAccès,$miniature);


	}

}