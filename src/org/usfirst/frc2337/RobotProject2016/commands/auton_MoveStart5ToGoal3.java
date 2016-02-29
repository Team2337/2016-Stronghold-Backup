package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_MoveStart5ToGoal3 extends CommandGroup {

	/**
	 * MOVE TO GOAL #2
	 * --------------
	 * 
	 * 
	 */
	public auton_MoveStart5ToGoal3()
	{
		//addSequential(new Auton_GyroAndEncoderFwd(0.7, 1200, 2.0)); //MOVE
	
		//addSequential(new chassis_TargetWithGyroPIDAndJoystick()); //TARGET WITH GYRO
		

		addSequential(new Auton_GyroAndEncoderDrive(0.7, 2100, 2.0)); // Move to Right Goal		//TODO SET DISTANCE
     	addSequential(new auton_TurnPID(-35)); //Turn 50 Degree angle							//TODO  TEST & SET ANGLE
			
	}
}
