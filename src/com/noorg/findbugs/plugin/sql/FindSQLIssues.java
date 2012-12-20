/*
 * FB_SQL_Flagger
 * Copyright (C) 2012, James Scotch
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.noorg.findbugs.plugin.sql;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;

public class FindSQLIssues extends OpcodeStackDetector {

	private BugReporter bugReporter;
	
	public FindSQLIssues(BugReporter bugReporter) {
		this.bugReporter = bugReporter;
	}
	
	@Override
	public void sawOpcode(int arg0) {
		if(arg0 == INVOKEINTERFACE) {
			if(getClassConstantOperand().equals("java/sql/Statement")) {
				if(getNameConstantOperand().equals("execute") || getNameConstantOperand().equals("executeUpdate") || getNameConstantOperand().equals("executeQuery")) {
					bugReporter.reportBug(new BugInstance(this, "SQL_UNPREPARED_STATEMENT", NORMAL_PRIORITY).addClassAndMethod(this).addSourceLine(this));	
				}
			}
		}
		
	}

}
