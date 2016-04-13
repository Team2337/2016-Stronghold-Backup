package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_CrossThenReverse extends CommandGroup {

	/**
	 * THIS WILL INTAKE BALL FROM MIDLINE
	 * ----------------------------------
	 * 
	 * 
	 */
	public auton_CrossThenReverse()
	{
		//addSequential(new shooterRetract_Prep());				//prep shooter retracter
    	//addParallel(new intake_Inhale());  			//activate intake and run parallel as it does not finish...
    	//addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 65029, .1));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new auton_IntakeExhale(2));
		addSequential(new intake_DoNothing());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, -55000, .1));
		addSequential(new auton_Wait(1));
		addSequential(new auton_TurnPID(180));                            //Turns robot after it re-crosses the defense
		//addSequential(new auton_TurnAngle(180));
		//addSequential(new intakeArm_armSetPointIntake());
	}
}
