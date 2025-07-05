import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HQLJPQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // JPQL Query - SELECT
            List<Student> students = session.createQuery("FROM Student WHERE marks > 80", Student.class).getResultList();
            students.forEach(s -> System.out.println(s.getName()));

            // HQL Query - UPDATE
            int updated = session.createQuery("UPDATE Student SET marks = 100 WHERE name = 'John'").executeUpdate();
            System.out.println("Rows updated: " + updated);

            // HQL Query - DELETE
            int deleted = session.createQuery("DELETE FROM Student WHERE marks < 50").executeUpdate();
            System.out.println("Rows deleted: " + deleted);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
