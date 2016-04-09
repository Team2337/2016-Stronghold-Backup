package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Chevy extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_Chevy()
	{
		//addSequential(new shooterRetract_Prep());				//prep shooter retracter
    	addParallel(new intake_Inhale());  			//activate intake and run parallel as it does not finish...
    	addSequential(new intakeArm_armSetPointAutonChevy());
		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 4.0, -6));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intakeArm_armSetPointBase());
		addParallel(new intakeArm_armSetPointAutonBase());
		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 2.0, -30));
		addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, 16000, 8.0));
		addSequential(new intake_DoNothing());  	
	}
}
