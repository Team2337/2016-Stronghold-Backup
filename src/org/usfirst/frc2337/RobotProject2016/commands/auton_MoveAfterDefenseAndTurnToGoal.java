package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_MoveAfterDefenseAndTurnToGoal extends CommandGroup {

	/**
	 * MOVE TO GOAL #1
	 * --------------
	 * 
	 * 
	 */
	public auton_MoveAfterDefenseAndTurnToGoal(double speed, int distance, double timeout, double angle)
	{
		addSequential(new Auton_GyroAndEncoderDrive(speed, distance, timeout)); // move forward    //TODO SET DISTANCE
    	addSequential(new auton_TurnPID(angle)); //Turn 50 Degree angle					//TODO  TEST & SET ANGLE
    	
    	//TARGET WITH GRIP/VISION
     	//addSequential(new chassis_TargetWithGyroPID()); //turn towards goal
     	
     	
		
	}
}
