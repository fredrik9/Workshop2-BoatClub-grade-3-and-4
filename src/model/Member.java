package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Comparable<Member>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String memberID;
	private String personalNumber;
	private String numberOfBoats;
	 
	ArrayList<Boat> boatList;
	
	// method for getting the number of boats that the member has registered
	 public String getNumberOfBoats() {
		return numberOfBoats;
	}
	
	// method that sets number of boats equal to parameter
	public void setNumberOfBoats(String numberOfBoats) {
		this.numberOfBoats = numberOfBoats;
	}

	/* method for creating a new member, must have input parameters which correspond to the variable names.
	 * Method will be called in admin when the program is ran, it will populate the member array in admin with the information
	 * read from the text files that contain all the members and their information
	 */
	public Member(String name,String ID, String personalNumber, String numberOfBoats){
		 
		this.name = name;
		this.memberID = ID;
		this.personalNumber = personalNumber;
		this.numberOfBoats = numberOfBoats;

		boatList = new ArrayList<Boat>();

	}

	/*
	 * method which adds a boat to the member's boatlist(array which contains
	 * that user's boats), will assign an ID that is not in use to the newly
	 * added boat
	 */
	public void addBoat(Boat boat, String length) {

		boat.setLength(length);
		if (boatList.size() != 0) {
			boat.setID(Integer.toString(Integer.parseInt(boatList.get(boatList.size() - 1).getID()) + 1));
		} else {

			boat.setID("1");
		}
		boatList.add(boat);
		numberOfBoats = Integer.toString(boatList.size());

	}

	public String getName() {
		return name;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public ArrayList<Boat> getBoatList() {
		return boatList;
	}

	@Override
	public int compareTo(Member member) {
		if (!(member instanceof Member)){
			throw new IllegalArgumentException("Not a type of the class Member");
		}
		
		return Integer.valueOf(this.getMemberID()).compareTo(Integer.valueOf(member.getMemberID()));
	}
	 
}
