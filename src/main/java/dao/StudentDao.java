package dao;

import entites.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Student student) {
        return (int) hibernateTemplate.save(student);
    }

    @Transactional
    public void remove(int id) {
        Student student = fetch(id);
        hibernateTemplate.delete(student);
    }

    @Transactional
    public void update(Student student) {
        hibernateTemplate.update(student);
    }

    public Student fetch(int id) {
        return hibernateTemplate.get(Student.class, id);
    }

    public List<Student> fetchAll() {
        return hibernateTemplate.loadAll(Student.class);
    }
}
