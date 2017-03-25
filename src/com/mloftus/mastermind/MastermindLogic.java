package com.mloftus.mastermind;

import java.util.*;

public class MastermindLogic {

	private List<Integer> code;
	private List<Integer> guess;
	private MastermindGuessValidator guessValidator;
	
	public MastermindLogic() {
		
	}
	
	public MastermindLogic(Integer codeLength) {
		generateCode(codeLength);
		guessValidator = new MastermindGuessValidator(codeLength);
	}

	public void generateCode(int codeLength) {
		this.code = new ArrayList<Integer>(codeLength);
		while (this.code.size() < codeLength){
			Random random = new Random();
			int randomNumber = random.nextInt(9 - 1) + 1;
			if (! this.code.contains(randomNumber)) {
				this.code.add(randomNumber);
			}
		}
	}

	public void setCode(String code) {
		this.code = convertStringToArrayList(code);
	}

	public boolean guessIsValid(String guess) {
		return guessValidator.guessIsValid(guess);
	}

	public boolean guessMatchesCode(String myGuess) {
		this.guess = convertStringToArrayList(myGuess);
		return (getDigitMatches() == code.size() && getLocationMatches() == code.size());
	}

	private List<Integer> convertStringToArrayList(String inString) {
		List<Integer> result = new ArrayList<Integer>(inString.length());
		for (int i=0;i<inString.length();i++){
			result.add(Integer.parseInt(inString.substring(i, i+1)));
		}
		return result;
	}
	
	public String getCode() {
		return String.format("%s%s%s%s", code.toArray());
	}

	public int getDigitMatches() {
		int matches = 0;
		for (Integer codeDigit : code) {
			for (Integer guessDigit : guess) {
				if (codeDigit == guessDigit)
					matches++;
			}
		}
		return matches;
	}

	public int getLocationMatches() {
		int matches = 0;
		for (int i=0;i<code.size();i++) {
			if(guess.get(i) == code.get(i))
				matches++;
		}
		return matches;
	}

}
