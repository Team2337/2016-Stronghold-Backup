package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Chevy extends CommandGroup {


	public auton_Chevy()
	{
    	addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 4.0, -5));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intakeArm_armSetPointGround());
		//addParallel(new intakeArm_armSetPointAutonGround());
		//addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.8, 4.0, -15));
		addSequential(new Auton_GyroAndEncoderDrive(0.6, -30000, 1.0));
		addParallel(new intakeArm_armSetPointLoad());
		addSequential(new Auton_GyroAndEncoderDrive(0.6, -50000, 8.0));
		//addSequential(new chassis_TargetWithGyroPID());
		//addSequential(new Auton_GyroAndEncoderDrive(0.8, -12000, 8.0));
		
	}
}
