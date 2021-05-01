<?php

session_start();

include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/DAO_Catalogue.php');
include_once('../Model/DAO_Image.php');

$image= new DAOImage();
$oeuvre= new DAOOeuvre();

$oeuvre->getByTitre("Guernica");



