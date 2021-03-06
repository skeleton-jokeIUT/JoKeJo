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
    public function __get($attr)
    {
        switch ($attr) {
            case 'id':
                return $this->idClients;
                break;

             case 'email':
                return $this->adresseMail;
                break;

             case 'abonnement':
                return $this->idAbonnement;
                break;
            default:
                return "problème";
                break;
        }

    }

    public function getMDP()
    {
        return $this->motDePasse;
    }


}
