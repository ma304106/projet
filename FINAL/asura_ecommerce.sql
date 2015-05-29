-- phpMyAdmin SQL Dump
-- version 4.0.10.6
-- http://www.phpmyadmin.net
--
-- Host: mysql1.alwaysdata.com
-- Generation Time: May 26, 2015 at 08:40 AM
-- Server version: 5.1.66-0+squeeze1
-- PHP Version: 5.3.6-11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `asura_ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `ref` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` int(5) NOT NULL,
  `taille` varchar(2) NOT NULL,
  `qté` int(2) NOT NULL,
  `couleur` varchar(15) NOT NULL,
  `genre` varchar(1) NOT NULL,
  `url` varchar(100) NOT NULL,
  PRIMARY KEY (`ref`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`ref`, `nom`, `prix`, `taille`, `qté`, `couleur`, `genre`, `url`) VALUES
('li100', 'Lorel Ipsum White', 80, '32', 78, 'blanc', 'F', 'images/pic11.jpg'),
('li101', 'Lorel Ipsum Black', 70, '32', 74, 'noir', 'F', 'images/s1.jpg'),
('li102', 'Lorel Ipsum Red', 70, '30', 42, 'rouge', 'F', 'images/pic12.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `pseudo` varchar(25) DEFAULT NULL,
  `adresse` varchar(70) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`nom`, `prenom`, `pseudo`, `adresse`, `ville`, `mail`, `mdp`) VALUES
('Hurlorage', 'Illidan', NULL, '42 chemin maudit', 'Outreterre', 'i.hurlorage@hunt.com', 'yournotready'),
('Proudmoore', 'Jaina', NULL, '12 avenue du dragon', 'Kirin Tor', 'jaina.P@elementary.com', 'frost'),
('Sunstrider', 'Kael''thas', NULL, '34 bloodcastle avenue', 'Kirin Tor', 'kael.Sun@pressrtokill.com', 'friendzoned'),
('Meneni', 'Alexis', NULL, '148 avenue de chez moi', 'Nissa', 'ma@abathurimba.com', 'hola'),
('Windrunner', 'Silvanas', NULL, '4 sentier de broceliande', 'Quel''Thalas', 'S.Wind@possesionop.com', 'notimeforgame');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id_comande` int(15) NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `addrlivraison` varchar(70) NOT NULL,
  `addrfacturation` varchar(70) NOT NULL,
  `villelivraison` varchar(70) NOT NULL,
  `villefacturation` varchar(70) NOT NULL,
  `cplivraison` int(6) NOT NULL,
  `cpfacturation` int(6) NOT NULL,
  `typecarte` varchar(50) NOT NULL,
  PRIMARY KEY (`id_comande`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `panier`
--

CREATE TABLE IF NOT EXISTS `panier` (
  `mail_client` varchar(30) NOT NULL,
  `nom_article` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `id_commande` int(15) DEFAULT NULL,
  KEY `id_client` (`mail_client`),
  KEY `id_commande` (`id_commande`),
  KEY `nom_article` (`nom_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `panier`
--

INSERT INTO `panier` (`mail_client`, `nom_article`, `prix`, `id_commande`) VALUES
('jaina.P', 'Lorel Ipsum Red', 70, NULL),
('ma', 'Lorel Ipsum Red', 70, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `panier_ibfk_2` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_comande`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
