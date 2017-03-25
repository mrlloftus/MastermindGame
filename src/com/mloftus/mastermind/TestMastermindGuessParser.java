package com.mloftus.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMastermindGuessParser {
	
	private MastermindGuessValidator parser;
	
	@Before
	public void setUp() throws Exception {
		parser = new MastermindGuessValidator(4);
	}
	
	@Test
	public void testGuessIsValid() {
		assertTrue(parser.guessIsValid("1234"));
	}
	
	@Test
	public void testGuessNotValidBecauseNotNumeric(){
		assertFalse(parser.guessIsValid("123A"));
	}

	@Test
	public void testGuessNotValidBecauseRepeatDigits(){
		assertFalse(parser.guessIsValid("1232"));
	}

	@Test
	public void testGuessNotValidBecauseWrongLength(){
		parser = new MastermindGuessValidator(5);
		assertFalse(parser.guessIsValid("1234"));
		assertFalse(parser.guessIsValid("123456"));
	}

}
