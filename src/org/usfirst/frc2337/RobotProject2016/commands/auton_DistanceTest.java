package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_DistanceTest extends CommandGroup {


	public auton_DistanceTest()
	{

		addSequential(new Auton_GyroAndEncoderDriveTillUltrasonic(0.5, 15.0, 24));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new Auton_GyroAndEncoderDrive(-.5, .1))
		
;	}
}
