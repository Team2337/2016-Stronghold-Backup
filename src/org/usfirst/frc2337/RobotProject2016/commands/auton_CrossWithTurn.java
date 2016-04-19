package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class auton_CrossWithTurn extends CommandGroup {
    
    public  auton_CrossWithTurn(int turn) {
        addSequential(new intakeArm_armSetPointLoad());
        addSequential(new auton_UltrasonicWait(15));
        addSequential(new Auton_GyroAndEncoderDrive(0.4, -1000, 4));
        addSequential(new auton_Wait(1));
        if (turn == 1){ //Left
            addSequential(new auton_TurnPID(-90));
        } else { //Right
            addSequential(new auton_TurnPID(90));
        }
        addSequential(new auton_Wait(1));
        addSequential(new Auton_GyroAndEncoderDrive(0.7, -32000, 4));
        addSequential(new chassisShifter_HighToLow());
        addSequential(new Auton_GyroAndEncoderDrive(0.4, -5000, 5));
        addSequential(new chassisShifter_LowToHigh());
       
       
    }
}
