INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_MANAGER');
INSERT INTO roles (id, role) VALUES (3, 'ROLE_TEACHER');
INSERT INTO roles (id, role) VALUES (4, 'ROLE_STUDENT');

INSERT INTO languages (id, language) VALUES (1, 'English');
INSERT INTO languages (id, language) VALUES (2, 'Spanish');
INSERT INTO languages (id, language) VALUES (3, 'Polish');
INSERT INTO languages (id, language) VALUES (4, 'German');
INSERT INTO languages (id, language) VALUES (5, 'Italian');
INSERT INTO languages (id, language) VALUES (6, 'French');
INSERT INTO languages (id, language) VALUES (7, 'Chinese');
INSERT INTO languages (id, language) VALUES (8, 'Japanese');

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

-- full text props
DROP TABLE if EXISTS searched_person;
CREATE TEXT SEARCH DICTIONARY ispell_ru (
template  =   ispell,
  dictfile  =   ru,
  afffile   =   ru,
  stopwords =   russian
);

CREATE TEXT SEARCH DICTIONARY ispell_en (
template  =   ispell,
  dictfile  =   "en",
  afffile   =   "en",
  stopwords =   english
);

CREATE TEXT SEARCH CONFIGURATION ru ( COPY = russian );
CREATE TEXT SEARCH CONFIGURATION en ( COPY = english );

ALTER TEXT SEARCH CONFIGURATION ru
ALTER MAPPING
FOR word, hword, hword_part
WITH ispell_ru, russian_stem;

ALTER TEXT SEARCH CONFIGURATION ru
ALTER MAPPING
FOR asciiword, asciihword, hword_asciipart
WITH ispell_en, english_stem;

SET default_text_search_config = 'en';

CREATE OR REPLACE VIEW staffview AS
SELECT persons.*, groups.name as group_name, users.login as login, roles.role as role,
admins.id as admin_id,
managers.id as manager_id,
teachers.id as teacher_id,
students.id as student_id,
leads.id as lead_id,
setweight( coalesce( to_tsvector('en', persons.firstname),''),'A') || ' ' ||
setweight( coalesce( to_tsvector('en', persons.lastname),''),'B') || ' ' ||
setweight( coalesce( to_tsvector('en', groups.name),''),'C') as searchtext
FROM persons
  LEFT JOIN admins ON persons.id = admins.person_id
  LEFT JOIN teachers ON persons.id = teachers.person_id
  LEFT JOIN managers ON persons.id = managers.person_id
  LEFT JOIN students ON persons.id = students.person_id
  LEFT JOIN leads ON persons.id = leads.person_id
  LEFT JOIN groups ON students.group_id = groups.id
  LEFT JOIN users ON admins.user_id = users.id or managers.user_id = users.id or teachers.user_id = users.id or students.user_id = users.id
  LEFT JOIN roles ON users.role_id = roles.id;