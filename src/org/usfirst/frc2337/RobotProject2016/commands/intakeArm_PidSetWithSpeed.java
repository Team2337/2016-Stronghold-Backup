
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class  intakeArm_PidSetWithSpeed extends Command {

    int setpoint;
	double upSpeed, downSpeed = .5; //arm Speed 
    
    public intakeArm_PidSetWithSpeed(int setpoint) {

    	requires(Robot.intakeArmPID);
    	
    	this.setpoint = setpoint;
    }
    
    public intakeArm_PidSetWithSpeed(int setpoint, double upSpeed, double downSpeed) {

    	requires(Robot.intakeArmPID);
    	   	
    	//Make the variables for this command usable through out it
    	this.setpoint = setpoint;
    	this.upSpeed = upSpeed;
    	this.downSpeed = downSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.intakeArmPID.getPIDController().setOutputRange(downSpeed, upSpeed);
        Robot.intakeArmPID.setSetpoint(setpoint); //Run command in Lift Subsytem    	    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return (Robot.intakeArmPID.onTarget());
   	 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeArmPID.getPIDController().setOutputRange(Robot.intakeArmPID.teleopArmSpeedDown, Robot.intakeArmPID.teleopArmSpeedUp);
    	RobotMap.intakeArmPIDMotorA.set(0);
    	Robot.intakeArmPID.enable();
    	Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
