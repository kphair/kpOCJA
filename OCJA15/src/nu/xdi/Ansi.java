package nu.xdi;

/**
 * An ANSI code utilisation class to provide screen positioning and text colour 
 * functions for console apps
 * 
 * @author Kevin Phair
 * @date 11 Aug 2015
 */
public class Ansi {
	
	// Persistent storage for foreground, background, brightness, x and y
	static int fg = 7, bg = 0, br = 0, x = 0, y = 0;

	public static void clrscr () {
		
		System.out.print ("\u001b[2J");
	}
	
	public static void locate (int x, int y) {
		Ansi.x = x;
		Ansi.y = y;
		
		System.out.print ("\u001b[" + y + "," + x + "H");
	}
	
	public static void locate (int x) {
		Ansi.x = x;
		
		System.out.print ("\u001b[" + y + "," + x + "H");
	}

	public static void setBr (int br) {
		Ansi.br = br % 2;
		
		System.out.print ("\u001b[" + br + "m");
	}
	public static void setColor (int fg, int bg) {
		Ansi.fg = fg % 8;
		Ansi.bg = bg % 8;
		
		System.out.print ("\u001b[" + br + ";" + (30 + fg) + ";" + (40 + bg) + "m");
	}
	
	public static void setFg (int fg) {
		Ansi.fg = fg % 8;
		
		System.out.print ("\u001b[" + br + ";" + (30 + fg) + "m");
	}

	public static void setBg (int bg) {
		Ansi.bg = bg % 8;
		
		System.out.print ("\u001b[" + br + ";" + (40 + bg) + "m");
	}

}
