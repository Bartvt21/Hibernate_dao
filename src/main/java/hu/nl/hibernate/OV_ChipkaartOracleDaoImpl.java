package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OV_ChipkaartOracleDaoImpl extends OracleBaseDao implements OV_ChipkaartDao {
	

	public boolean saveKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		return execute(kaart, "save");
	}

	public boolean updateKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		return execute(kaart, "update");
	}

	public boolean deleteKaart(OV_Chipkaart kaart) throws SQLException, ParseException {
		
		return execute(kaart, "delete");
	}

	public List<OV_Chipkaart> findall() throws SQLException, ParseException {
		
		
		OracleBaseDao.getConnection();
		Session session = factory.openSession();
		
		List<OV_Chipkaart> allKaarten = session.createQuery("select o from OV_Chipkaart o", OV_Chipkaart.class).getResultList();  
		
		return allKaarten;
	}
	
	public boolean execute(OV_Chipkaart kaart, String executeMethod) throws SQLException, ParseException {
		
		boolean executed = false;
		
		OracleBaseDao.getConnection();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
			
			if(executeMethod.equals("save")) {
				session.save(kaart);
			} else if(executeMethod.equals("update")) {
				session.update(kaart);
			} else if(executeMethod.equals("delete")) {
				session.delete(kaart);
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
