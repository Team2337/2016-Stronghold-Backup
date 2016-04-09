package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class scaler_PTOandClimbCG extends CommandGroup {

	public scaler_PTOandClimbCG() {
		addSequential(new PTO_Activate());
		addSequential(new shooterArm_BrakeMode());
		
		
		
	
	}
	
}
