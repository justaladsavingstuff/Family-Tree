/**
* This program makes up a mini application that simply
* performs a few operations on the database
*
* @author  Aaimaa Mohsin
* @version 1.0
* @since   2023-2-3
*/

package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.PersonTO;

public class PersonDAO implements Idal { //the dependency of PersonDAO glass is with connection object, without that, it cannot do any of its tasks.
	//similarly, the dependency of BO is on DAO, so BO must have an object of DAO. 
	private Connection con;
	
	public PersonDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/22fallfinal?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
	}
	public PersonDAO(Connection con) {
		this.con = con;
	}
	
	//once we have these functions in our interface, we'll write override here. 
	@Override
	public PersonTO getPerson(int cnic) {
		PersonTO person = new PersonTO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `citizen` WHERE `cnic` = ?");
			ps.setInt(1, cnic);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				person.setCnic(rs.getInt("cnic"));
				person.setName(rs.getString("name"));
				person.setFather(rs.getInt("father"));
				person.setMother(rs.getInt("mother"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
	public PersonTO getCitizenByTheName(String name)
	{
		PersonTO person = new PersonTO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `citizen` WHERE `name` = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				person.setCnic(rs.getInt("cnic"));
				person.setName(rs.getString("name"));
				person.setFather(rs.getInt("father"));
				person.setMother(rs.getInt("mother"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person; 
	}
	
	@Override
	public ArrayList<PersonTO> getCitizenByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
