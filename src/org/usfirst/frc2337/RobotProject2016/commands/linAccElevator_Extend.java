
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject2016.Robot;

/**
 *
 */
public class linAccElevator_Extend extends Command {

    public linAccElevator_Extend() {
    	requires(Robot.linAccElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.intakeArmPID.getPosition() < Robot.intakeArmPID.intakeRollerOffPosition) {
    		Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.intakePosition);
    	}
    	Robot.linAccElevator.intakeExtend();
    	//setTimeout(5);
    	
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    	//return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
