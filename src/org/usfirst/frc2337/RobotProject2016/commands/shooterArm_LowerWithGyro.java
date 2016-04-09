package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class shooterArm_LowerWithGyro extends PIDCommand {

	

	public shooterArm_LowerWithGyro() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .175, 0, 0);
		getPIDController().setAbsoluteTolerance(1.0);
		
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-1, 1);
       // LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.getRoll();
	}

	protected void usePIDOutput(double output) {
		RobotMap.shooterArmPIDMotorA.pidWrite(output);
		SmartDashboard.putNumber("PID Output", output);

	}

	protected void initialize() {
		
		if (Robot.oi.getoperatorControls().getRawButton(10)) {
			Robot.shooterArmPID.disable();
			this.setSetpoint(0);
		}

		
	}

	protected void execute() {
		//SmartDashboard.putNumber("PID Error", this.getPIDController().getError());
		
	}

	protected boolean isFinished() {
		if (Robot.oi.getoperatorControls().getRawButton(10)) {
			return false;
		} else {
			return true;
		}
	}

	protected void end() {

	}

	protected void interrupted() {
		this.end();
	}

}
