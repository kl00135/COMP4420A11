package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	
	@Test
	void testValidSpamNumbers() {
		TelephoneChecker checker = new TelephoneChecker();
		
		assertTrue(checker.identifySpam(9990000000L), "Expected 999 to be spam. spam alert.");
		assertTrue(checker.identifySpam(9000000000L), "Expected 900 to be spam. spam alert.");
		assertTrue(checker.identifySpam(8880000000L), "Expected 888 to be spam. spam alert.");
		assertTrue(checker.identifySpam(8000000000L), "Expected 800 to be spam. spam alert.");
		assertTrue(checker.identifySpam(9110000000L), "Expected 911 to be spam. spam alert.");
		assertTrue(checker.identifySpam(4110000000L), "Expected 411 to be spam. spam alert.");
	}
	
	
	@Test
	void testValidRegularNumber(){
		TelephoneChecker checker = new TelephoneChecker();
		
		assertFalse(checker.identifySpam(4045762092L), "Expected this number to be free of spam.");
	}
	
	@Test
	void testInvalidPhoneNumber(){
		TelephoneChecker checker = new TelephoneChecker();
		
		assertThrows(IllegalArgumentException.class, () -> checker.identifySpam(100000000000000L), "Expected a very long number to be invalid.");


}
}