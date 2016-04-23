package org.usfirst.frc2337.RobotProject2016;


import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class auton_MainCGCMP extends  CommandGroup {

	public auton_MainCGCMP(int delay, int position, String defense, int shot) {
		
		if (delay == 5) {
			addSequential(new auton_Wait(5.0));
		} else if (delay == 8) {
			addSequential(new auton_Wait(8.0));
		}
		
		
		
		if (defense == "nothing") {
			addSequential(new auton_Wait(15));
		} else if (defense == "reach") {
			addParallel(new intakeArm_armSetPointAutonTravel());
			addSequential(new Auton_GyroAndEncoderDrive(0.3, -16029, 4.0));  //22029	
			
		} else if (defense == "cross") {
			addParallel(new intakeArm_armSetPointAutonTravel());
			addSequential(new Auton_GyroAndEncoderDrive(0.7, -55029, 8.0));  // -65029  ?? if you change this change the return
			
			if (shot == 3) {
				addSequential(new auton_Wait(1));
				addSequential(new Auton_GyroAndEncoderDrive(0.7, 48000, 8.0));
				addSequential(new auton_Wait(1));
				addSequential(new auton_TurnPID(150));     
			}
			
		} else if (defense == "chevy") {
			addParallel(new intakeArm_armSetPointAutonTravel());
			addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 4.0, -5));  	 
			addSequential(new intakeArm_armSetPointGround());
			addSequential(new Auton_GyroAndEncoderDrive(0.6, -30000, 1.0));
			addParallel(new intakeArm_armSetPointLoad());
			addSequential(new Auton_GyroAndEncoderDrive(0.6, -40000, 8.0));
			
		} else if (defense == "port") {
	    	addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 2.0)); 
	    	addSequential(new intakeArm_armSetPointGround());   //  Drive Arm to Base
	    	addParallel(new intakeArm_armSetPointAutonGround());   //  Keep Arm down through the motion  
			addSequential(new Auton_GyroAndEncoderDrive(0.6, -50000, 8.0));  //22029		//Drive Forward 	
			addSequential(new intakeArm_armSetPointLowGoal()); 
		}
		
		if (shot == 0)	{  // Stop
			//Yeah doing nothing here....
		} else if (shot == 1) {  // Drop
			addSequential(new intakeArm_armSetPointLowGoal());
			addSequential(new auton_intake_Exhale());
		} else if (shot == 2) {  // Roll  of course...  Or Shoot High
			if (position == 2) {
				addSequential(new Auton_GyroAndEncoderDriveTillUltrasonic(.6, 6.0, 22, -5));
				addSequential(new auton_TurnPID(90));
				addSequential(new intakeArm_armSetPointLowGoal());
				addSequential(new linAccElevator_Extend());
				addSequential(new chassis_TargetWithGyroPID());  ///update with incline command
				addSequential(new shooter_ShootCG());
			} else if ((position == 3) || (position == 4)) {
				
				
				addSequential(new chassis_TargetWithGyroPID());
				addSequential(new Auton_GyroAndEncoderDriveTillUltrasonic(.6, 6.0, 60, -5));
				addSequential(new chassis_TargetWithGyroPID());
				addSequential(new intakeArm_armSetPointLowGoal());
				addSequential(new linAccElevator_Extend());
				addSequential(new auton_Wait(1.0)); 
				addSequential(new shooter_ShootCG());
				
			} else if (position == 5) {
				
				addSequential(new Auton_GyroAndEncoderDriveTillUltrasonic(.6, 6.0, 50, -5));
				addSequential(new auton_TurnPID(-60));
				addSequential(new chassis_TargetWithGyroPID());
				addSequential(new intakeArm_armSetPointLowGoal());
				addSequential(new linAccElevator_Extend());
				addSequential(new auton_Wait(1.0)); 
				addSequential(new shooter_ShootCG());
				
				
			}
			
		}
		
		


		
	}
}
