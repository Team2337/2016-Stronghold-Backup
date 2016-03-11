package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.portWheels_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class PortWheels extends Subsystem {

	private final CANTalon motorA = RobotMap.portWheelMotorA;
	//private final CANTalon motorB = RobotMap.portWheelMotorB;
	private final double raiseSpeed = 1;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new portWheels_DoNothing());
	}
	public void portWheelsActivate(){
		motorA.set(raiseSpeed);
	}
	public void stopMotors(){
		motorA.set(0);
	}

}
