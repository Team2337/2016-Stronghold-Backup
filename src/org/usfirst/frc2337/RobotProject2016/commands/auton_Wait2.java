package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Wait for a specified time.
 * 
 * @param seconds The time, in seconds, to wait for.
 */

public class  auton_Wait2 extends Command {

	private double seconds;
	
    public auton_Wait2(double seconds) {
    	this.seconds = seconds;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("22222222222222222");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    }
}
