package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OV_ChipkaartOracleDaoImpl extends OracleBaseDao implements OV_ChipkaartDao {
	

	public boolean saveKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		boolean saved = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
		
			session.save(kaart);
			t.commit();
			saved = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return saved;
	}

	public boolean updateKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		boolean updated = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
		
			session.update(kaart);
			t.commit();
			updated = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return updated;
	}

	public boolean deleteKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		boolean deleted = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
		
			session.delete(kaart);
			t.commit();
			deleted = true;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		factory.close();
		session.close();
		
		return deleted;
	}

	public List<OV_Chipkaart> findall() throws SQLException, ParseException {
		
		
		OracleBaseDao.getConnection();
		Session session = factory.openSession();
		
		List<OV_Chipkaart> allKaarten = session.createQuery("select o from OV_Chipkaart o", OV_Chipkaart.class).getResultList();  
		
		return allKaarten;
	}

}
