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
        $requete = 'SELECT * from clients where adresseMail = ?';
        $req = $this->bdd->prepare($requete);
        $req->execute([$e]);
        $resultat = $req->fetch();
        $client = new Client_DTO($resultat['idClients'], $resultat['adresseMail'], $resultat['motDePasse'], $resultat['abonnement']);        
        //attention aux noms de variables
        return $client;
    }

    public function inscription($email, $motDePasse, $abonnement, $nomprofil, $ageProfil)
    {
        
        $requete = 'INSERT INTO clients (adresseMail, motDePasse, abonnement) values (:t_email, :t_motDePasse, :t_abonnement)';
        $req= $this->bdd->prepare($requete);
        $req->execute(array('t_email'=>$email, 't_motDePasse'=>$motDePasse, 't_abonnement'=>$abonnement));

        $client = $this->getByEmail($email);
        $id=$client->getIdC();

        echo $client->getEmail();

        $_SESSION['email'] = $client->getEmail();
        $_SESSION['abonnement']=$client->getAbonnement();

        echo "test".$id;

        if($nomprofil=="") $nomprofil="default";
        if($ageProfil=="") $ageProfil=100;

        $requete = 'INSERT INTO profil (idClient, nom, age) values(?,?,?)';
        $req= $this->bdd->prepare($requete);
        $req->execute([$id,$nomprofil,$ageProfil]);


    }

    public function connection($login,$mdp,&$message,&$module){

        $requete = 'SELECT adresseMail from clients where adresseMail= ?';
        $reponse = $this->bdd->prepare($requete);
        $reponse->execute([$login]);
        $data = $reponse->fetch();      

        if ($login==$data['adresseMail'])
        {


            $requete = 'SELECT motDePasse from clients where adresseMail= :_email';
            $reponse = $this->bdd->prepare($requete);
            $reponse ->execute( array('_email'=>$login));
            $verif = $reponse->fetch();

            if ($mdp==$verif['motDePasse'])
            {
                $requete = 'SELECT * from clients where adresseMail= :_email';
                $reponse = $this->bdd->prepare($requete);
                $reponse ->execute( array('_email'=>$login));
                $data = $reponse->fetch();

                $_SESSION['email']=$data['adresseMail'];
                $_SESSION['abonnement']=$data['abonnement'];
                $module="profil";
            }

            else 
            {
                $message="votre mot de passe est incorrect."; 
                $module="connexion";
            }

        }
        else 
        {
            $message="Adresse mail inconnue ou erronée. Merci de reéssayer";
            $module="connexion";
        }
    }

    public function updInscription($email, $motDePasse)
    {
        $requete = 'update Client set motDePasse=:motDePasse where email=:email';
        $req = $this -> bdd -> prepare($requete);
        $req -> execute(array('motDePasse' => $motDePasse, 'email' => $email));
        $req -> closeCursor();
    }
}