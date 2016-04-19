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
public class Auton_GyroAndEncoderDriveTillUltrasonic extends Command {

	public double Kp = .05;
	public double yaw;
	public double distance;
	public int m_target;
	public double m_speed;
	public double m_timeout;
	public double m_rollAngle;
	public double m_distance;
	public boolean rolled = false;


		 /**
		  * Drive until Timeout or roll increases
		  * @param speed
		  * @param timeout
		  * @param distance
		  */
	  public Auton_GyroAndEncoderDriveTillUltrasonic(double speed, double timeout, double distance) {
		   	requires(Robot.chassisPID);
		   	m_timeout = timeout;
	    	m_speed = -speed;
	    	m_distance = distance;
	    }

	  
    // Called just before this Command runs the first time
    protected void initialize() {

		setTimeout(m_timeout);

		}
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yaw = -RobotMap.gyro.getYaw();
    	distance = RobotMap.chassisPIDultrasonicSensor.getRangeInches();
    	//RobotMap.chassisDrive.drive(m_speed, yaw*Kp); //TODO check yaw direction okay...
    	//RobotMap.chassisDrive.drive(m_speed, yaw*Kp); //TODO check yaw direction okay...
    	RobotMap.chassisDrive.arcadeDrive(m_speed, yaw*Kp, false); //TODO check yaw direction okay..
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return (distance < m_distance || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisPID.setBrakeMode(true);
    	Robot.chassisPID.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
