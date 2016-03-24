package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class chassis_TargetWithGyroPID extends PIDCommand {

	double[] defaultValue = new double[0];	

	double centerpnt = 172;
	public double firstcenter, secondcenter;
	double deadband = 10;
	double turnValue, targetAngle;
	double turnSpeed = 0.4;
	double Kp = .003;
	double degreeConversion = 0.04;
	double setpoint;
	double timeout = 2.5;
	

	public chassis_TargetWithGyroPID() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .175, 0, 0.02);
		getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
       // LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.pidGet();
	}

	protected void usePIDOutput(double output) {
		//Robot.chassisPID.arcadeDrive(0, output);
		RobotMap.chassisPIDchassisLeft1.set(-output);
	}

	protected void initialize() {
		RobotMap.gyro.reset();
		RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
		RobotMap.chassisPIDchassisRight2.enableBrakeMode(true);
		this.setTimeout(timeout);
		
		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		System.out.print("centerX: ");
			for (double centerX : centerx) {
				System.out.print(centerX + " ");
				firstcenter = centerx[0];
			System.out.println();
			}
			if (firstcenter == 0) {
				System.out.println("This is not the target you are looking for, Move along...");
			} else {
				turnValue = firstcenter - centerpnt;		
				targetAngle = turnValue/RobotMap.gyroConversion;
	
				System.out.println("TurnValues: FirstCenter "  + firstcenter + " - " + "Centerpoint " + centerpnt + " = " + turnValue);
				System.out.println("targetAngle: TurnValue " + turnValue + " divided by " + RobotMap.gyroConversion + " equals " + targetAngle);
				this.setSetpoint(targetAngle);
			}
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}

	protected void end() {
		System.out.println("done" + RobotMap.gyro.getAngle());
		Robot.chassisPID.stopMotors();
		RobotMap.chassisPIDchassisRight1.enableBrakeMode(false);
		RobotMap.chassisPIDchassisRight2.enableBrakeMode(false);
	}

	protected void interrupted() {
		this.end();
	}

}
