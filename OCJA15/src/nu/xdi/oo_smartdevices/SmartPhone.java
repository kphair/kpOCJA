/**
 * @author Kevin Phair
 * Created 5 Aug 2015
 */
package nu.xdi.oo_smartdevices;

/**
 * @author Kevin Phair, Sam Downes
 * Created 5 Aug 2015
 *
 */
public class SmartPhone extends SmartDevice {

	private String phoneNumber;
	
	public SmartPhone (String manufacturer, String model, String phoneNumber) {
		super (manufacturer, model);
		this.phoneNumber = phoneNumber;
	}
	
	public String toString(){
		return super.toString() + " " + this.getPhoneNumber();
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
}
