package com.mloftus.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.ConfigurationException;

public class MastermindGame {

	private Integer codeLength = 4;
	private Integer maxGuesses = 10;
	private MastermindLogic game;
	private Integer numberOfGuesses = 0;
	
	public MastermindGame(int codeLength) {
		this.codeLength = codeLength;
	}

	public void play() throws ConfigurationException {

		configureGame();
		
		MastermindMessages.printWelcomeMessage(codeLength, maxGuesses);
		
		while (someGuessesRemain()) {
			askForNextGuess();
			String guess = getGuess();
			if (guessNotValid(guess)) {
				MastermindMessages.printGuessHelpStatement(codeLength);
				continue;
			}
			numberOfGuesses++;
			if (isWinningGuess(guess)) {
				MastermindMessages.printWinningStatement(numberOfGuesses, game.getCode());
				break;
			} else {
				MastermindMessages.printGuessResultStatement(game.getDigitMatches(), game.getLocationMatches());
			}

		}
		if (ranOutOfGuesses()) {
			MastermindMessages.printGameOverStatement(game.getCode());
		}

	}

	private void configureGame() throws ConfigurationException {
		if (codeLength < 3 || codeLength > 6) {
			throw new ConfigurationException("Code length not valid.");
		}
		if (codeLength > 4) {
			maxGuesses = 15;
		}
		game = new MastermindLogic(codeLength);
	}
	
	private boolean someGuessesRemain() {
		return numberOfGuesses  < maxGuesses;
	}

	private void askForNextGuess() {
		System.out.print(String.format("Your guess? (%s left):", (maxGuesses - numberOfGuesses)));
	}

	private String getGuess() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String guess = null;
		try {
			guess = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return guess;
	}
	
	private boolean guessNotValid(String guess) {
		return ! game.guessIsValid(guess);
	}

	private boolean isWinningGuess(String guess) {
		return game.guessMatchesCode(guess);
	}

	private boolean ranOutOfGuesses() {
		return ! someGuessesRemain();
	}

	public static void printUsageMessage() {
		MastermindMessages.printUsageMessage();
	}

}
