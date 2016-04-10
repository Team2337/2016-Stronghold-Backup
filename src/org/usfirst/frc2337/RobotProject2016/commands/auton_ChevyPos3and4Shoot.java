package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_ChevyPos3and4Shoot extends CommandGroup {


	public auton_ChevyPos3and4Shoot()
	{
    	addSequential(new intakeArm_armSetPointAutonChevy());
		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 4.0, -6));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intakeArm_armSetPointGround());
		addParallel(new intakeArm_armSetPointAutonGround());
		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 2.0, -30));
		//addSequential(new intakeArm_armSetPointLoad());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, 4000, 8.0));
		addSequential(new chassis_TargetWithGyroPID());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, 12000, 8.0));
		addSequential(new chassis_TargetWithGyroPID());
		addSequential(new Auton_GyroAndEncoderDrive(0.3, 12000, 8.0));
		addSequential(new linAccElevator_Extend());
		addSequential(new auton_Wait(1.0));
		//addSequential(new shooter_ShootCG());
		
	}
}
