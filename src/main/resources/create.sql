USE ewmdb;

INSERT INTO ewmdb.roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ewmdb.roles (id, role) VALUES (2, 'ROLE_MANAGER');
INSERT INTO ewmdb.roles (id, role) VALUES (3, 'ROLE_TEACHER');
INSERT INTO ewmdb.roles (id, role) VALUES (4, 'ROLE_STUDENT');

INSERT INTO ewmdb.persons (id, firstName, lastName, middleName,registrationDate)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich', NOW());

INSERT INTO ewmdb.users (id, login, password,role_id)
VALUES (1, 'admin', '$2a$08$4ozu21fedsIgpyrsIV1DOuGVVNkYyp6/KTLMil0gQdAz1r./qC3ri', 1); -- password-admin

INSERT INTO ewmdb.admins (id, person_id, user_id) VALUES (1, 1, 1);


INSERT INTO ewmdb.pipetypes (id, type) VALUES (1, 'LEAD_PIPE');
INSERT INTO ewmdb.pipetypes (id, type) VALUES (2, 'STUDENT_PIPE');
