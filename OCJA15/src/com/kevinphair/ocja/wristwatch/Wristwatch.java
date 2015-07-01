/*
 * Define the Wristwatch class
 * 
 * v1.0 - Kevin Phair
 * 
 */

package com.kevinphair.ocja.wristwatch;

public class Wristwatch {
	
	private String maker;
	private String model;
	private boolean analogue;
	private boolean digital;
	public enum BatteryTypes { BUTTON, COIN }
	private BatteryTypes batteryType;
	private int batteryLevel;
	private int hours;
	private int minutes;
	private int seconds;
	public enum AttachmentTypes { BAND, CHAIN, NONE }
	private AttachmentTypes attachmentType;
	public enum FaceTypes { STANDARD, SCREEN, PROJECTOR }
	private FaceTypes faceType;


	/* getters and setters for maker String */
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/* getters and setters for Model String */
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	/* getters and setters for analogue flag */
	public boolean isAnalogue() {
		return analogue;
	}
	public void setAnalogue(boolean analogue) {
		this.analogue = analogue;
	}
	/* getters and setters for digital flag */
	public boolean isDigital() {
		return digital;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}
	/* getters and setters for batteryType*/
	public BatteryTypes getBatteryType() {
		return batteryType;
	}
	public void setBatteryType(BatteryTypes batteryType) {
		this.batteryType = batteryType;
	}
	/* getters and setters for batteryLevel*/
	public int getBatteryLevel() {
		return batteryLevel;
	}
	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	/* getters and setters for hours */
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	/* getters and setters for minutes */
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	/* getters and setters for seconds */
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/* getters and setters for the attachmentType*/
	public AttachmentTypes getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(AttachmentTypes attachmentType) {
		this.attachmentType = attachmentType;
	}

	/* getters and setters for the faceType*/
	public FaceTypes getFaceType() {
		return faceType;
	}
	public void setFaceType(FaceTypes faceType) {
		this.faceType = faceType;
	}
	
	/* Returns a simple HH:MM:SS reading of the time */
	public String getDigitalTime() {
		return hours + ":" + minutes + ":" + seconds;
	}
	/* Returns a descriptive reading of the time */
	public String getAnalogueTime() {
		String verboseHours;
		String verboseMinutes;
		String verboseSeconds;
		String AMPM;
		int tempHours;
		
		if (minutes > 30) {
			verboseMinutes = 60 - minutes + " minutes";
			if (seconds > 0) {
				verboseSeconds = " and " + (60 - seconds) + " seconds to";
			} else {
				verboseSeconds = " to";
			}
			/* advance to the next hour when saying "minutes to" */
			tempHours = (hours + 1) % 24;
		} else if (minutes > 0) {
			verboseMinutes = minutes + " minutes";
			/* if the seconds are 0 then don't give them */
			if (seconds > 0) {
				verboseSeconds = " and " + seconds + " seconds past";
			} else {
				verboseSeconds = " past";
			}
			tempHours = hours;
		} else {
			/* if the minutes are 0 then don't give them */
			verboseMinutes = "";
			if (seconds > 0) {
				verboseSeconds = seconds + " seconds past";
			} else {
				verboseSeconds = "";
			}
			tempHours = hours;
		}

		if (tempHours >= 12) {
			AMPM = "PM";
		} else {
			AMPM = "AM";
		}
		tempHours %= 12;
		if (tempHours == 0) tempHours = 12;
		verboseHours = tempHours + "";
		
		return verboseMinutes + verboseSeconds + " " 
				+ verboseHours; 
	}
}
	