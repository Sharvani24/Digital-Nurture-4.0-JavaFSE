package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Save new student
            Student s = new Student();
            s.setName("Alice");
            s.setAge(21);
            session.save(s);

            // Fetch all students
            List<Student> list = session.createQuery("from Student").list();
            for (Student stu : list) {
                System.out.println(stu.getId() + ": " + stu.getName());
            }

            // Get student by ID
            Student retrieved = session.get(Student.class, s.getId());
            System.out.println("Retrieved: " + retrieved.getName());

            // Delete student
            session.delete(retrieved);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
