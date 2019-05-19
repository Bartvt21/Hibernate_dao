package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }
      Session session = factory.openSession();
      Transaction t = session.beginTransaction();

     // Log log = new Log(1,"Hibernate works!");
      Reiziger reiziger = new Reiziger(1, "Bert", "Tongeren");
      
      //session.save(reiziger);
      //session.update(reiziger);
      //session.update(reiziger);
      
      t.commit();  
      System.out.println("successfully saved: " + reiziger.getNaam());    
      factory.close();  
      session.close();   
  }
}
