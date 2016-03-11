package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Cross extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_Cross()
	{
		addSequential(new shooterRetract_Prep());				//prep shooter retracter
    	addParallel(new intake_ActivateMotors());  			//activate intake and run parallel as it does not finish...
    	addSequential(new shooterArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 50029, 8.0));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intake_DoNothing());  	
	}
}
