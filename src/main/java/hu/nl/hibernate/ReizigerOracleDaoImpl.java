package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizerDao {
	

	public boolean saveReiziger(Reiziger reiziger) throws SQLException, ParseException {
		
		return execute(reiziger, "save");
	}

	public boolean update(Reiziger reiziger) throws SQLException, ParseException {
		
		return execute(reiziger, "update");
	}

	public boolean delete(Reiziger reiziger) throws SQLException, ParseException {
		
		try {
		
			OV_ChipkaartOracleDaoImpl ovodi = new OV_ChipkaartOracleDaoImpl();
			
			for(OV_Chipkaart kaart : ovodi.findall()) {
				if(kaart.getReizigerId() == reiziger.getReizigerid()) {
					ovodi.deleteKaart(kaart);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return execute(reiziger, "delete");
		
	}

	public List<Reiziger> findall() throws SQLException, ParseException {
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		OV_ChipkaartOracleDaoImpl ovodi = new OV_ChipkaartOracleDaoImpl();
		
		List<Reiziger> allReiziger = session.createQuery("SELECT a FROM Reiziger a", Reiziger.class).getResultList();      
		

		for(OV_Chipkaart kaart : ovodi.findall()) {
			for(Reiziger r : allReiziger) {
				if(r.getReizigerid() == kaart.getReizigerId()) {
					r.setKaart(kaart);
				}

			}
		}
	
		return allReiziger;
	}
	
	
	public boolean execute(Reiziger reiziger, String executeMethod) throws SQLException, ParseException {
		
		boolean executed = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
			
			if(executeMethod.equals("save")) {
				session.save(reiziger);
			} else if(executeMethod.equals("update")) {
				session.update(reiziger);
			} else if(executeMethod.equals("delete")) {
				session.delete(reiziger);
			}
		
			t.commit();
			executed = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return executed;
	}
	
}
