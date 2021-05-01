<?php

session_start();

include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/DAO_Catalogue.php');
include_once('../Model/DAO_Image.php');
include_once('../Model/DTO_Oeuvre.php');
include_once('../Model/DTO_Catalogue.php');
include_once('../Model/DTO_Image.php');

$image= new DAOImage();
$oeuvre= new DAOOeuvre();
$catalogue = new DAOCatalogue();

include('../Vue/catalogue.php');








