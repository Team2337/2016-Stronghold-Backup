
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ChassisShifter extends Subsystem {

    private final Solenoid shiftSolenoid = RobotMap.chassisShiftershiftSolenoid;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {


    }
    /**
     * Change to high gear
     */
    public void highGear() {
    	shiftSolenoid.set(false);
    }
    /**
     * Change to low gear
     */
    public void lowGear() {
    	shiftSolenoid.set(true);
    }
    /**
     * Get the status of Shifter Solenoid 
     * @return
     */
    public boolean getShiftStatus() {
    	return shiftSolenoid.get();
    }
    
}

