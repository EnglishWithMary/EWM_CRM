To run project:

 - Install Maven 3 or higher

 - Install Tomcat 8

 - Install mySQL

 - Create mySql database

 - Check out project from github

 - Change properties connection to databases

 - Start project from idea in debug mode

 - Update Dependencies in Maven

 - execute mysql scripts from 'create.sql'

 INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
 INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (2, 'ROLE_MANAGER');
 INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (3, 'ROLE_TEACHER');
 INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (4, 'ROLE_STUDENT');

 INSERT INTO `testT`.`persons` (`id`, `firstName`, `lastName`, `middleName`)
 VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich');

 INSERT INTO `testT`.`users` (`id`, `login`, `password`,`role_id`)
 VALUES (1, 'admin', '$2a$04$8aP2T1T4Otu6NVNoYc.kkODExjy8MCUYLVf8cO2NTqnwoVC/FC166', 1); -- admin