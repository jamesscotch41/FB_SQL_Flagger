package com.test;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;

public class SQLExecuteFlagger extends OpcodeStackDetector {

	private BugReporter bugReporter;
	
	public SQLExecuteFlagger(BugReporter bugReporter) {
		this.bugReporter = bugReporter;
	}
	
	@Override
	public void sawOpcode(int arg0) {
		if(arg0 == INVOKESPECIAL) {
			if(getClassConstantOperand().equals("java/sql/statement")) {
				if(getNameConstantOperand().equals("execute") || getNameConstantOperand().equals("executeUpdate") || getNameConstantOperand().equals("executeQuery")) {
					this.bugReporter.reportBug(new BugInstance(this, "TUTORIAL_BUG", EXP_PRIORITY).addClassAndMethod(this).addString(getNameConstantOperand()).addSourceLine(this));
					
				}
			}
		}
		
	}

}
