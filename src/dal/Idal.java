package dal;

import java.util.ArrayList;

import to.PersonTO;

public interface Idal {
	public PersonTO getPerson(int cnic);
	public ArrayList<PersonTO> getCitizenByName(String name);
	//we are making the interface to make the understanding between the two layers more concrete 
	//these are the doors through the interface
	//through this, the layers can talk together. 
	//now, the business layer will use the interface of DAo, not its concrete object 
	//now their relationship will be stronger 
	public PersonTO getCitizenByTheName(String name);
	
	

}
