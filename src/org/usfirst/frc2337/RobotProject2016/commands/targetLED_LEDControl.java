package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class targetLED_LEDControl extends Command {
	
	double centerpnt = RobotMap.centerpnt;
	double[] defaultValue = new double[0];	
	double firstcenter;
	double deadband = 5;
	int blinkCounter = 0;
	int blinkCounterChange = 100;
	int blinkCounterReset = 200;
	
	public targetLED_LEDControl() {
		requires(Robot.targetLED);
	}
	@Override
	protected void initialize() {
	

	}

	@Override
	protected void execute() {
		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		for (double centerX : centerx) {
			System.out.println(centerX + " ");
			firstcenter = centerx[0];
		}
		if (firstcenter != 0) {
				if (firstcenter > centerpnt - deadband) {
					Robot.targetLED.rightArmLEDOn();
				} else {
					Robot.targetLED.rightArmLEDOff();
		
				}
				
				if (firstcenter < centerpnt + deadband) {
					Robot.targetLED.leftArmLEDOn();
				} else {
					Robot.targetLED.leftArmLEDOff();
				} 
		} else {
			
			if (blinkCounter > blinkCounterChange) {
				Robot.targetLED.leftArmLEDOn();
				Robot.targetLED.rightArmLEDOff();
					if (blinkCounter > blinkCounterReset) {
						blinkCounter = 0;
					}
				blinkCounter++;	
			} else {
				Robot.targetLED.rightArmLEDOn();
				Robot.targetLED.leftArmLEDOff();
				blinkCounter++;
			}
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
