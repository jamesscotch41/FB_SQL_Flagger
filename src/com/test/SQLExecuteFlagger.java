package com.test;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;

public class SQLExecuteFlagger extends OpcodeStackDetector {

	private BugReporter bugReporter;
	
	public SQLExecuteFlagger(BugReporter bugReporter) {
		this.bugReporter = bugReporter;
	}
	
	@Override
	public void sawOpcode(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
