package MainClass;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Entity.Course;
import com.Entity.Student;

public class Control {
	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure();
		c.addAnnotatedClass(Student.class);
		c.addAnnotatedClass(Course.class);
		
		SessionFactory sf = c.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Student s1 = new Student();
		s1.setStudent_id(11);
		s1.setStudent_name("Parag");
		
		
		Student s2 = new Student();
		s2.setStudent_id(12);
		s2.setStudent_name("Megha");
		
		Course c1 = new Course();
		c1.setCourse_id(100);
		c1.setCourse_name("Java");
		
		
		Course c2 = new Course();
		c2.setCourse_id(200);
		c2.setCourse_name("Python");
	
		ArrayList list = new ArrayList();
		list.add(s1);
		list.add(s2);
		list.add(c1);
		list.add(c2);

		ss.persist(c1);
		ss.persist(s1);
		ss.persist(c2);
		ss.persist(s2);
		
		System.out.println("Data");
		
		tr.commit();
		ss.close();
		
	}

}
