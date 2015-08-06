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
 * TODO @version 2.0 - Took the ArrayLists out of the classes and moved them into App
 * 
 * @version 1.0 - First iteration
 *
 */
public class SmartApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SmartApp().runApp();
	}
	
	public void runApp(){
	
		ArrayList<SmartDevice> devices = new ArrayList<SmartDevice>();
		
		System.out.println("SmartDevice testing app");
		
		devices.add(new SmartPhone("HTC", "X++", "087231890"));
		devices.add(new SmartPhone("Apple", "iPhone S5", "0861234567"));
		devices.add(new SmartPhone("Samsung", "Galaxy S6", "08688776632"));
		devices.add(new SmartPhone("Huawei", "F6", "08912387765"));
		devices.add(new SmartPhone("Nokia", "Lumia 620", "0862233543"));

		devices.add(new SmartTablet("Samsung", "Galaxy Tab Pro 12.1", "stairmaster"));
		devices.add(new SmartTablet("Apple", "iPad 5", "sausage"));
		devices.add(new SmartTablet("Amazon", "Kindle Fire", "theLibrarian"));
		devices.add(new SmartTablet("Lenovo", "Something", "applesandoranges"));
		devices.add(new SmartTablet("Google", "Nexus 7", ""));
		
		System.out.println("\u001b[33;1mAll Devices\u001b[0m");
		for(SmartDevice d : devices){
			System.out.println("\u001b[37m" + d);
		}
	
	}
}
