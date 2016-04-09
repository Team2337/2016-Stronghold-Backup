

package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LinearAcceleratorElevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
      setDefaultCommand(new linAccElevator_DoNothing());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Energize the jazz hands or extend the intake wrist.
     */
    public void intakeExtend() {
    	linAccElevatorSolenoid.set(true);
    }
    /**
     * De-energize the jazz hands or extend the intake wrist.
     */
    public void intakeRetract() {
    	linAccElevatorSolenoid.set(false);
    }
    public boolean getLinAccElevatorStatus() {
    	return linAccElevatorSolenoid.get();
    }
    
}

