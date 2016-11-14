package model;

//not needed
@SuppressWarnings("serial")


public class SailBoat extends Boat {

	public SailBoat(String length, String ID){
		this.setType("SailBoat");
		this.setLength(length);
		this.setID(ID);
	}
}
