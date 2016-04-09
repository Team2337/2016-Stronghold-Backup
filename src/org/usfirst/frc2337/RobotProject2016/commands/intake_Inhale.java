

package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class intake_Inhale extends Command {

    private double m_speed;
    
    public intake_Inhale() {
        requires(Robot.intake);
    }


    protected void initialize() {
    	m_speed = Robot.intake.inhaleSpeed;
    }


    protected void execute() {
    	
    	if ((Robot.intakeArmPID.getPosition() > Robot.intakeArmPID.intakeRollerOffPosition) &&  Robot.intake.getBallSensorState()) {
    		Robot.intake.setMotor(0); 
    	} else if (Robot.intakeArmPID.getPosition() < Robot.intakeArmPID.intakeRollerOffPosition) {
    		Robot.intake.setMotor(Robot.intake.loadSpeed); 
    	
    	} else {
    		Robot.intake.setMotor(m_speed);  
    	}
    }

    protected boolean isFinished() {

    		return false;
    	

    }

    protected void end() {
    	Robot.intake.setMotor(0);
    }

   
    protected void interrupted() {
    	this.end();
    }
}
