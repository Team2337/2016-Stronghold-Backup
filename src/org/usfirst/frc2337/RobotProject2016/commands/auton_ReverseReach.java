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
		addParallel(new shooterArm_armSetPointTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -16029, 3.0));
	}
}
