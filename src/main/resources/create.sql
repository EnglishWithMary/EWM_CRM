INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_MANAGER');
INSERT INTO roles (id, role) VALUES (3, 'ROLE_TEACHER');
INSERT INTO roles (id, role) VALUES (4, 'ROLE_STUDENT');

INSERT INTO persons (id, firstname, lastname, middlename,registrationdate)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich', now());

INSERT INTO users (id, login, password,role_id)
VALUES (1, 'admin', '$2a$08$4ozu21fedsIgpyrsIV1DOuGVVNkYyp6/KTLMil0gQdAz1r./qC3ri', 1); -- password-admin

INSERT INTO admins (id, person_id, user_id) VALUES (1, 1, 1);

INSERT INTO pipetypes (id, type) VALUES (1, 'LEAD_PIPE');
INSERT INTO pipetypes (id, type) VALUES (2, 'STUDENT_PIPE');
