
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject2016.Robot;

/**
 *
 */
public class intakeWrist_Extend extends Command {

    public intakeWrist_Extend() {
    	requires(Robot.intakeWrist);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeWrist.intakeExtend();
    	
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
