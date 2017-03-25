package com.mloftus.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMastermindLogic {
	
	private MastermindLogic mm;

	@Before
	public void setUp() throws Exception {
		mm = new MastermindLogic();
		mm.setCode("1234");
	}
	
	@Test
	public void testConstructor() {
		mm = new MastermindLogic(4);
		assertEquals("code Length", 4, mm.getCode().length());
	}

	@Test
	public void testCodeExists() {
		assertNotNull(mm.getCode());
		assertEquals("1234", mm.getCode());
	}
	
	@Test
	public void testGenerateCode() {
		mm.generateCode(4);
		assertNotNull(mm.getCode());
		assertEquals(4, mm.getCode().length());
	}
	
	@Test
	public void testGuessIsValid() {
		mm = new MastermindLogic(4);
		assertTrue(mm.guessIsValid("9876"));
		assertFalse(mm.guessIsValid("9887"));
		assertFalse(mm.guessIsValid("12345"));
		assertFalse(mm.guessIsValid("12AF"));
	}

	@Test
	public void testGuessMatchesCode() {
		assertTrue(mm.guessMatchesCode("1234"));
	}

	@Test
	public void testGuessMatchesCodeForWin() {
		assertTrue(mm.guessMatchesCode("1234"));
		assertFalse(mm.guessMatchesCode("4321"));
	}

	@Test
	public void testGuessDoesntMatchesCode() {
		assertFalse(mm.guessMatchesCode("1324"));
	}

	@Test
	public void testFirstDigitMatch() {
		assertFalse(mm.guessMatchesCode("1567"));
		assertTrue(mm.getDigitMatches() == 1);
		assertTrue(mm.getLocationMatches() == 1);
	}
	
	@Test
	public void testDigitMatchWrongLocation() {
		assertFalse(mm.guessMatchesCode("5617"));
		assertTrue(mm.getDigitMatches() == 1);
		assertTrue(mm.getLocationMatches() == 0);
	}
	
	@Test
	public void testTwoDigitsMatchWrongLocation() {
		assertFalse(mm.guessMatchesCode("5612"));
		assertTrue(mm.getDigitMatches() == 2);
		assertTrue(mm.getLocationMatches() == 0);
	}

	@Test
	public void testThreeDigitsMatch1WrongLocation() {
		assertFalse(mm.guessMatchesCode("1732"));
		assertTrue(mm.getDigitMatches() == 3);
		assertTrue(mm.getLocationMatches() == 2);
	}
	
}
