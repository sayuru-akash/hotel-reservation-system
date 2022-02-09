-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2022 at 08:32 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `resid` int(11) NOT NULL,
  `adults` int(11) NOT NULL,
  `children` int(11) DEFAULT NULL,
  `cidate` varchar(20) NOT NULL,
  `codate` varchar(20) NOT NULL,
  `amount` varchar(10) NOT NULL,
  `ptype` varchar(10) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`resid`, `adults`, `children`, `cidate`, `codate`, `amount`, `ptype`, `uid`) VALUES
(1, 2, 0, '2022-01-27', '2022-01-28', '1000', 'OFFLINE', 1),
(2, 5, 0, '2022-01-13', '2022-01-15', '2000', 'OFFLINE', 1),
(3, 4, 0, '2022-01-20', '2022-01-31', '2200', 'OFFLINE', 1),
(4, 1, 2, '2022-01-20', '2022-01-28', '1100', 'OFFLINE', 1),
(6, 1, 1, '2022-01-19', '2022-01-21', '825', 'OFFLINE', 4),
(7, 1, 1, '2022-01-29', '2022-01-30', '825', 'OFFLINE', 1),
(8, 1, 1, '2022-01-21', '2022-01-26', '825', 'ONLINE', 1),
(9, 1, 1, '2022-02-07', '2022-02-08', '825', 'OFFLINE', 4),
(10, 1, 1, '2022-02-07', '2022-02-08', '825', 'OFFLINE', 4),
(11, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(12, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(13, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(14, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(15, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(16, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(17, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(18, 2, 0, '2022-02-11', '2022-02-12', '1100', 'OFFLINE', 1),
(19, 3, 1, '2022-02-08', '2022-02-09', '1925', 'OFFLINE', 1),
(20, 3, 1, '2022-02-08', '2022-02-09', '1925', 'OFFLINE', 1),
(21, 3, 1, '2022-02-08', '2022-02-09', '1925', 'OFFLINE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `adults` int(11) NOT NULL,
  `children` int(11) NOT NULL,
  `cidate` varchar(20) NOT NULL,
  `codate` varchar(20) NOT NULL,
  `total` int(11) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `adults`, `children`, `cidate`, `codate`, `total`, `uid`) VALUES
(1, 2, 1, '2022-01-10', '2022-01-26', 1375, 1),
(2, 2, 1, '2022-01-10', '2022-01-26', 1375, 1),
(3, 1, 1, '2022-01-19', '2022-01-21', 825, 4),
(4, 1, 1, '2022-01-29', '2022-01-30', 825, 1),
(5, 1, 1, '2022-01-29', '2022-01-30', 825, 1),
(6, 1, 1, '2022-01-21', '2022-01-26', 825, 1),
(7, 7, 1, '2022-01-14', '2022-01-27', 4125, 1),
(8, 7, 1, '2022-01-14', '2022-01-27', 4125, 1),
(9, 1, 0, '2022-02-09', '2022-02-10', 550, 1),
(10, 1, 0, '2022-01-30', '2022-02-02', 550, 1),
(11, 1, 1, '2022-02-07', '2022-02-08', 825, 4),
(12, 2, 0, '2022-02-11', '2022-02-12', 1100, 1),
(13, 3, 1, '2022-02-08', '2022-02-09', 1925, 1);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `mid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`mid`, `name`, `email`, `message`) VALUES
(1, 'Sayuru Akash', 'sayuru555@gmail.com', 'dsf'),
(2, 'sdfg', 'ds@sd.vf', 'earews'),
(3, 'sdfrs', 'ef@Gr.vo', 'ewter'),
(4, 'dfhgfd', 'ert@fesaf', 'efwerregergerger'),
(5, 'regergre', 'regerre@fesfgv', 'rgerg'),
(6, 'normie', 'fae@fdaw', 'rgehgterhtyrhjythjnytghbtrgbtfbgtrhbytrhbtyr'),
(7, 'regreg', 'fsdfe@fv', 'sdgdfgfd@fsg'),
(8, 'rsgre', 'ihjiyt@ukmiu', 'i,mui,muimuilk');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(256) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'customer'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `fname`, `lname`, `mobile`, `email`, `pwd`, `role`) VALUES
(1, 'sfd', 'ref', '234', 'sa@gg.co', 'ab4105973691e4bd96fa55a405700e52', 'customer'),
(2, 'fdg', 'retger', '23435', 'yoo@wa.me', '123456', 'admin'),
(4, 'Sayuru', 'Akash', '+94725479474', 'sayuru555@gmail.com', '1a1dc91c907325c69271ddf0c944bc72', 'customer'),
(7, 'issa', 'pathi', '13200', 'car@car.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'customer'),
(8, 'who', 'ser', '213123', 'admin@example.com', '21232f297a57a5a743894a0e4a801fc3', 'customer'),
(9, 'As', 'Per', '1234244556', 'as@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`resid`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `resid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
