package com.babytoy.model;


public class MusicalToy extends Toy {
	private int noOfSpeakers;

	public MusicalToy() {
		// TODO Auto-generated constructor stub
	}


	public MusicalToy(int noOfSpeakers) {
		super();
		this.noOfSpeakers = noOfSpeakers;
	}
	public int getNoOfSpeakers() {
		return noOfSpeakers;
	}
	public void setNoOfSpeakers(int noOfSpeakers) {
		this.noOfSpeakers = noOfSpeakers;
	}
	
	@Override
	public String toString() {
		return "MusicalToy [noOfSpeakers=" + noOfSpeakers + "]";
	}

}
