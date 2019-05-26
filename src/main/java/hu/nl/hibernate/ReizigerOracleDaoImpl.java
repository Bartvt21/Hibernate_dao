package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizerDao {
	

	public boolean saveReiziger(Reiziger reiziger) throws SQLException, ParseException {
		
		boolean saved = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
		
			session.save(reiziger);
			t.commit();
			saved = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return saved;
	}

	public boolean update(Reiziger reiziger) throws SQLException, ParseException {
		
		boolean updated = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
		
			session.update(reiziger);
			t.commit();
			updated = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return updated;
	}

	public boolean delete(Reiziger reiziger) throws SQLException, ParseException {
		
		boolean deleted = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
	
			
			OV_ChipkaartOracleDaoImpl ovodi = new OV_ChipkaartOracleDaoImpl();
			
			for(OV_Chipkaart kaart : ovodi.findall()) {
				if(kaart.getReizigerId() == reiziger.getReizigerid()) {
					
					ovodi.deleteKaart(kaart);
				}
			}
			
			session.delete(reiziger);
			t.commit();
			deleted = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return deleted;
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
}
