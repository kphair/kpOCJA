/**
 * TrimFileApp 
 * a file i/o test app for trimming whitespace from a file 
 * 
 * @author kevin
 */

package com.kevinphair.ocja.experiments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TrimFileApp {

	public static void main (String[] args) {
        int errorLevel = 0;
        PrintWriter outFile = null;
        BufferedReader inFile = null;
        String inLine = null;
        
        // scan command line for switches
        if (args.length == 0) {
            System.out.println("No input file supplied.");
            errorLevel = 10;
        } else {
            System.out.println("Using " + args[0] + " for input");
        
	        // open file for input
	        try {
	            FileReader fr = new FileReader(args[0]);
	            inFile = new BufferedReader(fr);
	            //inString = inFileP.
	        } catch (IOException e) {
	        	e.printStackTrace();
	        	errorLevel = 50;
	        }
	        
	        // open temp file for output
	        if (inFile != null) {
		        try {
		             File file = new File("trimmed-" + args[0]);
		             FileWriter fw = new FileWriter(file, false);
		             outFile = new PrintWriter(fw);
		             System.out.println("Created 'trimed-" + args[0] + "' for output.");
	            	 while (true) {
	            		 inLine = inFile.readLine();
	            		 if (inLine == null) break;
			             outFile.println(inLine.trim());
	            	 }
	            	 
		        } catch (IOException e) {
		             e.printStackTrace();
		             errorLevel = 50;
		        } finally {
		             if (outFile != null) {
		                  outFile.close();
		             }
		        }
	        }
        }
        System.exit (errorLevel);
    }
    
    public static int getOpts (String cmdline) {
        System.out.println(cmdline);
        return 0;
    }
}
