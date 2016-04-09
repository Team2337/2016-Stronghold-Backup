package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Reach extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_Reach()
	{
		//addSequential(new shooterRetract_Prep());				//prep shooter retracter
    	addParallel(new intake_Inhale());  			//activate intake and run parallel as it does not finish...
    	addSequential(new intakeArm_armSetPointTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, 16029, 4.0));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intake_DoNothing());  	
	}
}
