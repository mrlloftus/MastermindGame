package com.mloftus.mastermind;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestMastermindGuessParser.class, TestMastermindLogic.class })
public class RunAllMastermindTests {

}
