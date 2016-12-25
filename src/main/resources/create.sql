INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_MANAGER');
INSERT INTO roles (id, role) VALUES (3, 'ROLE_TEACHER');
INSERT INTO roles (id, role) VALUES (4, 'ROLE_STUDENT');

INSERT INTO persons (id, firstname, lastname, organization,modifydate,registrationdate,comments,state)
VALUES (1, 'Dmitry', 'Serebryakov', 'EWM', now(), now(), 'Administrator', 'ACTIVE');

INSERT INTO users (id, login, password,role_id)
VALUES (1, 'admin', '$2a$08$4ozu21fedsIgpyrsIV1DOuGVVNkYyp6/KTLMil0gQdAz1r./qC3ri', 1); -- password-admin

INSERT INTO admins (id, person_id, user_id) VALUES (1, 1, 1);

UPDATE persons SET state='STATE_ACTIVE' WHERE state IS NULL;

INSERT INTO pipetypes (id, type) VALUES (1, 'LEAD_PIPE');
INSERT INTO pipetypes (id, type) VALUES (2, 'STUDENT_PIPE');

INSERT INTO cards (id, cardName, type_id) VALUES (1, 'Default lead pipe',1);
INSERT INTO cards (id, cardName, type_id) VALUES (2, 'Default student pipe',2);

CREATE OR REPLACE VIEW staffview AS SELECT persons.* FROM persons LEFT JOIN admins ON persons.id = admins.person_id
  LEFT JOIN managers ON persons.id = managers.person_id LEFT JOIN students ON persons.id = students.person_id
  LEFT JOIN leads ON persons.id = leads.person_id;

DROP TABLE if EXISTS personnel;
DROP VIEW if EXISTS personnel;
CREATE VIEW personnel AS
SELECT users.login, roles.role, persons.* FROM (
SELECT admins.person_id AS person, admins.user_id AS usr FROM admins
UNION SELECT managers.person_id AS person, managers.user_id AS usr FROM managers
UNION SELECT teachers.person_id AS person, teachers.user_id AS usr FROM teachers
) AS keys
LEFT JOIN persons ON keys.person = persons.id
LEFT JOIN users ON keys.usr = users.id
LEFT JOIN roles ON users.role_id = roles.id;