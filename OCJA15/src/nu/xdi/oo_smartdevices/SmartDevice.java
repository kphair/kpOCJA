/**
 * @author Kevin Phair
 * Created 5 Aug 2015
 */
package nu.xdi.oo_smartdevices;

/**
 * @author Kevin Phair, Sam Downes
 * Created 5 Aug 2015
 * @version 2.0 - Removed ArrayList.
 */
public abstract class SmartDevice {

	private String manufacturer;
	private String model;
	
	protected SmartDevice (String manufacturer, String model) {
		this.manufacturer = manufacturer;
		this.model = model;
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
	
}
