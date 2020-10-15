package com.babytoy.model;


public class ElectronicToy extends Toy {
	private int numberOfBatteries;
	private String operatingMode;

	public ElectronicToy() {
		// TODO Auto-generated constructor stub
	}
	public ElectronicToy(int numberOfBatteries, String operatingMode) {
		super();
		this.numberOfBatteries = numberOfBatteries;
		this.operatingMode = operatingMode;
	}

	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}

	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}

	public String getOperatingMode() {
		return operatingMode;
	}

	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}

	

	@Override
	public String toString() {
		return "ElectronicToy [numberOfBatteries=" + numberOfBatteries + ", operatingMode=" + operatingMode + "]";
	}
}
