package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class scaler_ExtendAndRaiseArmCG extends CommandGroup {
	
	public scaler_ExtendAndRaiseArmCG() {
		addSequential(new scaler_pinPullOut());
		addSequential(new shooterArm_armSetPointScale());
	
	}


}
