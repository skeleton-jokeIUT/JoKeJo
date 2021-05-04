<?php

include_once('Personne_DTO.php');


class Client_DTO extends Personne_DTO {
    //attributs
    private $idClients;
    private $adresseMail;
    private $motDePasse;
    private $idAbonnement;

    //constructeur
    public function __construct($idp, $mail, $mdp, $abonnement)
    {
        $this->idClients = $idp;
        $this->adresseMail = $mail;
        $this->motDePasse = $mdp;
        $this->idAbonnement = $abonnement;
    }

    //getters
    public function getIdC()
    {
        return $this->idClients;
    }
    public function getEmail()
    {
        return $this->adresseMail;
    }
    public function getMDP()
    {
        return $this->motDePasse;
    }
    public function getAbonnement()
    {
        return $this->idAbonnement;
    }
    
    //setters


}
