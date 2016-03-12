
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

	
    public final double inhaleSpeed = 0.8;
    public final double inhaleSlowSpeed = 0.8;
    private final double exhaleSpeed = -0.8;
    //private final double prepSpeed = 0.7;

    private final CANTalon intakeMotorA = RobotMap.intakeintakeMotorA;
    private final CANTalon intakeMotorB = RobotMap.intakeintakeMotorB;
    private final DigitalInput leftBallSensor = RobotMap.intakeLeftBallSensor;
    private final DigitalInput rightBallSensor = RobotMap.intakeRightBallSensor;
    private final DigitalInput gotBallSensor = RobotMap.intakeGotBallSensor;
    		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new intake_DoNothing());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     *Sets the variable speed of the Intake motor based on the input variable 
     *
     * @param speed(double)
     */
   public void setMotor(double speed) {
	   intakeMotorA.set(speed);
	   intakeMotorB.set(-speed);
   }
   /**
    * Sets Intake motors to inhale at the variable inhaleSpeed which is defined at the top of the Intake subsystem
    */
   public void intakeInhale() {
	   intakeMotorA.set(inhaleSpeed);
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
    * Set fast ramp rate, in volts per second.
    */
   public void fastRampRate() {
	  // RobotMap.intakeintakeMotorB.setVoltageRampRate(600);
   }
   /**
    * Set slow ramp rate, in volts per second.
    */
   public void slowRampRate() {
	  // RobotMap.intakeintakeMotorB.setVoltageRampRate(6);
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
   public boolean getLeftBallSensorState() {
	   //RobotMap.leftBallSensorState = leftBallSensor.get();
	   return leftBallSensor.get();
   }
   /**
    *  See if the ball is center on right side 
    * @return
    */
   public boolean getRightBallSensorState() {
	   //RobotMap.rightBallSensorState = rightBallSensor.get();
	   return rightBallSensor.get();
   }
   /**
    *  See if a ball is in the intake
    * @return
    */
   public boolean gotBallSensorState() {
	   //RobotMap.gotBallSensorState = gotBallSensor.get();
	   return gotBallSensor.get();
   }
   
   
}

