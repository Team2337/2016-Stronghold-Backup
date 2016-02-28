package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_MoveStart4ToGoal2 extends CommandGroup {

	/**
	 * MOVE TO GOAL #2
	 * --------------
	 * 
	 * 
	 */
	public auton_MoveStart4ToGoal2()
	{
		//addSequential(new Auton_GyroAndEncoderFwd(0.7, 1200, 2.0)); //MOVE
	
		//addSequential(new chassis_TargetWithGyroPIDAndJoystick()); //TARGET WITH GYRO
		

		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1200, 2.0)); // Move to Center Goal		//TODO SET DISTANCE
     	addSequential(new auton_TurnPID(-20)); //Turn 50 Degree angle							//TODO  TEST & SET ANGLE
			
	}
}
