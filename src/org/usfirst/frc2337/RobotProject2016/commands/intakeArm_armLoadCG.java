package org.usfirst.frc2337.RobotProject2016.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class intakeArm_armLoadCG extends CommandGroup {
	
	
	
	public intakeArm_armLoadCG() {
		addSequential(new intakeArm_armSetPointLoadTimeout());
		addSequential(new intake_InhaleLoad());
		addSequential(new intakeArm_armSetPointGround());
	}

	
}
