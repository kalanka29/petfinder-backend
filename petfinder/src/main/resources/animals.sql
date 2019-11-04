-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 04, 2019 at 12:28 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pet_finder`
--

-- --------------------------------------------------------

--
-- Table structure for table `animals`
--

CREATE TABLE `animals` (
  `id` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `breed` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `color` varchar(10) NOT NULL,
  `image` varchar(200) NOT NULL,
  `location` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `size` varchar(10) NOT NULL,
  `behaviour` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`id`, `type`, `breed`, `age`, `gender`, `color`, `image`, `location`, `name`, `size`, `behaviour`) VALUES
(1, 'cat', 'torbie', 'baby', 'male', 'brown', 'https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262__340.jpg', 'baththaramulla', 'tiki', 'medium', 'house-trained'),
(2, 'cat', 'torbie', 'young', 'female', 'brown', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfyf6dDOTmwBVlzeUjxL6kIJqV_61Xj_aqyeeNPcvyY6H5NJYH&s', 'pettah', 'kiti', 'medium', 'house-trained'),
(3, 'dog', 'german-shepard', 'adult', 'female', 'brown', 'https://cdn.pixabay.com/photo/2018/08/03/14/42/german-3582038__340.jpg', 'pettah', 'tuky', 'medium', 'house-trained'),
(4, 'cat', 'tabby', 'young', 'male', 'brown', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfyf6dDOTmwBVlzeUjxL6kIJqV_61Xj_aqyeeNPcvyY6H5NJYH&s', 'nugegoda', 'puss', 'small', 'special-needs'),
(5, 'cat', 'tabby', 'senior', 'male', 'black', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfyf6dDOTmwBVlzeUjxL6kIJqV_61Xj_aqyeeNPcvyY6H5NJYH&s', 'Kirulapana', 'kd', 'large', 'special-needs'),
(6, 'dog', 'husky', 'baby', 'male', 'brown', 'https://cdn.pixabay.com/photo/2018/05/07/10/48/husky-3380548__340.jpg', 'Kotte', 'jimmy', 'small', 'special-needs');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animals`
--
ALTER TABLE `animals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
