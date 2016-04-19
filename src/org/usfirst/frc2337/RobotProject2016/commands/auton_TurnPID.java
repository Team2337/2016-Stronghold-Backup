package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class auton_TurnPID extends PIDCommand {
	

	double turnValue, targetAngle, leftJoystick;
	private static double timeout = 3;


	public auton_TurnPID(double angle) {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .03, 0, 0.02);
		getPIDController().setAbsoluteTolerance(1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-.6, .6);
        targetAngle = angle;
      //  LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.pidGet();
	}


	protected void usePIDOutput(double output) {
		//RobotMap.chassisPIDchassisLeft1.set(-output);	
		if (Math.abs(output)< 0.32) {
			output = (output > 1 ? 0.32: -0.32);
		}
		Robot.chassisPID.arcadeDrive(0, output);
	}

	protected void initialize() {
		RobotMap.gyro.reset();
		this.setSetpoint(targetAngle);
		setTimeout(timeout);
		//RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
		Robot.chassisPID.setBrakeMode(true);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
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
