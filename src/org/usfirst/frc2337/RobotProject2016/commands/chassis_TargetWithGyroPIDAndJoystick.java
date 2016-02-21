package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class chassis_TargetWithGyroPIDAndJoystick extends PIDCommand {
	
	double[] defaultValue = new double[0];	

	double centerpnt = 172;
	double firstcenter, secondcenter;
	double deadband = 10;
	double turnValue, targetAngle, leftJoystick;
	double turnSpeed = 0.4;
	double Kp = .003;
	double degreeConversion = 0.04;
	double setpoint;
	double timeout = 5.0;

	public chassis_TargetWithGyroPIDAndJoystick() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .13, 0, 0.02);
		getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
      //  LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.pidGet();
	}


	protected void usePIDOutput(double output) {
		leftJoystick =  Robot.oi.driverJoystick.getRawAxis(1);
		Robot.chassisPID.arcadeDrive(leftJoystick, output);	
	}

	protected void initialize() {
		RobotMap.gyro.reset();

		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		for (double centerX : centerx) {
			System.out.println(centerX + " ");
			firstcenter = centerx[0];
		}
		turnValue = firstcenter - centerpnt;
		targetAngle = turnValue/RobotMap.gyroConversion;
		System.out.println("TurnValues: FirstCenter "  + firstcenter + " - " + "Centerpoint " + centerpnt + " = " + turnValue);
		System.out.println("targetAngle: TurnValue " + turnValue + " divided by " + RobotMap.gyroConversion + " equals " + targetAngle);
		this.setSetpoint(targetAngle);	
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("done" + RobotMap.gyro.getAngle());
		Robot.chassisPID.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}

}
