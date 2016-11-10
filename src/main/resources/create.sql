INSERT INTO `testT`.`users` (`id`, `login`, `password`, `role_id`)
VALUES (1, 'admin', '$2a$08$xdNhDsWedNPK/X/ywDJZTOLNf5jrZkhnA0Un6oT908o7AddkG9aMC', 1);

INSERT INTO `testT`.`users` (`id`, `login`, `password`, `role_id`)
VALUES (2, 'test', '$2a$08$u6VTYyKloEz4/n1Y37wuh.dUGjmJdGq2lVYPhkbz8bi/cyfqbocYG', 1);

INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (2, 'ROLE_MANAGER');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (3, 'ROLE_TEACHER');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (4, 'ROLE_STUDENT');