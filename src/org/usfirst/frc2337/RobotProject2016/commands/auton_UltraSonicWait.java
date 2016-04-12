package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class auton_UltraSonicWait extends Command {

	/* Wait for UltraSonic Sensor to be visible
	 * DISTANCE > SET_DISTANCE
	 * 
	 */
	double distance;
	double set_distance;
	public auton_UltraSonicWait(double dis) {
		set_distance = dis;
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		setTimeout(15);
	}

	protected void execute() {
		// TODO Auto-generated method stub
    	distance = RobotMap.chassisPIDultrasonicSensor.getRangeInches();
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (distance > set_distance || isTimedOut());
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
