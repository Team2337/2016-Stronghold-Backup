package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class Auton_GyroFwd extends Command {

	public double speed = 1.0/2;
	public double Kp = 0.03;
	public double yaw;

    public Auton_GyroFwd() {
    	requires(Robot.chassisPID);
    	setTimeout(15);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yaw = RobotMap.gyro.getAngle();
    	RobotMap.chassisDrive.drive(speed, yaw*Kp);
    	Timer.delay(0.004);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
