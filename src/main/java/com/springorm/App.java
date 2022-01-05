package com.springorm;

import dao.StudentDao;
import entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        Student s = new Student(121,"Mohit","Jaipur");
        studentDao.insert(s);
    }
}
