<?php


class Client_DTO extends Personne_DTO {
    //attributs
    private $id_personn;
    private $id_client;
    private $id_subscription;
    private $email;
    private $login;
    private $password;

    //constructeur
    public function __construct($ip, $ic, $is, $e, $l, $p)
    {
        $this -> id_personn = ip;
        $this -> id_client = c;
        $this -> id_subscription = is;
        $this -> email = $e;
        $this -> login = $l;
        $this -> password = $p;
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
    public function getLogin()
    {
        return $this -> login;
    }
    public getPassword()
    {
        return $this -> password;
    }

    //setters


}
