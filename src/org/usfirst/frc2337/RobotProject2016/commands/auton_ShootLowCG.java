package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_ShootLowCG extends CommandGroup{
	
	/**
	 * SHOOT INTO LOW GOAL
	 * -------------------
	 * 
	 * 
	 */
	public auton_ShootLowCG()
	{
		addSequential(new intakeArm_armSetPointBase());  	//needed??? are on or off batten?????
     	addSequential(new auton_IntakeExhale(2)); 
	}
}
