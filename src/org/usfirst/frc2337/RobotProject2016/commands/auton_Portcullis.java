package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Portcullis extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_Portcullis()
	{
    	//addParallel(new intake_Inhale());  			//activate intake and run parallel as it does not finish..
    	addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 2.0));  //22029		//TODO   NEED TO SET DISTANCE 

    	addSequential(new intakeArm_armSetPointGround());   //  Drive Arm to Base
    	addParallel(new intakeArm_armSetPointAutonGround());   //  Keep Arm down through the motion  
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -50000, 8.0));  //22029		//Drive Forward
		//addSequential(new intake_DoNothing());  	
	}
}
