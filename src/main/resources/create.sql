INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_MANAGER');
INSERT INTO roles (id, role) VALUES (3, 'ROLE_TEACHER');
INSERT INTO roles (id, role) VALUES (4, 'ROLE_STUDENT');

INSERT INTO states (id, state) VALUES (1, 'STATE_ACTIVE');
INSERT INTO states (id, state) VALUES (2, 'STATE_TRASHED');
INSERT INTO states (id, state) VALUES (3, 'STATE_DELETED');

INSERT INTO persons (id, firstname, lastname, middlename,registrationdate, state_id)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich', now(), 1);
UPDATE persons SET state_id=1 WHERE state_id IS NULL ;

INSERT INTO users (id, login, password,role_id)
VALUES (1, 'admin', '$2a$08$4ozu21fedsIgpyrsIV1DOuGVVNkYyp6/KTLMil0gQdAz1r./qC3ri', 1); -- password-admin

INSERT INTO admins (id, person_id, user_id) VALUES (1, 1, 1);

INSERT INTO pipetypes (id, type) VALUES (1, 'LEAD_PIPE');
INSERT INTO pipetypes (id, type) VALUES (2, 'STUDENT_PIPE');

