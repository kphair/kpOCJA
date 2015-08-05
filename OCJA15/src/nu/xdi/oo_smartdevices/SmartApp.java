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
public class SmartApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SmartApp().runApp();
	}
	
	public void runApp(){
		
		System.out.println("SmartDevice testing app");
		
		SmartPhone phone1 = new SmartPhone("HTC", "X++", "087231890");
		SmartPhone phone2 = new SmartPhone("Apple", "iPhone S5", "0861234567");
		SmartPhone phone3 = new SmartPhone("Samsung", "Galaxy S6", "08688776632");
		SmartPhone phone4 = new SmartPhone("Huawei", "F6", "08912387765");
		SmartPhone phone5 = new SmartPhone("Nokia", "Lumia 620", "0862233543");

		System.out.println("\u001b[36;1mPhone list\u001b[0m");
		for(SmartPhone p : phone1.getList()){
			System.out.println(p);
		}

		SmartTablet tablet1 = new SmartTablet("Samsung", "Galaxy Tab Pro 12.1", "stairmaster");
		SmartTablet tablet2 = new SmartTablet("Apple", "iPad 5", "sausage");
		SmartTablet tablet3 = new SmartTablet("Amazon", "Kindle Fire", "theLibrarian");
		SmartTablet tablet4 = new SmartTablet("Lenovo", "Something", "applesandoranges");
		SmartTablet tablet5 = new SmartTablet("Google", "Nexus 7", "");
		
		System.out.println("\u001b[36;1mTablet list\u001b[0m");
		for(SmartTablet t : tablet1.getList()){
			System.out.println(t);
		}

		System.out.println("\u001b[33;1mAll Devices\u001b[0m");
		for(SmartDevice d : tablet1.getDeviceList()){
			System.out.println("\u001b[37m" + d);
		}

	
	}
}
