package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_DoNothing extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_DoNothing()
	{
		addSequential(new shooterRetract_Prep());				//prep shooter
		addSequential(new auton_Wait(15));  	
	}
}
