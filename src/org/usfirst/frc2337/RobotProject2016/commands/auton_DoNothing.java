package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_DoNothing extends CommandGroup {

	public auton_DoNothing()
	{
		addSequential(new auton_Wait(15));  	
	}
}
