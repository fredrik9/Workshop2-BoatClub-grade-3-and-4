package model;

//not needed
@SuppressWarnings("serial")

public class MotorSailor extends Boat {
	
	public MotorSailor(String length, String ID){
		this.setType("MotorSailor");
		this.setLength(length);
		this.setID(ID);
	}
}