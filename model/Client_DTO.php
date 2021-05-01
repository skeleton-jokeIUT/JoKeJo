<?php


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
    public function __construct($ip, $ic, $is, $e, $p, $a, $p)
    {
        $this -> id_personn = $ip;
        $this -> id_client = $ic;
        $this -> id_subscription= $is;
        $this -> email = $e;
        $this -> password = $p;
        $this -> age = $a;
        $this -> profil = $p;
    }

    //getters
    public function getIdP()
    {
        return $this -> id_personn;
    }
    public function getIdC()
    {
        return $this -> id_client;
    }
    public function getIdS()
    {
        return $this -> id_subscription;
    }
    public function getEmail()
    {
        return $this -> email;
    }
    public getPassword()
    {
        return $this -> password;
    }
    public getAge()
    {
        return $this -> age;
    }
    public getProfil()
    {
        return $this -> profil;
    }

    //setters


}
