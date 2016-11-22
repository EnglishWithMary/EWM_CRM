USE ewm;

INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (2, 'ROLE_MANAGER');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (3, 'ROLE_TEACHER');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (4, 'ROLE_STUDENT');

INSERT INTO `ewm`.`persons` (`id`, `firstName`, `lastName`, `middleName`)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich');

INSERT INTO `ewm`.`users` (`id`, `login`, `password`,`role_id`)
VALUES (1, 'admin', '$2a$04$8aP2T1T4Otu6NVNoYc.kkODExjy8MCUYLVf8cO2NTqnwoVC/FC166', 1); -- password-admin

INSERT INTO `ewm`.`admins` (`id`, `person_id`, `user_id`) VALUES (1, 1, 1);