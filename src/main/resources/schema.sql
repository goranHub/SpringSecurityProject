SET sql_mode = '';


DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;


CREATE TABLE if not exists user (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(50) COLLATE latin1_german2_ci DEFAULT NULL,
  `password` varchar(50) COLLATE latin1_german2_ci DEFAULT NULL,
  `fname` varchar(50) COLLATE latin1_german2_ci DEFAULT NULL,
  `lname` varchar(50) COLLATE latin1_german2_ci DEFAULT NULL,
  `email` varchar(100) COLLATE latin1_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_login` (`login`),
  UNIQUE KEY `uni_email` (`email`),
  UNIQUE KEY `uni_fname_lname` (`fname`,`lname`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;



CREATE TABLE if not exists role (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(4) unsigned NOT NULL DEFAULT '0',
  `role_admin` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_develop` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_cctld` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_gtld` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_billing` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_registry` tinyint(1) DEFAULT '0',
  `role_purchase_read` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_purchase_write` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_sale_write` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `role_sql` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_user_id` (`user_id`),
  CONSTRAINT `constr_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;



