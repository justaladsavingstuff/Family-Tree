package bll;

import java.sql.SQLException;

import dal.Idal;
import dal.PersonDAO;
import to.PersonTO;

public class PersonBO {
	private Idal dao; //this should no longer depend on DAO, should depend on interface now
	
	public PersonBO () throws SQLException {
		dao = new PersonDAO();
	}
	public PersonBO(PersonDAO dao) {
		this.dao = dao;
	}

//	public boolean isSibling (int cnic1, int cnic2) {
//		PersonTO p1 = dao.getPerson(cnic1);
//		PersonTO p2 = dao.getPerson(cnic2);
//		
//		return p1.getFather() == p2.getFather() && p1.getMother() == p2.getMother();
//	}
	
	
//half siblings will either have the same mother and different father
//or they'll have the same father and different mother
	
	public boolean isHalfSibling(Integer cnic1, Integer cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		return ((p1.getMother()== p2.getMother() && p1.getFather()!=p1.getFather()) || (p1.getFather()== p2.getFather() && p1.getMother()!=p2.getMother()));
	
	}
	
	public PersonTO findCitizenByName(String name)
	{
		PersonTO p1 = dao.getCitizenByTheName(name);
		return p1;
	}
	
	
}
