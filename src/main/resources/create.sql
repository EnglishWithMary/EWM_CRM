USE ewm;

INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (2, 'ROLE_MANAGER');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (3, 'ROLE_TEACHER');
INSERT INTO `ewm`.`roles` (`id`, `role`) VALUES (4, 'ROLE_STUDENT');

INSERT INTO `ewm`.`states` (`id`, `state`) VALUES (1, 'STATE_ACTIVE');
INSERT INTO `ewm`.`states` (`id`, `state`) VALUES (2, 'STATE_HIDDEN');
INSERT INTO `ewm`.`states` (`id`, `state`) VALUES (3, 'STATE_TRASHED');
INSERT INTO `ewm`.`states` (`id`, `state`) VALUES (4, 'STATE_DELETED');

INSERT INTO `ewm`.`persons` (`id`, `firstName`, `lastName`, `middleName`, `state_id`)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich', 1);
UPDATE `ewm`.`persons` SET state_id=1 WHERE state_id IS NULL ;

INSERT INTO `ewm`.`users` (`id`, `login`, `password`,`role_id`)
VALUES (1, 'admin', '$2a$04$8aP2T1T4Otu6NVNoYc.kkODExjy8MCUYLVf8cO2NTqnwoVC/FC166', 1); -- password-admin

INSERT INTO `ewm`.`admins` (`id`, `person_id`, `user_id`) VALUES (1, 1, 1);


