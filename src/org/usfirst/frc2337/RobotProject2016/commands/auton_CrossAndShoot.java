package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_CrossAndShoot extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_CrossAndShoot()
	{
		//addSequential(new shooterRetract_Prep());				//prep shooter retracter
    	addParallel(new intake_Inhale());  			//activate intake and run parallel as it does not finish...
    	addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 65029, 4.0));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intake_DoNothing());  
		addSequential(new chassis_TargetWithGyroPID());
		addSequential(new shooter_ShootCG());  
	}
}
