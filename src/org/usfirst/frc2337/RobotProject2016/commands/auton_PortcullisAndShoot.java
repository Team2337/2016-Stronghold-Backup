package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_PortcullisAndShoot extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_PortcullisAndShoot()
	{

    	addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 2.0));
    	addSequential(new intakeArm_armSetPointGround());   
    	addParallel(new intakeArm_armSetPointAutonGround());   //  Keep Arm down through the motion  
		addSequential(new Auton_GyroAndEncoderDrive(0.4, -50000, 8.0));  
		
		addSequential(new chassis_TargetWithGyroPID());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, -12000, 8.0));
		addSequential(new chassis_TargetWithGyroPID());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, -12000, 8.0));
		addSequential(new linAccElevator_Extend());
		addSequential(new auton_Wait(1.0));
		//addSequential(new shooter_ShootCG());
	}
}
