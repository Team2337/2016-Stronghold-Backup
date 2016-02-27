package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_ReleaseBall extends CommandGroup {
	
	public auton_ReleaseBall() {
		//addSequential(new Auton_GyroAndEncoderFwd(0.7, 1200, 5.0));
		addParallel(new auton_IntakeExhale(4));
		addSequential(new Auton_GyroAndEncoderDrive(0.7, -1200, 5.0));
	}
}
