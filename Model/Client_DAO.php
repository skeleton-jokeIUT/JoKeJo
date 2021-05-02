<?php


require_once('Client_DTO.php');
require_once('Personne_DAO.php');

class Client_DAO extends Personne {
    private $bdd; 

    public function __construct(){
        try{
            $this->bdd= new PDO(
                "mysql:host=localhost;dbname=jokejo;charset=utf8",
                'Johan',
                '1234');
        }

        catch (Exception $e) {
            die('Erreur'.$e->getMessage());
        }
    }
    public function getByEmail($e)
    {
        $requete = 'select * from Client where email = ?';
        $req = $this -> bdd -> prepare($requete);
        $req -> execute([$l]);
        $resultat = $req -> fetch();
        $client = new Client_DTO($resultat['id_personn'], $resultat['id_client'], $resultat['id_subscription'], $e, $resultat['password'], $resultat['age'], $resultat['profil']);        //attention aux noms de variables
        return $client;
    }

    public function inscription($email, $password, $age, $profil)
    {
        $requete = 'insert into Client (email, password, age, profil) values (:t_email, :t_password, :t_age, :t_profil)';
        $req -> $this -> bdd -> prepare ($requete);
        $req -> execute(array($email, $password, $age, $profil));
    }

    public function connection($email)
    {
        $requete = 'select * from Client  where email =: email';
        $req = $this -> bdd -> prepare ($requete);
        $resultat = $req -> fetch();
        $req -> closeCursor();
        return $resultat;
    }

    public function updInscription($email, $password)
    {
        $requete = 'update Client set password=:password where email=:email';
        $req = $this -> bdd -> prepare($requete);
        $req -> execute(array('password' => $password, 'email' => $email));
        $req -> closeCursor();
    }
}
