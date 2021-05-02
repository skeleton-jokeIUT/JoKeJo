<?php

include_once('Personne_DTO.php');


class Client_DTO extends Personne_DTO {
    //attributs
    private $id_personn;
    private $id_client;
    private $id_subscription;
    private $email;
    private $password;
    private $age;
    private $profil;

    //constructeur
    public function __construct($idp, $ic, $is, $e, $p, $a, $pr)
    {
        $this->id_personn = $idp;
        $this->id_client = $ic;
        $this->id_subscription= $is;
        $this->email = $e;
        $this->password = $p;
        $this->age = $a;
        $this->profil = $pr;
    }

    //getters
    public function getIdP()
    {
        return $this->id_personn;
    }
    public function getIdC()
    {
        return $this->id_client;
    }
    public function getIdS()
    {
        return $this->id_subscription;
    }
    public function getEmail()
    {
        return $this->email;
    }
    public function getPassword()
    {
        return $this->password;
    }
    public function getAge()
    {
        return $this->age;
    }
    public function getProfil()
    {
        return $this->profil;
    }

    //setters


}
