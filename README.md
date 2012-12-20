FB_SQL_Flagger
==============

FindBugs Plugin, flags potentially unsafe non-prepared SQL statements

Contains a jar to drop into FindBugs, and an Eclipse project to build the jar.


Necessary External Resources
----------------------------

###To Run The Plugin
A working copy of FindBugs
This was last tested against 2.0.2
Copy the FB_SQL_Flagger.jar file into the {FindBugs_root_dir}/plugin directory and start FindBugs

###To Build
There are 3 necessary external jars to build the project.
They are located in the lib directory of the Find_Bugs.
They are named in the .classpath file of this project.
Create a lib directory for this project and put those jars into it.
