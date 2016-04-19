package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class auton_UltrasonicWait extends Command {

	double distance;
	double set_distance;
    public auton_UltrasonicWait(double dis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	set_distance = dis;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(15);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	distance = RobotMap.chassisPIDultrasonicSensor.getRangeInches();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (distance> set_distance || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
