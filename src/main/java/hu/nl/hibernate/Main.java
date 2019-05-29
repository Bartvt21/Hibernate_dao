package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;


public class Main {
	
  public static void main(String[] args) throws SQLException, ParseException {
	  
	  ReizigerOracleDaoImpl rodi = new ReizigerOracleDaoImpl();
	  OV_ChipkaartOracleDaoImpl ovodi = new OV_ChipkaartOracleDaoImpl();
     
      Reiziger reiziger = new Reiziger(2, "Klaas", "van", "test", "2019-05-23");
      OV_Chipkaart ov1 = new OV_Chipkaart(90909, "2019-05-23", 1, 96, reiziger.getReizigerid());
      OV_Chipkaart ov2 = new OV_Chipkaart(90905, "2019-05-23", 1, 86, reiziger.getReizigerid());
      
      Reiziger reiziger2 = new Reiziger(3, "test", "van", "Tongeren", "2019-05-23");
      OV_Chipkaart ov3 = new OV_Chipkaart(90910, "2019-05-23", 2, 46, reiziger.getReizigerid());
      OV_Chipkaart ov4 = new OV_Chipkaart(90911, "2019-05-23", 1, 36, reiziger2.getReizigerid());
      
  
       
      System.out.println(rodi.update(reiziger2));    
      
  }
}
