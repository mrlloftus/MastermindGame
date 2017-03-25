package com.mloftus.mastermind;

public class Mastermind {

	private static int codeLength = 4;
	private static MastermindGame game;
	
	public static void main(String[] args) {
		parseArgsForCodeLentgh(args);
		try {
			game = new MastermindGame(codeLength);
			game.play();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			MastermindGame.printUsageMessage();
			System.exit(0);
		}
	}
	
	private static void parseArgsForCodeLentgh(String[] args) {
		if (args.length > 0) {
			try {
				codeLength = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				MastermindGame.printUsageMessage();
				System.exit(0);
			}
		}
	}
		
}
