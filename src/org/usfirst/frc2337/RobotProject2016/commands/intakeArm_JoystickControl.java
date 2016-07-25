
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class  intakeArm_JoystickControl extends Command {

	public double armSpeedFactor = 0.5;    //multiply joystick to reduce arm speed
	private double deadBand = 0.2;
	private double armJoystickY;
	private double travelError = 1.1;
	
    public intakeArm_JoystickControl() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.intakeArmPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.setPointSet = false; 
    	Robot.intakeArmPID.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	armJoystickY = Robot.oi.operatorJoystick.getRawAxis(1);
    	armJoystickY = -armJoystickY;
    	
    	//Check the joystick for a dead band, if in do...
    	if ((armJoystickY > -deadBand ) && (armJoystickY < deadBand)) { //Dead band
    		//System.out.println("in deadband");
    		armJoystickY = 0;  //Set Motor to 0 if in dead band
    		
    		
    		if (Robot.intakeArmPID.getPosition() >  Robot.intakeArmPID.intakePosition) {
    			Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.intakePosition);
    			Robot.intakeArmPID.disable();
    		}
    		
    		/*
    		if (RobotMap.travelMode  &&((Robot.shooterArmPID.getSetpoint() - Robot.shooterArmPID.getPosition()) > travelError) ) {
    			Robot.shooterArmPID.enable();
    		} else if (RobotMap.travelMode) {
    			Robot.shooterArmPID.disable();
    		}
    			 */
    		//If setPointSet, is not
    		// set (so false), run this ONCE and
    	
    		//enable the Lift PID and set the PID to where the lift is
    		if (!RobotMap.setPointSet) {
    			Robot.intakeArmPID.enable(); //Enable Lift Pid
    			Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.getPosition()); //Set the Lift
    			//Make setPointSet true so this statement true so it won't loop
    			RobotMap.setPointSet = true; 
    		}
    	} else {		//If the Joystick is out of the dead band, do..
    	//	System.out.println("out of deadband");
    		Robot.intakeArmPID.disable(); //Disable the Lift PID
    		//Make the motor be controlled by the joystick but at a multiplied speed
    		if  ((armJoystickY > 0) && (Robot.intakeArmPID.getPosition() < Robot.intakeArmPID.armToplimit)) {
    			RobotMap.intakeArmPIDMotorA.set(armSpeedFactor * armJoystickY); //Positive
    			
    		} else if ((armJoystickY < 0) && (Robot.intakeArmPID.getPosition() > Robot.intakeArmPID.armBottomlimit)) {
    			RobotMap.intakeArmPIDMotorA.set(armSpeedFactor * armJoystickY);	//Negative

    		} else  {
    			RobotMap.intakeArmPIDMotorA.set(0);
    		}
    		//Make the setPointSet to false, so if in dead band, the PID can reset
    		RobotMap.setPointSet = false;
    		//RobotMap.travelMode = false;
    	}	// End Deadband
    
    	SmartDashboard.putBoolean("setPointSet?" , RobotMap.setPointSet);
    }		// End Method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
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
