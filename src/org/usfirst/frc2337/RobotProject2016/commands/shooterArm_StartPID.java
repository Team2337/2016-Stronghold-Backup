
package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  shooterArm_StartPID extends Command {

	/**
	 * Sets the Lift PID subsystem to enabled.
	 */
    public shooterArm_StartPID() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooterArmPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterArmPID.startPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
