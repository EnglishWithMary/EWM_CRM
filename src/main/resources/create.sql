INSERT INTO `testT`.`users` (`id`, `login`, `password`)
VALUES (1, 'admin', '$2a$06$YeJAyGXCJ7PY.T9s/8/HR.Rc1kTFt650YTfrjxMB7gKKuf5x984k2');

INSERT INTO `testT`.`users` (`id`, `login`, `password`)
VALUES (2, 'test', '$2a$08$u6VTYyKloEz4/n1Y37wuh.dUGjmJdGq2lVYPhkbz8bi/cyfqbocYG');

INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (2, 'ROLE_MANAGER');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (3, 'ROLE_TEACHER');
INSERT INTO `testT`.`roles` (`id`, `role`) VALUES (4, 'ROLE_USER');

INSERT INTO `testT`.`users_roles`(user_id, role_id) VALUES (1,1);

INSERT INTO `testT`.`users_roles`(user_id, role_id) VALUES (2,1);

UPDATE `testT`.`users`
SET
  `email` = "testspringmail@mailinator.com",
  `isFirstLogin` = "true",
  `password` = "$2a$06$YeJAyGXCJ7PY.T9s/8/HR.Rc1kTFt650YTfrjxMB7gKKuf5x984k2"
WHERE `id` = 1;


SELECT * FROM roles;

SELECT * FROM users;