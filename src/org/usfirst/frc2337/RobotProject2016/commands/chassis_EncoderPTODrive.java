package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *  Drives forward/reverse at 'speed' to a given 'target', either forward or reverse,
 *  using the encoder(reset to 0) for distance and gyro to drive straight.
 *  Can also inout a timeout, otherwise it will default to 5 seconds.
 */
public class chassis_EncoderPTODrive extends Command {

	public int m_target;
	public double m_speed;
	public double m_timeout;

	  public chassis_EncoderPTODrive(double speed) {
	    	requires(Robot.chassisPID);
	    	setTimeout(5);
	    	m_speed = speed;
	    }
	  public chassis_EncoderPTODrive(double speed, int encoderTarget) {
		   	requires(Robot.chassisPID);
	    	setTimeout(5);
	    	m_target = encoderTarget;
	    	m_speed = speed;
	    }
		 
	  public chassis_EncoderPTODrive(double speed, int encoderTarget, double timeout) {
		   	requires(Robot.chassisPID);
		   	m_timeout = timeout;
	    	m_target = encoderTarget;
	    	m_speed = speed;
	    }
	  
    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.chassisPID.resetDriveEncoder();

    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    	RobotMap.chassisDrive.drive(m_speed, 0); //TODO check yaw direction okay...

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return Robot.chassisPID.encoderOnTargetLeft(m_target);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.chassisPIDchassisLeft1.enableBrakeMode(true);
    	RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
    	Robot.chassisPID.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
