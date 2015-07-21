/**
 * CheckDigits is a class for checking and generating check digits for strings
 */
package com.kevinphair.experiments;

/**
 * @author Kevin Phair
 *
 */
public class CheckDigits {

	/**
	 * checkPPSN - Validate PPSN numbers
	 * 
	 * Check digits range from A to W
	 * A class can also be appended (W,T or X) which is independent of the check digit
	 * 
	 * @param PPSN - entire PPSN including check digit and the optional class code
	 */
	public void checkPPSN(String PPSN) {

		/* Original C code from payroll project

		    char chk_char, chk_orig = *(rsi + 7);
		    int  chksum = 0, chkpos;
	
		    if (strlen(rsi) < 8) return(0);
	
		    for (chkpos = 0; chkpos < 7; chkpos++) { 
		    	chksum += (*(rsi + 6 - chkpos) - 48) * (chkpos + 2);
			}
			
		    chk_char = 64 + chksum % 23;
		    if (chk_char == 64) chk_char = 64 + 23;
		    if (chk_char == chk_orig) return(1); else return(0);
		 */
	}
	
	/**
	 * checkMod11R - Validate modulus 11R (An Post payment accounts)
	 * 
	 * @param String digits
	 */
	public void checkMod11R(String mod11R) {
		
	}
	
	/**
	 * CheckCC - Validate credit card check digits
	 * @param String cardnum
	 */

}
