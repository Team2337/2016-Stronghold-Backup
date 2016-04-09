package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_ReverseReach extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_ReverseReach()
	{
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 2.0)); 
		addParallel(new intakeArm_armSetPointTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -11029, 3.0));
	}
}
