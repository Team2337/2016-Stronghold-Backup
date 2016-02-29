package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_MoveStart2ToGoal1 extends CommandGroup {

	/**
	 * MOVE TO GOAL #1
	 * --------------
	 * 
	 * 
	 */
	public auton_MoveStart2ToGoal1()
	{
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1800, 2.0)); // Move to LEFT Goal		//TODO SET DISTANCE
     	addSequential(new auton_TurnPID(50)); //Turn 50 Degree angle							//TODO  TEST & SET ANGLE
     	
     	
     	//TARGET WITH GRIP/VISION
     	//addSequential(new chassis_TargetWithGyroPID()); //turn towards goal
     
	}
}
