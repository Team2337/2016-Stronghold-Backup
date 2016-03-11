

package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class intake_ActivateMotors extends Command {

    private double m_speed;
    boolean ballState;
    
    public intake_ActivateMotors() {
        requires(Robot.intake);
    }


    protected void initialize() {
    	RobotMap.okToShoot = false;
    	m_speed = Robot.intake.inhaleSlowSpeed;
    	
    	Robot.intake.fastRampRate();
    }


    protected void execute() {

    	ballState = Robot.intake.gotBallSensorState();

    		if (ballState == true) {
    			m_speed = Robot.intake.inhaleSlowSpeed;
    			RobotMap.okToShoot = true;
    		} else {
    			m_speed = Robot.intake.inhaleSpeed;
    			RobotMap.okToShoot = false;
    		}
    	
  	
    	Robot.intake.setMotor(m_speed);
    	
    }

    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    }

   
    protected void interrupted() {
    	Robot.intake.slowRampRate();
    	Robot.intake.setMotor(0);
    }
}
