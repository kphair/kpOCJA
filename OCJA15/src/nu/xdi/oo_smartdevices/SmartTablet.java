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
public class SmartTablet extends SmartDevice{

	private String wifiPassword = "";

	public SmartTablet(String manufacturer, String model, String wifiPassword){
		super(manufacturer, model);
		this.wifiPassword = wifiPassword;
	}

	public String toString(){
		return super.toString() + " " + this.getWifiPassword();
	}

	public String getWifiPassword() {
		return wifiPassword;
	}
	
}
