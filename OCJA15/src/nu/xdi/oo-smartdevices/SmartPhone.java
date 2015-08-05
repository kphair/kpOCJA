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
public class SmartPhone extends SmartDevice {

	private String phoneNumber;
	static ArrayList<SmartPhone> phones = new ArrayList<SmartPhone>();
	
	public SmartPhone (String manufacturer, String model, String phoneNumber) {
		super (manufacturer, model);
		this.phoneNumber = phoneNumber;
		phones.add(this);
	}
	
	public String toString(){
		return super.toString() + " " + this.getPhoneNumber();
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public ArrayList<SmartPhone> getList(){
		return SmartPhone.phones;
	}

}
