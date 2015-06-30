/**
 * Define the LawnMower class
 * 
 * @author Kevin Phair
 *
 */
package com.kevinphair.ocja.lawnmower;

public class LawnMower {

	private boolean powerStatus = false;
	private int numWheels = 4;
	private boolean grassBox = true;
	public enum DriveType { PETROL, ELECTRIC, NONE }
	private DriveType driveType = DriveType.PETROL;
	public enum MotiveType { MANUAL, ROLLER, RIDE_ON }
	private MotiveType motiveType = MotiveType.MANUAL;
	
	public boolean isMowerOn() {
		return this.powerStatus;
	}
	public void powerOn() {
		this.powerStatus = true;
	}
	public void powerOff() {
		this.powerStatus = false;
	}
	
	public int getNumWheels() {
		return this.numWheels;
	}
	public void setNumWheels(int newNumWheels) {
		this.numWheels = newNumWheels;
	}
	
	public DriveType getDriveType() {
		return this.driveType;
	}
	public void setDriveType(DriveType newDriveType) {
		this.driveType = newDriveType;
	}
	
	public MotiveType getMotiveType() {
		return this.motiveType;
	}
	public void setMotiveType(MotiveType newMotiveType) {
		this.motiveType = newMotiveType;
	}
	
	
}
