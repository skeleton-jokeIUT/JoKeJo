<?php

session_start();

include_once('../Model/DAO_Oeuvre.php');
include_once('../Model/DAO_Catalogue.php');
include_once('../Model/DAO_image.php');

$image=new DAOImage();

$image->getByName("La Joconde");


