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
	static int fg, bg, br, x, y;

	public void clrscr () {
		
		System.out.print ("\u001b[2J");
	}
	
	public void locate (int x, int y) {
		Ansi.x = x;
		Ansi.y = y;
		
		System.out.print ("\u001b[" + y + "," + x + "H");
	}
	
	public void locate (int x) {
		Ansi.x = x;
		
		System.out.print ("\u001b[" + y + "," + x + "H");
	}

	public void setBr (int br) {
		Ansi.br = br;
		
		System.out.println("\u001b[" + br + "m");
	}
	public void setColor (int fg, int bg) {
		Ansi.fg = fg;
		Ansi.bg = bg;
		
		System.out.print ("\u001b[" + br + ";" + 30 + fg * 8 + ";" + 40 + bg % 8 + "m");
	}
	
	public void setFg (int fg) {
		Ansi.fg = fg;
		
		System.out.print ("\u001b[" + br + ";" + 30 + fg % 8 + "m");
	}

	public void setBg (int bg) {
		Ansi.bg = bg;
		
		System.out.print ("\u001b[" + br + ";" + 40 + bg % 8 + "m");
	}

}
