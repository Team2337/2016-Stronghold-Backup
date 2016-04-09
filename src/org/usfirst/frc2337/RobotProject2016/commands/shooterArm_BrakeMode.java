
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class shooterArm_BrakeMode extends Command {

 
    public shooterArm_BrakeMode() {


        requires(Robot.shooterArmPID);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shooterArmPIDMotorA.enableBrakeMode(true);
    	RobotMap.shooterArmPIDMotorB.enableBrakeMode(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
