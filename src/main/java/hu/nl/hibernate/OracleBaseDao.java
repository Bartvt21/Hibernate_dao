package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleBaseDao {
	
	 static SessionFactory factory;
	
	  static void getConnection() throws SQLException, ParseException {
	      try {
	        factory = new Configuration().configure().buildSessionFactory();
	        System.out.println("connection");
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        System.out.println("Error");
	        throw new ExceptionInInitializerError(ex);
	      }
	  }
}
