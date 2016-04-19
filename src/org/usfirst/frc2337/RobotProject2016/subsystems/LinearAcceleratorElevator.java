

package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LinearAcceleratorElevator extends Subsystem {

    private final DoubleSolenoid linAccElevatorSolenoidA = RobotMap.linearAccElevatorSolenoidA;
    //private final Solenoid linAccElevatorSolenoidB = RobotMap.linearAccElevatorSolenoidB;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
      setDefaultCommand(new linAccElevator_Retract());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Energize the jazz hands or extend the intake wrist.
     */
    public void intakeExtend() {
    	linAccElevatorSolenoidA.set(DoubleSolenoid.Value.kReverse);
    	//linAccElevatorSolenoidB.set(true);
    }
    /**
     * De-energize the jazz hands or extend the intake wrist.
     */
    public void intakeRetract() {
    	//linAccElevatorSolenoidB.set(false);
    	linAccElevatorSolenoidA.set(DoubleSolenoid.Value.kForward);

    }
    public Value getLinAccElevatorStatus() {
    	return linAccElevatorSolenoidA.get();
    }
    
}

