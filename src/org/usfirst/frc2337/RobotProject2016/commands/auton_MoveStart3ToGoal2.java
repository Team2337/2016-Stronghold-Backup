package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_MoveStart3ToGoal2 extends CommandGroup {

	/**
	 * MOVE TO GOAL #2
	 * --------------
	 * 
	 * 
	 */
	public auton_MoveStart3ToGoal2()
	{
		addSequential(new Auton_GyroAndEncoderFwd(0.7, 1200, 2.0)); //MOVE
	
		addSequential(new chassis_TargetWithGyroPIDAndJoystick()); //TARGET WITH GYRO
			
	}
}
