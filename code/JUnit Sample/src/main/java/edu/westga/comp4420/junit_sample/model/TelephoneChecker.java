package edu.westga.comp4420.junit_sample.model;

public class TelephoneChecker {
	
	/** Verifies that the provided number is a valid phone number.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number is a valid phone number
	 * 			false	if number is not a valid phone number
	 */
	public boolean verifyNumber(long number) {
		return number >= 1000000000L && number <= 9999999999L;
    }
	
	/** Identifies if a provided phone number is potential spam based on the area code.
	 * The following area codes should be reported as potential spam:
	 * 	999
	 * 	900
	 * 	888
	 * 	800
	 * 	911
	 * 	411
	 * 
	 * @precondition number if a valid phone number
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number matches heuristics for potential spam
	 * 			false	if number does not match heuristics for potential spam
	 */
	public boolean identifySpam(long number) {
		if (!this.verifyNumber(number)) {
			throw new IllegalArgumentException("This phone number, (" + number + ") is invalid.");
		}
		
		int areaCode = (int) (number / 10000000);
		
		int[] spamCodes = {999, 900, 888, 800, 411, 911};
		
		for (int spamCode : spamCodes) {
			if (areaCode == spamCode) {
				return true;
			}
	    }
	    return false;
    }
}
