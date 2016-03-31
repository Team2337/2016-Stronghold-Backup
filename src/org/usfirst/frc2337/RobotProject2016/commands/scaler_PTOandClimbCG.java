package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class scaler_PTOandClimbCG extends CommandGroup {

	public scaler_PTOandClimbCG() {
		addSequential(new PTO_Activate());
		///  PTO should have a positive speed an a negative encoder target
		//	chassis_EncoderPTODrive(speed, -target)
		addParallel(new chassis_EncoderPTODrive(.5, -6000));
		addSequential(new auton_Wait(.1));
		addSequential(new shooterArm_LowerWithGyro());
		
		
	
	}
	
}
