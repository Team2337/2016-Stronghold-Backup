package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class auton_TurnPIDDrive extends PIDCommand {
	

	double turnValue, targetAngle, leftJoystick, m_speed, m_timeout;
	int targetDistance;


	public auton_TurnPIDDrive(double speed, int distance, double timeout, double angle) {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .03, 0, 0.02);
		getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
        targetAngle = angle;
        targetDistance = distance;
        m_speed = speed;
        m_timeout = timeout;
        
      //  LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.pidGet();
	}


	protected void usePIDOutput(double output) {
		//RobotMap.chassisPIDchassisLeft1.set(-output);	
		if (Robot.chassisPID.encoderOnTargetLeft(targetDistance)) {
			m_speed = 0;
		}
		Robot.chassisPID.arcadeDrive(m_speed, output);
	}

	protected void initialize() {
		Robot.chassisPID.resetDriveEncoder();
		Robot.chassisPID.resetGyro();
		setTimeout(m_timeout);
		this.setSetpoint(targetAngle);
		if (targetDistance > 0 ){ 
			m_speed = - m_speed;
		}
		//RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
		Robot.chassisPID.setBrakeMode(true);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() ||	(getPIDController().onTarget() && Robot.chassisPID.encoderOnTargetLeft(targetDistance)));
	}

	protected void end() {
		//System.out.println("done" + RobotMap.gyro.getAngle());
		Robot.chassisPID.stopMotors();
		//RobotMap.chassisPIDchassisRight1.enableBrakeMode(false);
		Robot.chassisPID.setBrakeMode(false);
	}

	protected void interrupted() {
		this.end();
	}

}
