-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 23 mai 2021 à 15:24
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jokejo`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

DROP TABLE IF EXISTS `abonnement`;
CREATE TABLE IF NOT EXISTS `abonnement` (
  `idAbonnement` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) COLLATE utf8_bin NOT NULL,
  `prix` float DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idAbonnement`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `abonnement`
--

INSERT INTO `abonnement` (`idAbonnement`, `nom`, `prix`, `description`) VALUES
(1, 'gratuit', 0, 'ouvre très peu de droit'),
(2, 'payant', 9.99, 'ouvre certains droits'),
(3, 'premium', 19.99, 'ouvre tous les droits');

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE IF NOT EXISTS `artiste` (
  `idArtiste` int(100) NOT NULL AUTO_INCREMENT,
  `nationalite` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `lienIMDB` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `lienWikipedia` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `metier` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idArtiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE IF NOT EXISTS `catalogue` (
  `nom` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `idCatalogue` int(255) NOT NULL,
  `idOeuvre` int(255) NOT NULL,
  PRIMARY KEY (`idCatalogue`,`idOeuvre`),
  KEY `idOeuvre` (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`nom`, `idCatalogue`, `idOeuvre`) VALUES
('Image', 1, 5),
('Image', 1, 10),
('Image', 1, 11);

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `idClients` int(255) NOT NULL AUTO_INCREMENT,
  `adresseMail` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `motDePasse` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `idAbonnement` int(1) DEFAULT NULL,
  PRIMARY KEY (`idClients`),
  KEY `idAbonnement` (`idAbonnement`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`idClients`, `adresseMail`, `motDePasse`, `idAbonnement`) VALUES
(1, 'j@m.fr', '1234', 1),
(4, 'j.m@couc.fr', '1234', 2),
(9, 'j.m@yolo.fr', '12', 3),
(10, 'test@test.fr', '1', 1),
(11, 'test@tes.fr', '1', 2),
(12, 'a.a@a.fr', '1234', 1),
(13, 'jo@jb.fr', '1234', 1);

-- --------------------------------------------------------

--
-- Structure de la table `ecrit`
--

DROP TABLE IF EXISTS `ecrit`;
CREATE TABLE IF NOT EXISTS `ecrit` (
  `idOeuvre` int(255) NOT NULL,
  `idAuteur` int(255) DEFAULT NULL,
  `editeur` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `nbPage` int(255) DEFAULT NULL,
  `format` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `ecrit`
--

INSERT INTO `ecrit` (`idOeuvre`, `idAuteur`, `editeur`, `nbPage`, `format`) VALUES
(1, 1, 'Kana', 200, 'Manga'),
(6, 2, 'Edition1', 200, 'Roman'),
(7, 3, 'Edition2', 200, 'Roman');

-- --------------------------------------------------------

--
-- Structure de la table `favori`
--

DROP TABLE IF EXISTS `favori`;
CREATE TABLE IF NOT EXISTS `favori` (
  `idOeuvre` int(255) NOT NULL,
  `idClient` int(255) NOT NULL,
  PRIMARY KEY (`idOeuvre`,`idClient`),
  KEY `idClients` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `favori`
--

INSERT INTO `favori` (`idOeuvre`, `idClient`) VALUES
(1, 1),
(3, 1),
(9, 1),
(11, 1);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `idOeuvre` int(255) NOT NULL,
  `idAuteur` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `format` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `jeuxvideo`
--

DROP TABLE IF EXISTS `jeuxvideo`;
CREATE TABLE IF NOT EXISTS `jeuxvideo` (
  `idOeuvre` int(255) NOT NULL,
  `studio` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `flag` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `score` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`),
  KEY `idOeuvre` (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `jeuxvideo`
--

INSERT INTO `jeuxvideo` (`idOeuvre`, `studio`, `flag`, `score`) VALUES
(4, '7', 'solo', '0'),
(12, '8', 'solo', '0'),
(13, '9', 'solo', '0');

-- --------------------------------------------------------

--
-- Structure de la table `listedelecture`
--

DROP TABLE IF EXISTS `listedelecture`;
CREATE TABLE IF NOT EXISTS `listedelecture` (
  `idOeuvre` int(255) NOT NULL,
  `idClients` int(255) NOT NULL,
  PRIMARY KEY (`idOeuvre`,`idClients`),
  KEY `idClients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

DROP TABLE IF EXISTS `musique`;
CREATE TABLE IF NOT EXISTS `musique` (
  `idOeuvre` int(255) NOT NULL,
  `idCompositeur` int(255) DEFAULT NULL,
  `idMusiciens` int(255) DEFAULT NULL,
  `parole` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `musique`
--

INSERT INTO `musique` (`idOeuvre`, `idCompositeur`, `idMusiciens`, `parole`) VALUES
(3, 11, 11, 'blabla'),
(14, 10, 0, 'blibli'),
(15, 12, 12, 'bloblo');

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `idOeuvre` int(255) NOT NULL,
  `idClient` int(255) NOT NULL,
  `note` float DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`,`idClient`),
  KEY `idClients` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`idOeuvre`, `idClient`, `note`) VALUES
(1, 1, 1),
(3, 1, 5),
(11, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

DROP TABLE IF EXISTS `oeuvre`;
CREATE TABLE IF NOT EXISTS `oeuvre` (
  `idOeuvre` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `dateDeSortie` date DEFAULT NULL,
  `type` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `duree` float DEFAULT NULL,
  `catPrincipale` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `catSecondaire` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `ageMini` int(3) DEFAULT NULL,
  `acces` varchar(30) COLLATE utf8_bin NOT NULL,
  `prixAchat` float DEFAULT NULL,
  `prixLocation` float DEFAULT NULL,
  `cheminAcces` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `miniature` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `oeuvre`
--

INSERT INTO `oeuvre` (`idOeuvre`, `titre`, `dateDeSortie`, `type`, `duree`, `catPrincipale`, `catSecondaire`, `ageMini`, `acces`, `prixAchat`, `prixLocation`, `cheminAcces`, `miniature`) VALUES
(1, 'Naruto', NULL, 'Ecrit', NULL, NULL, NULL, NULL, 'premium', 6, 3, '../../cheminAcces/fichier/Ecrit/narutoT1.jpg', '../../cheminAcces/miniature/Naruto\r\n'),
(2, 'The Big Lebowski', NULL, 'Vidéo', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/TBL'),
(3, 'Lost Paradise', NULL, 'Musique', NULL, NULL, NULL, NULL, 'premium', 2, 1, '../../cheminAcces/fichier/Musique/LostParadise.mp3', '../../cheminAcces/miniature/LostParadise'),
(4, 'Final Fantasy VII', NULL, 'Jeux-Vidéo', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/FFVII'),
(5, 'La Joconde', NULL, 'Image', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/Joconde'),
(6, 'Le seigneur des anneaux', NULL, 'Ecrit', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/SDA1'),
(7, 'Harry Potter', NULL, 'Ecrit', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/HarryPotter'),
(8, 'Avengers', NULL, 'Vidéo', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/Avengers'),
(9, 'What The Cut ep37', NULL, 'Vidéo', NULL, NULL, NULL, NULL, 'payant', 2, 0.5, '../../cheminAcces/fichier/Video/WHATTHECUT37.mp4', '../../cheminAcces/miniature/WTC37'),
(10, 'Le radeau de la méduse', NULL, 'Image', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/RadeauDeLaMeduse'),
(11, 'Guernica', NULL, 'Image', NULL, NULL, NULL, NULL, 'gratuit', 0, 0, '../../cheminAcces/fichier/Image/Guernica.jpg', '../../cheminAcces/miniature/Guernica'),
(12, 'Tetris', NULL, 'Jeux-Vidéo', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/Tetris'),
(13, 'Donkey-Kong', NULL, 'Jeux-Vidéo', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/DKong'),
(14, 'Highway to Hell', NULL, 'Musique', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/HtH'),
(15, 'J\'irais ou tu iras', NULL, 'Musique', NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, '../../cheminAcces/miniature/Jirais');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `idPersonne` int(100) NOT NULL,
  `nom` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `prenom` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `idClients` int(255) DEFAULT NULL,
  `idArtiste` int(255) DEFAULT NULL,
  PRIMARY KEY (`idPersonne`),
  KEY `idArtiste` (`idArtiste`),
  KEY `idClients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `idProfil` int(255) NOT NULL AUTO_INCREMENT,
  `idClient` int(255) NOT NULL,
  `nom` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) NOT NULL,
  `avatar` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idProfil`,`idClient`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`idProfil`, `idClient`, `nom`, `age`, `avatar`) VALUES
(1, 9, 'default', 100, NULL),
(2, 10, 'default', 100, NULL),
(3, 11, 'coucou', 18, NULL),
(4, 12, 'TEST', 18, NULL),
(5, 13, '1234', 19, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `idSeance` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `idOeuvre` int(255) DEFAULT NULL,
  `horaire` date DEFAULT NULL,
  PRIMARY KEY (`idSeance`),
  KEY `idOeuvre` (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `support`
--

DROP TABLE IF EXISTS `support`;
CREATE TABLE IF NOT EXISTS `support` (
  `idSupport` int(255) NOT NULL AUTO_INCREMENT,
  `idClients` int(255) DEFAULT NULL,
  `contenu` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idSupport`),
  KEY `idClients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `video`
--

DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `idOeuvre` int(255) NOT NULL,
  `idRealisateur` int(255) DEFAULT NULL,
  `idActeurs` int(255) DEFAULT NULL,
  `pisteSonore` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `pisteSousTitre` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `video`
--

INSERT INTO `video` (`idOeuvre`, `idRealisateur`, `idActeurs`, `pisteSonore`, `pisteSousTitre`) VALUES
(2, 13, 13, '', ''),
(8, 14, 14, '', ''),
(9, 15, 15, '', '');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `catalogue_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`idAbonnement`) REFERENCES `abonnement` (`idAbonnement`);

--
-- Contraintes pour la table `ecrit`
--
ALTER TABLE `ecrit`
  ADD CONSTRAINT `ecrit` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `favori`
--
ALTER TABLE `favori`
  ADD CONSTRAINT `favori_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`),
  ADD CONSTRAINT `favori_ibfk_3` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClients`);

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `fk_idOeuvre` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `jeuxvideo`
--
ALTER TABLE `jeuxvideo`
  ADD CONSTRAINT `jeuxvideo_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `listedelecture`
--
ALTER TABLE `listedelecture`
  ADD CONSTRAINT `listedelecture_ibfk_1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`),
  ADD CONSTRAINT `listedelecture_ibfk_2` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `musique`
--
ALTER TABLE `musique`
  ADD CONSTRAINT `musique_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClients`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `personne_ibfk_1` FOREIGN KEY (`idArtiste`) REFERENCES `artiste` (`idArtiste`),
  ADD CONSTRAINT `personne_ibfk_2` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`);

--
-- Contraintes pour la table `profil`
--
ALTER TABLE `profil`
  ADD CONSTRAINT `profil_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClients`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);

--
-- Contraintes pour la table `support`
--
ALTER TABLE `support`
  ADD CONSTRAINT `support_ibfk_1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`);

--
-- Contraintes pour la table `video`
--
ALTER TABLE `video`
  ADD CONSTRAINT `video_ibfk_1` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
