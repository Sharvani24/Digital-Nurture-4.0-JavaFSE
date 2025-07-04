package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        HibernateExample HE = new HibernateExample();
        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setSalary(50000);
        HE.addEmployee(emp);
    }

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }
}
