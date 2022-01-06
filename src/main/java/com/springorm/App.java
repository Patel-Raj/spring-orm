package com.springorm;

import dao.StudentDao;
import entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        while(ok) {
            System.out.println("1 => Insert");
            System.out.println("2 => Update");
            System.out.println("3 => Delete");
            System.out.println("4 => Search");
            System.out.println("5 => Search All");
            System.out.println("6 => Exit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    insertStudent(studentDao, sc);
                    break;
                case "2":
                    updateStudent(studentDao, sc);
                    break;
                case "3":
                    deleteStudent(studentDao, sc);
                    break;
                case "4":
                    searchStudent(studentDao, sc);
                    break;
                case "5":
                    System.out.println(studentDao.fetchAll());
                    break;
                case "6":
                    ok = false;
                    break;
            }
        }
    }

    private static void insertStudent(StudentDao studentDao, Scanner sc) {
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        System.out.println("Enter Name:");
        String name = sc.next();
        System.out.println("Enter City:");
        String city = sc.next();
        Student student = new Student(id, name, city);
        studentDao.insert(student);
    }

    private static void updateStudent(StudentDao studentDao, Scanner sc) {
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        System.out.println("Enter Name:");
        String name = sc.next();
        System.out.println("Enter City:");
        String city = sc.next();
        Student student = new Student(id, name, city);
        studentDao.update(student);
    }

    private static void deleteStudent(StudentDao studentDao, Scanner sc) {
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        studentDao.remove(id);
    }

    private static void searchStudent(StudentDao studentDao, Scanner sc) {
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        Student student = studentDao.fetch(id);
        System.out.println(student);
    }
}
