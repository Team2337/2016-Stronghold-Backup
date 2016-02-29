package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_IntakeCG extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_IntakeCG()
	{
		addSequential(new shooterArm_armSetPointBase());  	//lower to pick up ball
															//wait or sense ball???
		addParallel(new shooterArm_armSetPointTravel());  	//move arm to travel
		addSequential(new Auton_GyroAndEncoderReverse(0.4, 100, 1.0));  //back up 
		addSequential(new doNothing (true, 5.0));			//turn 180...sean's turn???
		addSequential(new Auton_GyroAndEncoderFwd(0.5, 300, 2.0));  //finish reach
		
	}
}
