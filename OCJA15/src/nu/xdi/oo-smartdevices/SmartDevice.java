/**
 * @author Kevin Phair
 * Created 5 Aug 2015
 */
package nu.xdi.oo_smartdevices;

import java.util.ArrayList;

/**
 * @author Kevin Phair, Sam Downes
 * Created 5 Aug 2015
 *
 */
public abstract class SmartDevice {

	private String manufacturer;
	private String model;
	static ArrayList<SmartDevice> devices = new ArrayList<SmartDevice>();
	
	public SmartDevice (String manufacturer, String model) {
		this.manufacturer = manufacturer;
		this.model = model;
		devices.add(this);
	}
	
	public String toString(){
		return this.getManufacturer() + " " + this.getModel();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}
	
	public ArrayList<SmartDevice> getDeviceList(){
		return SmartDevice.devices;
	}

}
