

package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class intake_InhaleLoad extends Command {

    private double m_speed;
    
    public intake_InhaleLoad() {
        requires(Robot.intake);
        setTimeout(4);
    }


    protected void initialize() {
    	m_speed = Robot.intake.inhaleSpeed;
    }


    protected void execute() {
    	
    		Robot.intake.setMotor(Robot.intake.loadSpeed); 
    	

    }

    protected boolean isFinished() {
    	if ((!Robot.intake.getBallSensorState()) || isTimedOut()) {
    		return true;
    	} else {
    		return false;
    	}
    	

    }

    protected void end() {
    	Robot.intake.setMotor(0);
    }

   
    protected void interrupted() {
    	this.end();
    }
}
