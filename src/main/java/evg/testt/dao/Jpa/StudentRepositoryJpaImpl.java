package evg.testt.dao.Jpa;

import evg.testt.model.Student;
import evg.testt.dao.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryJpaImpl extends RegisteredUserRepositoryJpaImpl<Student> implements StudentRepository {


    @Override
    public List<Student> findStudensByTeacher(int teacher_id) {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student WHERE student.teacher.id = :id AND student.person.state = 'ACTIVE'", Student.class);

        query.setParameter("id", teacher_id);

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsWithoutTeacher() {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.teacher.id is null AND student.person.state = 'ACTIVE'", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsByGroup(int group_id) {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.group.id = :id AND student.person.state = 'ACTIVE'", Student.class);
        query.setParameter("id", group_id);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsWithoutGroup() {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.group.id is null AND student.person.state = 'ACTIVE'", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsWithGroup() throws SQLException {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.group is not null AND student.person.state = 'ACTIVE'", Student.class);
        return query.getResultList();

    }


    @Override
    public List<Student> findStudentsPageWithFilters(int pageNumber, Integer teacher_id,
                                                     List<Integer> groupIdList, String direction) throws SQLException {
        String hQLQuery= "SELECT student FROM students student JOIN student.person p WHERE "
                + conditionsForStudents(teacher_id,groupIdList);
        if(direction!=null) hQLQuery += "ORDER BY p.registrationDate " + direction;
        TypedQuery<Student> query=em.createQuery(hQLQuery,Student.class);
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int countByFilter(Integer teacher_id, List<Integer> groupIdList) throws SQLException {
        long total = 0;
        String hQLQuery= "SELECT COUNT(student) FROM students student JOIN student.person p WHERE "
                + conditionsForStudents(teacher_id,groupIdList);
        Query query = em.createQuery(hQLQuery);
        total = (long) query.getSingleResult();
        return (int) total;
    }

    private String conditionsForStudents(Integer teacher_id, List<Integer> groupIdList){
        String hQLQuery = "";
        if (teacher_id != null) {
            if (teacher_id == -1) {
                hQLQuery += "student.teacher.id is null and ";
            } else if (teacher_id > 0) {
                hQLQuery += "student.teacher.id = " + teacher_id  + " AND ";//
            }
        }
        if (groupIdList!=null && groupIdList.size()>0) {
            if (groupIdList.contains(-1)) hQLQuery += "student.group IS NULL ";
            if (groupIdList.contains(0)) hQLQuery+= "student.group IS NOT NULL ";
            else{
                hQLQuery +="student.group.id IN (";
                for (int i = 0; i < groupIdList.size(); i++)  {
                    if (groupIdList.get(i) > 0)
                        hQLQuery += groupIdList.get(i) + (i<groupIdList.size()-1 ? ", " : ")  AND ");
                }
            }
        }
        hQLQuery += "p.state = 'ACTIVE' ";
        return hQLQuery;
    }
}
