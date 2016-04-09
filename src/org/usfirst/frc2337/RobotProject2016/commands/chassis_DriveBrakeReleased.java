package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class chassis_DriveBrakeReleased extends Command {

    public chassis_DriveBrakeReleased() {

    	requires(Robot.chassisPID);

    }


    protected void initialize() {
    	Robot.chassisPID.setBrakeMode(false);
    	
    }


    protected void execute() {
    }


    protected boolean isFinished() {
        return true;
    }


    protected void end() {
    }


    protected void interrupted() {
    	
    }
	
	
}
