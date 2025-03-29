package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestVerifyNumber {

	@ParameterizedTest
	@ValueSource(longs = {999999L, 123456L, 9999999L}) 
	void testInvalidNumbers(long number) {
		TelephoneChecker checker = new TelephoneChecker();
		assertFalse(checker.verifyNumber(number), "checking if number was reported as valid");
	}

	@ParameterizedTest
	@ValueSource(longs = {4045762092L, 2125551234L})
	void testValidNumbers(long number) {
		TelephoneChecker checker = new TelephoneChecker();
		assertTrue(checker.verifyNumber(number), "Expected a valid 10-digit number");
	}

	@ParameterizedTest
	@ValueSource(longs = {10000000000L, 99999999999L})
	void testTooLongNumbers(long number) {
		TelephoneChecker checker = new TelephoneChecker();
		assertFalse(checker.verifyNumber(number), "Expected number too long to be valid");
	}

}
