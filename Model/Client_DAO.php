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
        $requete = 'SELECT * from clients where email = ?';
        $req = $this->bdd->prepare($requete);
        $req -> execute([$e]);
        $resultat = $req->fetch();
        $client = new Client_DTO($resultat['idClients'], $resultat['adresseMail'], $resultat['motDePasse'], $e, $resultat['abonnement']);        
        //attention aux noms de variables
        return $client;
    }

    public function inscription($email, $password, $abonnement, $nomprofil, $ageProfil)
    {
        
        $requete = 'INSERT INTO clients (adresseMail, motDePasse, abonnement) values (:t_email, :t_password, :t_abonnement)';
        $req= $this->bdd->prepare($requete);
        $req->execute(array('t_email'=>$email, 't_password'=>$password, 't_abonnement'=>$abonnement));

        $client = $this->getByEmail($email);
        $id=$client->getIdC();


        echo "test".$id;

        if($nomprofil=="") $nomprofil="default";
        if($ageProfil=="") $ageProfil=100;

        $requete = 'INSERT INTO profil (idClient, nom, age) values(?,?,?)';
        $req= $this->bdd->prepare($requete);
        $req->execute([$id,$nomprofil,$ageProfil]);


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
