<?php


require_once('Client_DTO.php');

class Client_DAO extends Personne_DAO {
    private $bdd;

    public function __construct($host, $dbname, $bddid, $bddpsswd)
    {
        try {
            $this->bdd=new PDO("mysql:host=$host; dbname=$dbname; charset=utf8", "$bddid", "$bddpwd");
			$this->bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        } catch(Exception $e) {
        die('Erreur: ' . $e->getMessage());
        }
    }

    public function getByLogin($u)
    {
        $requete = 'select * from Client where login = ?';
        $req = $this -> bdd -> prepare($requete);
        $resultat = $req -> fetch();
        $client = new Client_DTO( ,  , ,$resultat[] ,$resultat[] ,$resultat[]);        //attention aux noms de variables
        return $client;
    }

    public function inscription($login, $password)
    {

    }

    public function connection()
    {

    }
}
