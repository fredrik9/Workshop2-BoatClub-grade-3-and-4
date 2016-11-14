package model;

//not needed
@SuppressWarnings("serial")

public class Kayak extends Boat {
	
	public Kayak(String length, String ID){
		this.setType("Kayak");
		this.setLength(length);
		this.setID(ID);
	}
}


