package myhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmployeeTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Employee> result = session.createQuery( "from EMPLOYEE" ).list();
		for ( Employee emp : (List<Employee>) result ) {
		    System.out.println( "emp"+emp.getEmpId());
		}
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}

}
