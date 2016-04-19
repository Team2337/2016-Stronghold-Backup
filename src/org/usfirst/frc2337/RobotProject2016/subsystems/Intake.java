
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * 
 *
 */
public class Intake extends Subsystem {

	
    public final double inhaleSpeed = 1.0;
    private final double exhaleSpeed = 1.0;
    public final double loadSpeed = 0.5;

    private final CANTalon intakeMotorA = RobotMap.intakeintakeMotorA;
    private final CANTalon intakeMotorB = RobotMap.intakeintakeMotorB;
    private final DigitalInput ballSensor = RobotMap.intakeBallSensor;


    public void initDefaultCommand() {
        setDefaultCommand(new intake_DoNothing());

    }
    
    /**
     *Sets the variable speed of the Intake motor based on the input variable 
     *
     * @param speed(double)
     */
   public void setMotor(double speed) {
	   intakeMotorA.set(-speed);
	   intakeMotorB.set(-speed);
   }
   /**
    * Sets Intake motors to inhale at the variable inhaleSpeed which is defined at the top of the Intake subsystem
    */
   public void intakeInhale() {
	   intakeMotorA.set(-inhaleSpeed);
	   intakeMotorB.set(-inhaleSpeed);
   }
   /**
    * Sets Intake motors to exhale at the variable exhaleSpeed which is defined at the top of the Intake subsystem
    */
   public void intakeExhale() {
	   intakeMotorA.set(exhaleSpeed);
	   intakeMotorB.set(exhaleSpeed);
   }
   /**
    * Sets the intake rollers to both roll in 
    */
   public void intakeInhaleOffGround() {
	   intakeMotorA.set(inhaleSpeed);
	   intakeMotorB.set(inhaleSpeed);
   }
   /**
    * Sets the motor speed for the intake to zero thereby stopping the intake. 
    */
   public void stopMotors() {
	   intakeMotorA.set(0);
	   intakeMotorB.set(0);
   }
   /**
    * See if the ball is center on left side 
    * @return
    */
   public boolean getBallSensorState() {
	   return !ballSensor.get();
   }

}

