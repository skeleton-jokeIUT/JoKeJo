<?php

/**
 * 
 */
class DTONote
{
	
	private $idOeuvre;
	private $idClient;
	private $note;

	public function __construct($idOeuvre, $idClient, $note)
	{
		$this->idOeuvre=$idOeuvre;
		$this->idClient=$idClient;
		$this->note=$note;
	}

	public function __get($attr){
		switch ($attr) {
			case 'idClient':
				return $this->idClient;
				break;
			case 'idOeuvre':
				return $this->idOeuvre;
				break;
			
			case 'note':
				return $this->note;
				break;
			
			
			default:
				return "problème";
				break;
		}
	}

}