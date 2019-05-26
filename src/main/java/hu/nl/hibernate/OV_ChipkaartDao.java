package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface OV_ChipkaartDao {
	
	public List<OV_Chipkaart> findall() throws SQLException, ParseException; 
	public boolean saveKaart(OV_Chipkaart kaart) throws SQLException, ParseException;
	public boolean updateKaart(OV_Chipkaart kaart) throws SQLException, ParseException;
	public boolean deleteKaart(OV_Chipkaart kaart) throws SQLException, ParseException;
	

}
