
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class auton_intake_Exhale extends Command {


    public auton_intake_Exhale() {

        requires(Robot.intake);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.intake.intakeExhale();
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
