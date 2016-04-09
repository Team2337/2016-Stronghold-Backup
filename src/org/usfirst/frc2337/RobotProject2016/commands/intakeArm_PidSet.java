

package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject2016.Robot;

/**
 *
 */
public class  intakeArm_PidSet extends Command {

    private int setpoint;
     
    public intakeArm_PidSet(int setpoint) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.intakeArmPID);
    	
    	//Make the variables for this command usable through out it
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Run command in Lift Subsytem
        Robot.chassisPID.setSetpoint(setpoint); 	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return (Robot.chassisPID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeArmPID.enable();
    	Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.getPosition());
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
