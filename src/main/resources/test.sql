DROP VIEW personnel;
CREATE VIEW personnel AS
SELECT users.login, roles.role, persons.* FROM (
SELECT admins.person_id AS person, admins.user_id AS usr FROM admins
UNION SELECT managers.person_id AS person, managers.user_id AS usr FROM managers
UNION SELECT teachers.person_id AS person, teachers.user_id AS usr FROM teachers
) AS keys
LEFT JOIN persons ON keys.person = persons.id
LEFT JOIN users ON keys.usr = users.id
LEFT JOIN roles ON users.role_id = roles.id;