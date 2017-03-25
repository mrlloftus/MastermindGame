package com.mloftus.mastermind;

public class MastermindGuessValidator {
	
	private int codeLength;

	public MastermindGuessValidator(int codeLength) {
		this.codeLength = codeLength;
	}

	public boolean guessIsValid(String guess) {
		return lengthIsCorrect(guess, codeLength) && isNumeric(guess) && hasNoRepeatDigits(guess);
	}

	private boolean lengthIsCorrect(String guess, int codeLength) {
		return guess.length() == codeLength;
	}

	private boolean isNumeric(String guess) {
		char[] guessChars = guess.toCharArray();
		for(char digitChar : guessChars){
			try {
				Integer.parseInt(String.valueOf(digitChar));
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	private boolean hasNoRepeatDigits(String guess) {
		char[] charsInGuess = guess.toCharArray();
		char[] checkedChars = new char[guess.length()];
		for (int i=0;i<charsInGuess.length;i++){
			for (char checked : checkedChars) {
				if (checked == charsInGuess[i])
					return false;
			}
			checkedChars[i] = charsInGuess[i];
		}
		return true;
	}

}
