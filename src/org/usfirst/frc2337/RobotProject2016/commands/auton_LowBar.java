package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_LowBar extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_LowBar()
	{
		addParallel(new shooterRetract_Prep());				//prep shooter retracter
    	addParallel(new intake_ActivateMotors());  			//activate intake and run parallel as it does not finish..
    	addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 2.0));  //22029		//TODO   NEED TO SET DISTANCE 
    	//addParallel(new shooterArm_armSetPointAutonBase());   //  Change back to Travel
    	addSequential(new shooterArm_armSetPointBase());   //  Change back to Travel
    	addParallel(new shooterArm_armSetPointAutonBase());   //  Change back to Travel
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -60000, 8.0));  //22029		//TODO   NEED TO SET DISTANCE 
		// change back to 0.7
		addSequential(new intake_DoNothing());  	
	}
}
