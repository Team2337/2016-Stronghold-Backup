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
    	addSequential(new intakeArm_armSetPointAutonTravel());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 65029, 8.0));  //22029		//TODO   NEED TO SET DISTANCE 
		addSequential(new intake_Exhale());
		addSequential(new intake_DoNothing());
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 55000, 8.0));
		addSequential(new auton_TurnPID(180));                            //Turns robot after it re-crosses the defense
		//addSequential(new intakeArm_armSetPointIntake());
	}
}
