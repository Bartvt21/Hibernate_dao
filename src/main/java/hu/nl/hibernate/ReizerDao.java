package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ReizerDao {
	
	public List<Reiziger> findall() throws SQLException, ParseException; 
	public boolean saveReiziger(Reiziger reiziger) throws SQLException, ParseException;
	public boolean update(Reiziger reiziger) throws SQLException, ParseException;
	public boolean delete(Reiziger reiziger) throws SQLException, ParseException;
	public boolean execute(Reiziger reiziger, String executeMethod) throws SQLException, ParseException;;
}
