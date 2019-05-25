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

      Reiziger reiziger = new Reiziger(1, "Bert", "van", "Tongeren", "2019-05-23");
      OV_Chipkaart ov = new OV_Chipkaart(909001, "2019-05-23", 1, 56, reiziger.getReizigerid());
      ov.setReiziger(reiziger);
      
      reiziger.saveOvChipkaart(ov);
      
      session.save(ov);
      session.save(reiziger);

     
      t.commit();  
      System.out.println("successfully saved");    
      factory.close();  
      session.close();   
  }
}
