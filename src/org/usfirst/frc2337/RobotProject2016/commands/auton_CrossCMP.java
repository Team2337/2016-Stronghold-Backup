package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_CrossCMP extends CommandGroup {

	//int delay = RobotMap.autondelay;
	//int postion = RobotMap.autonPosition;
	//int shot = RobotMap.autonshot;
	
	public auton_CrossCMP(int delay, int postion, int shot)
	{
		//System.out.println("shot " + RobotMap.autonshot + " Pos " + RobotMap.autonPosition + " " + RobotMap.autondelay);
		if (delay == 5) {
			addSequential(new auton_Wait(5.0));
		} else if (delay == 8) {
			addSequential(new auton_Wait(8.0));
		}
		addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, -55029, 8.0));  // -65029
		
		
 	
	}
}
