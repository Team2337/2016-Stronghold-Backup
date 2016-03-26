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
public class Auton_GyroAndEncoderDriveTillRoll extends Command {

	public double Kp = .05;
	public double yaw;
	public double roll;
	public int m_target;
	public double m_speed;
	public double m_timeout;
	public double m_rollAngle;
	public boolean rolled = false;

	  public Auton_GyroAndEncoderDriveTillRoll(double speed) {
	    	requires(Robot.chassisPID);
	    	setTimeout(5);
	    	m_speed = speed;
	    	m_target = Robot.prefs.getInt("AutonEncDist", 60);
	    }
	  public Auton_GyroAndEncoderDriveTillRoll(double speed, int encoderTarget) {
		   	requires(Robot.chassisPID);
	    	setTimeout(5);
	    	m_target = encoderTarget;
	    	m_speed = speed;
	    	
	    }
		 /**
		  * Drive until Timeout or roll increases
		  * @param speed
		  * @param timeout
		  * @param rollAngle
		  */
	  public Auton_GyroAndEncoderDriveTillRoll(double speed, double timeout, double rollAngle) {
		   	requires(Robot.chassisPID);
		   	m_timeout = timeout;
	    	m_speed = -speed;
	    	m_rollAngle = rollAngle;
	    }

	  public Auton_GyroAndEncoderDriveTillRoll(double speed, int encoderTarget, double timeout) {
		   	requires(Robot.chassisPID);
		   	m_timeout = timeout;
	    	m_target = encoderTarget;
	    	m_speed = speed;
	    }
	  
    // Called just before this Command runs the first time
    protected void initialize() {

		setTimeout(m_timeout);
		
		if (m_target > 0 ){ //Robot.chassisPID.readLeftEncoder()
			m_speed = - m_speed;
			}
		}
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yaw = -RobotMap.gyro.getYaw();
    	roll = RobotMap.gyro.getRoll();
    	//RobotMap.chassisDrive.drive(m_speed, yaw*Kp); //TODO check yaw direction okay...
    	//RobotMap.chassisDrive.drive(m_speed, yaw*Kp); //TODO check yaw direction okay...
    	RobotMap.chassisDrive.arcadeDrive(m_speed, yaw*Kp, false); //TODO check yaw direction okay...

    	
    	//System.out.println(m_target);
       // SmartDashboard.putNumber("auto Speed", m_speed);
      //  SmartDashboard.putNumber("auto Turn", yaw*Kp);
    	SmartDashboard.putBoolean("Rolled" , rolled);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return (roll < m_rollAngle || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	rolled = true;
    	//RobotMap.chassisPIDchassisLeft1.enableBrakeMode(true);
    	//RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
    	Robot.chassisPID.setBrakeMode(true);
    	Robot.chassisPID.stopMotors();
    	//RobotMap.chassisPIDchassisLeft1.enableBrakeMode(true);
    	//RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
