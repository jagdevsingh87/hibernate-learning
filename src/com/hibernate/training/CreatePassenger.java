package com.hibernate.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePassenger {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Passenger.class);
		SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Passenger passenger = new Passenger("Jagdev","Singh","jagdev@singh.com");
		try {
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
